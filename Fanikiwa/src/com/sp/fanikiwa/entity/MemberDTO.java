package com.sp.fanikiwa.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Index;

public class MemberDTO {

	private String email;
	private String pwd;
	private String surname;
	private String telephone;
	private String nationalID;
	private String status = "A";
	private Date dateActivated = new Date();
	private Date dateJoined;
	private String informBy = "EMAIL";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateActivated() {
		return dateActivated;
	}

	public void setDateActivated(Date dateActivated) {
		this.dateActivated = dateActivated;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getInformBy() {
		return informBy;
	}

	public void setInformBy(String informBy) {
		this.informBy = informBy;
	}

}
