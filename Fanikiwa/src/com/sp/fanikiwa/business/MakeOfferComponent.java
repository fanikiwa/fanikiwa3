package com.sp.fanikiwa.business;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.Enums.OfferStatus;
import com.sp.fanikiwa.Enums.OffereeIdType;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.api.MemberEndpoint;
import com.sp.fanikiwa.api.OfferEndpoint;
import com.sp.fanikiwa.business.MakeOffer.EmailOfferee;
import com.sp.fanikiwa.business.MakeOffer.GroupOfferee;
import com.sp.fanikiwa.business.MakeOffer.MemberOfferee;
import com.sp.fanikiwa.business.MakeOffer.Offeree;
import com.sp.fanikiwa.business.MakeOffer.OffereeToken;
import com.sp.fanikiwa.business.MakeOffer.TelephoneOfferee;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.OfferDTO;
import com.sp.fanikiwa.entity.OfferModel;
import com.sp.fanikiwa.entity.OfferReceipient;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.utils.GLUtil;
import com.sp.utils.MailUtil;
import com.sp.utils.OfferUtil;
import com.sp.utils.StringExtension;

public class MakeOfferComponent {

	private static double MINIMUM_OFFER_AMOUNT = 1000.00;

	public RequestResult MakeOffer(OfferDTO offerDto) throws Exception {
		if (offerDto.getOfferType().toUpperCase().equals("L")) {
			return MakeLendOffer(offerDto);
		} else {
			return MakeBorrowOffer(offerDto);
		}
	}
	
	private RequestResult MakeBorrowOffer(OfferDTO offerDto) throws Exception {
		if (ValidateOffer(offerDto)) {
			return createOfferDTO(offerDto);
		} else {
			RequestResult ret = new RequestResult();
			ret.setResult(false);
			ret.setResultMessage("Invalid offer");
			return ret;
		}

	}

	private RequestResult MakeLendOffer(OfferDTO offerDto) throws Exception {
		if (ValidateOffer(offerDto)) {
			// Step 1 - Block funds.
			Member member = SearchMemberByEmail(offerDto.getEmail());

			// calls GLs funds block service.
			AccountEndpoint sPostingClient = new AccountEndpoint();
			if (GLUtil.GetAvailableBalance(member.getCurrentAccount()) < offerDto
					.getAmount())
				throw new ForbiddenException("Insufficient funds");

			// BlockFunds function checks all account status before the actual
			// block
			sPostingClient.BlockFunds(member.getCurrentAccount(),
					offerDto.getAmount());

			// Step 2 - Calling Create on Offer.

			return createOfferDTO(offerDto);
		} else {
			RequestResult ret = new RequestResult();
			ret.setResult(false);
			ret.setResultMessage("Invalid offer");
			return ret;
		}
	}

	private boolean ValidateOffer(OfferDTO offerDto) {
		boolean res = true;
		if (offerDto.getAmount() < MINIMUM_OFFER_AMOUNT)
			res = false;
		if (offerDto.getTerm() < 0)
			res = false;
		if (offerDto.getInterest() < 0)
			res = false;

		return res;
	}

	private boolean ValidateOfferForDeleting(Offer offer)
			throws ForbiddenException {

		if (offer.getStatus().equals("Processing")) {
			throw new NullPointerException(MessageFormat.format(
					"Cannot accept Offer [{0}], Status is Processing. ", offer
							.getId().toString()));
		}
		if (offer.getStatus().equals("Closed")) {
			throw new NullPointerException(MessageFormat.format(
					"Cannot accept Offer [{0}],,  Status is Closed. ", offer
							.getId().toString()));
		}
		if (offer.getStatus().equals("Edit")) {
			throw new NullPointerException(MessageFormat.format(
					"Cannot accept Offer [{0}],,  Status is Edit. ", offer
							.getId().toString()));
		}

		return true;
	}
	
	private Member SearchMember(Long MemberId) {
		MemberEndpoint mep = new MemberEndpoint();
		Member member = mep.getMemberByID(MemberId);
		return member;
	}

	private Member SearchMemberByEmail(String email) {
		MemberEndpoint mep = new MemberEndpoint();
		Member member = mep.GetMemberByEmail(email);
		return member;
	}

	private RequestResult createOfferDTO(OfferDTO offerDto) {
		OfferEndpoint oep = new OfferEndpoint();
		return oep.saveOffer(offerDto);
	}

}
