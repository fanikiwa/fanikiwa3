package com.sp.fanikiwa.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Lendinggroupmember {

	@Id
	Long id;
	
	@Index String groupName; //parent
 
	
	@Index private String idType; //either M or G
 
	//Group members = member | another group
	@Index private Ref<Member> member;
	@Index private Ref<Lendinggroup> group;
 

	public Lendinggroupmember() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lendinggroup getGroup() {
		return group.get();
	}

	public void setGroup(Lendinggroup group) {
		this.group = Ref.create(group);
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Member getMember() {
		return member.get();
	}

	public void setMember(Member member) {
		this.member = Ref.create(member);
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}