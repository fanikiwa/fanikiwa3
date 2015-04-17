package com.sp.fanikiwa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Offer {

	@Id
	Long id;

	private String description;

	private double amount;
 
	private int term;
 
	private double interest;
 
	private boolean publicOffer;
 
	private Date createdDate;
 
	private Date expiryDate;
 
	private String offerType;
 
	private boolean partialPay;
 
	private String status;
 
	@Load
	Ref<Member> member;

	public Offer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Member getMember() {
		return this.member.get();
	}

	public void setMember(Member member) {
		this.member = Ref.create(member);
	}

	public String getOfferType() {
		return this.offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public boolean getPartialPay() {
		return this.partialPay;
	}

	public void setPartialPay(boolean partialPay) {
		this.partialPay = partialPay;
	}

	public boolean getPublicOffer() {
		return this.publicOffer;
	}

	public void setPublicOffer(boolean publicOffer) {
		this.publicOffer = publicOffer;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}