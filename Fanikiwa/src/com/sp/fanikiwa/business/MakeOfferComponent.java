package com.sp.fanikiwa.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.NotFoundException;
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
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.OfferDTO;
import com.sp.fanikiwa.entity.OfferModel;
import com.sp.fanikiwa.entity.OfferReceipient;
import com.sp.utils.GLUtil;
import com.sp.utils.MailUtil;
import com.sp.utils.StringExtension;

public class MakeOfferComponent {

	

	public Offer MakeOffer(OfferDTO offerDto) throws Exception {
		if (offerDto.getOfferType().toUpperCase().equals("L")) {
			return MakeLendOffer(offerDto);
		} else {
			return MakeBorrowOffer(offerDto);
		}
	}

	private Offer MakeBorrowOffer(OfferDTO offerModel) throws Exception {
		return createOfferDTO(offerModel);
	}

	private Offer MakeLendOffer(OfferDTO offerDto) throws Exception {
		// Step 1 - Block funds.
		Member member = SearchMemberByEmail(offerDto.getEmail());

		// calls GLs funds block service.
		AccountEndpoint sPostingClient = new AccountEndpoint();
		if (GLUtil.GetAvailableBalance(member.getCurrentAccount()) < offerDto
				.getAmount())
			throw new ForbiddenException("Insufficient funds");

		// BlockFunds function checks all account status before the actual block
		sPostingClient.BlockFunds(member.getCurrentAccount(),
				offerDto.getAmount());

		// Step 2 - Calling Create on Offer.

		return createOfferDTO(offerDto);
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


	private Offer createOfferDTO(OfferDTO offerDto)
	{
		OfferEndpoint oep = new OfferEndpoint();
		Offer offer  = (Offer)oep.saveOffer(offerDto).getClientToken();
		return offer;
	}

}
