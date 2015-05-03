package com.sp.fanikiwa.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class RequestResult {
	@Id Long id;
	
	private boolean Result;
	private String ResultMessage;
	private Object clientToken; 
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isResult() {
		return Result;
	}
	public void setResult(boolean result) {
		Result = result;
	}
	public String getResultMessage() {
		return ResultMessage;
	}
	public void setResultMessage(String resultMessage) {
		ResultMessage = resultMessage;
	}
	public Object getClientToken() {
		return clientToken;
	}
	public void setClientToken(Object clienttoken) {
		clientToken = clienttoken;
	}

}
