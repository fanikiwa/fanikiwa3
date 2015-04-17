package com.sp.fanikiwa.business.MakeOffer;

import java.util.Collection;
import java.util.List;

import com.sp.fanikiwa.api.LendingGroupMemberEndpoint;
import com.sp.fanikiwa.entity.Lendinggroupmember;
import com.sp.fanikiwa.entity.Member;

public class GroupOfferee  extends Offeree {
	private String GroupName;
	private List<Member> members;	
		
	public GroupOfferee(String groupName) {
		super();
		GroupName = groupName;
		//Fill Members
		FillMembers(groupName);
	}
	

	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public List<Member> getMembers() {
		return members;
	}

	//called recursively
	private void FillMembers(String Groupname)
	{
		LendingGroupMemberEndpoint ep = new LendingGroupMemberEndpoint();
		
		Collection<Lendinggroupmember> grpmembers = (ep.selectgroupMembers(Groupname, null, null)).getItems();
		for(Lendinggroupmember m : grpmembers)
		{
			if(m.getIdType().toUpperCase().equals("M") )
			{
				Member meb = m.getMember();
				if(meb != null)
				members.add(meb);
			}
			else //this is a nested group; find out its members recursively
			{
				FillMembers(m.getGroup().getGroupName());
			}
		}
	}

}
