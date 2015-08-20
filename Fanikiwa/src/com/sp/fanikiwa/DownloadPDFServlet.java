package com.sp.fanikiwa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sp.fanikiwa.api.LoanEndpoint;
import com.sp.fanikiwa.api.MemberEndpoint;
import com.sp.fanikiwa.business.InterestComponent;
import com.sp.fanikiwa.business.Jobs.JobProcessSTO;
import com.sp.fanikiwa.business.financialtransactions.TransactionPost;
import com.sp.fanikiwa.entity.Contract;
import com.sp.fanikiwa.entity.EMI;
import com.sp.fanikiwa.entity.Installment;
import com.sp.fanikiwa.entity.Loan;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.pdf.ContractPDF;
import com.sp.utils.DateExtension;
import com.sp.utils.MailUtil;
import com.sp.utils.PDFUtil;
import com.sp.utils.PeerLendingUtil;

public class DownloadPDFServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		final Logger log = Logger.getLogger(DownloadPDFServlet.class.getName());
		boolean EnableLog = true;

		if (req.getParameter("loanid") != null) {
			String fileName = "FanikiwaContract.pdf";
			res.setContentType("application/pdf");
			res.setHeader("Content-Disposition", "attachment;filename=\""
					+ fileName + "\"");
			try {

				Long loanid = Long.parseLong(req.getParameter("loanid"));
				if (EnableLog)
					log.info("Creating Contract pdf for loan [ " + loanid
							+ " ] started");
				writePDF("Contract", loanid, res.getOutputStream());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.log(Level.SEVERE, e.toString());
				return;
			}
		} else {
			res.getWriter()
					.println(
							"Loan Id parameter is required. Format = http://localhost:8888/DownloadPDFServlet?loanid=5720758999318528");
		}
	}

	private void writePDF(String symbol, Long loanid, ServletOutputStream str)
			throws Exception {
		switch (symbol) {
		case "Contract":
			PDFUtil.writePdf(str, CreateLoanContract(loanid), ContractPDF.class);
			break;
		}

	}

	private Document CreateContract(ServletOutputStream str)
			throws DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, str);
		document.open();
		document.add(new Paragraph("This is a contract"));
		document.close();
		return document;
	}

	private Contract CreateLoanContract(Long loanid) throws NotFoundException {
		LoanEndpoint lep = new LoanEndpoint();

		Loan loan = lep.getLoanByID(loanid);
		if (loan == null) {
			throw new NotFoundException("Loan [ " + loanid
					+ " ]  does not exist");
		}
		// Create contract. This is a superclass of PDFModel class
		Contract contractModel = new Contract();
		// Populate contract
		InterestComponent ic = new InterestComponent();
		EMI emi = ic.calcEmiAllMonths(loan.getAmount(), loan.getInterestRate(),
				loan.getTerm());

		contractModel.setAmount(emi.getTotalAmount());
		contractModel.setPrincipal(loan.getAmount());
		contractModel.setCreatedDate(loan.getCreatedDate());
		Member lender = PeerLendingUtil.GetMember(loan.getLenderId());
		String lendernames = lender.getSurname();
		if (lender.getOtherNames() != null)
			lendernames += lender.getOtherNames();
		Member borrower = PeerLendingUtil.GetMember(loan.getBorrowerId());
		String borrowernames = borrower.getSurname();
		if (lender.getOtherNames() != null)
			borrowernames += borrower.getOtherNames();
		contractModel.setLender(lendernames);
		contractModel.setBorrower(borrowernames);
		contractModel.setTerm(loan.getTerm());
		contractModel.setStartInstallmentDate(DateExtension.addMonths(
				loan.getCreatedDate(), 1));
		contractModel.setEndInstallmentDate(loan.getMaturityDate());
		contractModel.setInterestRate(loan.getInterestRate());
		contractModel.setEmi(emi.getInstallmentAmount());

		contractModel.setRepaymentSchedule(emi.getInstallments());

		return contractModel;
	}
}
