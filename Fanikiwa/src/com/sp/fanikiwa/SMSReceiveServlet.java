package com.sp.fanikiwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sp.fanikiwa.business.SMS.FanikiwaMessage;
import com.sp.fanikiwa.business.SMS.FanikiwaMessageFactory;
import com.sp.fanikiwa.business.SMS.MpesaDepositMessage;
import com.sp.fanikiwa.business.SMS.SMSProcessorComponent;
import com.sp.fanikiwa.business.messaging.SMSmessage;
import com.sp.utils.HttpUtil;

public class SMSReceiveServlet extends HttpServlet {

	final String FANIKIWATELNO = "0717769329";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ProcessSMS(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ProcessSMS(request, response);
	}

	private void ProcessSMS(HttpServletRequest request,
			HttpServletResponse response) {
		SMSmessage msg;
		try {
			// 1. Get sms from request
			msg = MakeSMSFromRequest(request);

			// 2. convert sms into a fanikiwa message
			FanikiwaMessage fMsg = FanikiwaMessageFactory.CreateMessage(msg
					.getAddressFrom(), msg.getMessageDate(), msg.getBody()
					.toString());

			// 3.process the fanikiwa message
			SMSProcessorComponent smsComp = new SMSProcessorComponent();
			String result = smsComp.ProcessFanikiwaMessage(fMsg);

			// 4. send the response back
			 SendResponse(response, result, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private SMSmessage MakeSMSFromRequest(HttpServletRequest request)
			throws IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		// 2. initiate jackson mapper
		Gson gson = new Gson();
		SMSmessage msg = gson.fromJson(json, SMSmessage.class);

		// 3. Convert received JSON to Article
		msg.setAddressTo(FANIKIWATELNO);
		msg.setMessageDate(new Date());

		return msg;
	}

	private void SendResponse(HttpServletResponse response, String result,
			SMSmessage sms) {
		// write to response -- FOR TESTING
		try {
			String msg = "To: " + sms.getAddressFrom() +
					"\nMessage: " + result;
			response.getWriter().println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FOR LIVE
		/*
		 * SMSURL="https://smscompany/fanikiwaAcc/SMS" 1. smsrequest =
		 * create(SMSURL) 2. Json jsonresult = ConvertToJason(result,original)
		 * 3. smsrequest.getWriter().write(jsonresult)
		 */

	}
}
