package com.sp.fanikiwa;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.fanikiwa.api.MpesaIPNMessageEndpoint;
import com.sp.fanikiwa.business.MpesaComponent;
import com.sp.fanikiwa.entity.MpesaIPNMessage;

public class MpesaProcessServelet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			ProcessDBMessages(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			ProcessDBMessages(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ProcessDBMessages(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		
		response.getWriter().println("Processing Started at "+(new Date()).toString()+"....");
		ProcessDBMessagesNow(request, response);
		response.getWriter().println("Processed finished at "+(new Date()).toString()+".");
	}
	
	private void ProcessDBMessagesNow(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		try {
				// make sure the message is not processed twice
				// get all messages where status = 'New'
				MpesaIPNMessageEndpoint mep = new MpesaIPNMessageEndpoint();
				Collection<MpesaIPNMessage> mpesaMsgs = mep
						.ListNewMpesaIPNMessages(null, null).getItems();

				response.getWriter().println("STEP 3: Processing "+ mpesaMsgs.size() + " new messages..." );
				for (MpesaIPNMessage mpesaMsg : mpesaMsgs) {

					MpesaComponent mcomp = new MpesaComponent();
					String str = mcomp.ProcessMessage(mpesaMsg);
					response.getWriter().println("STEP 3.1: Processed mgsid["+ mpesaMsg.getMpesa_code() + "] ...\nResult =" + str );
					
					// 5. update the processed messaged status so it is not
					// processed again.
					mpesaMsg.setStatus("Processed");
					mep.updateMpesaIPNMessage(mpesaMsg);
					response.getWriter().println("STEP 3.2: DB Status of message id["+ mpesaMsg.getMpesa_code() + "] changed to Processed" );
					
				}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().println("An error occurred:\n ");
			response.getWriter().println(e.getMessage());
		}
	}


}

