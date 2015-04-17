package com.sp.fanikiwa.business;

import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.api.MemberEndpoint;
import com.sp.fanikiwa.api.UserprofileEndpoint;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.MemberDTO;
import com.sp.fanikiwa.entity.Userprofile;

public class RegistrationComponent {
	 public boolean IsPhoneRegistered(String Phone)
     {
         // Data access component declarations.
         MemberEndpoint mep = new MemberEndpoint();
        Member m = mep.GetMemberByTelephone(Phone);

         return (m != null);
     }

     public boolean Authenticated(String telephone, String pwd)
     {
         UserprofileEndpoint  uep = new UserprofileEndpoint();
         Userprofile user = uep.LoginByPhone(telephone, pwd);
         if(user == null) return false;
         return (user.getPwd().equals(pwd));
     }
     public boolean Authorized(String telephone, String pwd)
     {
         boolean authorized = false;
         MemberEndpoint MemberEndpoint = new MemberEndpoint();
         Member m = MemberEndpoint.GetMemberByTelephone(telephone);
         //check status
         if(m == null) return false;
         if (m.getStatus().toUpperCase().equals("A")) authorized = true; //member is active, so authorized

         //check other things coming later

         return authorized;
     }
     public boolean IsEmailRegistered(String Email) 
     {
    	 MemberEndpoint mep = new MemberEndpoint();
         Member m = mep.GetMemberByEmail(Email);

          return (m != null);

     }
     public boolean ISPhoneAndEmailRegistered(String Phone, String Email)
     {
         return IsPhoneRegistered(Phone) && IsEmailRegistered(Email);
     }
     public boolean IsNationalIDRegistered(String NationalId)
     {
    	 MemberEndpoint mep = new MemberEndpoint();
         Member m = mep.getMemberByNationalID(NationalId);

          return (m != null);
     }
     public boolean IsRegistered(String email, String phone, String ID)
     {
         MemberEndpoint MemberEndpoint = new MemberEndpoint();
         return IsPhoneRegistered(phone) && 
        		 IsEmailRegistered(email) &&
        		 IsNationalIDRegistered(ID) ;
     }
     
     public Member Register(MemberDTO m) throws ConflictException, NotFoundException
     {
    	 MemberEndpoint mep = new MemberEndpoint();
    	 return mep.Register(m);
    	 
     }

	public Member SelectMemberByPhone(String senderTelno) {
		MemberEndpoint rc = new MemberEndpoint();
        return rc.GetMemberByTelephone(senderTelno);
	}

	public Member GetMemberByPhone(String senderTelno) {
		// TODO Auto-generated method stub
		return SelectMemberByPhone(senderTelno);
	}


}
