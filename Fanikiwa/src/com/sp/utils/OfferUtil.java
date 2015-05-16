package com.sp.utils;

import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.Enums.OfferStatus;
import com.sp.fanikiwa.api.OfferEndpoint;
import com.sp.fanikiwa.entity.Offer;

public class OfferUtil {

	public static void SetOfferStatus(Offer offer, OfferStatus status)
			throws NotFoundException {
		OfferEndpoint oep = new OfferEndpoint();
		offer.setStatus(status.toString());
		oep.updateOffer(offer);
	}
}
