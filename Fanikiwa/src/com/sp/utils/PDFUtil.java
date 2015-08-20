package com.sp.utils;

import java.io.OutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sp.fanikiwa.entity.Contract;
import com.sp.fanikiwa.entity.PDFModel;

public class PDFUtil {
	/**
	 * Writes the content of a PDF file (using iText API) to the
	 * {@link OutputStream}.
	 * 
	 * @param outputStream
	 *            {@link OutputStream}.
	 * @throws Exception
	 */
	public static void writePdf(OutputStream outputStream, Class<?> ctx)
			throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		document.open();
		writePDFFromContext(document, ctx);
		document.close();
	}

	public static void writePdf(OutputStream outputStream, Contract model,
			Class<?> ctx) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		document.open();
		writePDFFromContext(document, model, ctx);
		document.close();
	}

	/*
	 * construct the pdf in the class's constructor. the class must have a
	 * constructor of type Class(Document document)
	 */
	public static void writePDFFromContext(Document document, Class<?> clazz)
			throws Exception {

		clazz.getConstructor(new Class[] { Document.class }).newInstance(
				document);
	}

	public static void writePDFFromContext(Document document, PDFModel model,
			Class<?> clazz) throws Exception {

		clazz.getConstructor(new Class[] { Document.class, PDFModel.class })
				.newInstance(document, model);
	}

}
