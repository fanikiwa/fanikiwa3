package com.sp.utils;

import com.sp.fanikiwa.api.MemberEndpoint;
import com.sp.fanikiwa.entity.Member;

public class PeerLendingUtil {
	
	public static Member GetMember(Long id)
	{
		MemberEndpoint mep = new MemberEndpoint();
		return mep.getMemberByID(id);
	}

}
