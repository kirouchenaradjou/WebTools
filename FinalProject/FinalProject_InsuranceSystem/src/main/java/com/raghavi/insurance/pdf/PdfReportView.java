package com.raghavi.insurance.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.raghavi.insurance.pojo.User;

public class PdfReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//model was added to the scope by the Controller
		User user = (User) model.get("user");
		pdfdoc.add(new Paragraph("Patient Name: " + user.getFirstName() + " " + user.getLastName() +"\n" +"Patient Address" +user.getAddress()+"\nPatient Plan Enrolled"+user.getPlan_enrolled()+"\nPatient Amount sanctioned"+user.getAmount_sanctioned()+"\nPatient DOB"+user.getDob()));
	}

}
