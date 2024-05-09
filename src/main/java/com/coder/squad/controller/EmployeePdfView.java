package com.coder.squad.controller;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.coder.squad.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// Font font=new Font();
		// Document docume = new Document(PageSize.A4);
		response.addHeader("content-disposition", "attachment;filename=emp.pdf");
		List<Employee> emp = (List<Employee>) model.get("list");
		Font fontTiltle = new Font(Font.TIMES_ROMAN, 22, Font.BOLD, new Color(84, 192, 247));
		fontTiltle.setSize(20);
		// fontTiltle.setColor(red, green, blue);
		Paragraph para = new Paragraph("Employee Info", fontTiltle);
		para.setSpacingAfter(10.0f);
		para.setAlignment(Element.ALIGN_CENTER);
		PdfPTable table = new PdfPTable(4);
		table(table, document, emp);

	}

	private void table(PdfPTable table, Document document, List<Employee> emp) throws DocumentException {
		table = new PdfPTable(4);
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("Email");
		table.addCell("Cont");
		// PdfCell cell=new PdfCell(cell, rownumber, left, right, top, cellspacing,
		// cellpadding)
		for (Employee emplist : emp) {
			table.addCell(String.valueOf(emplist.getId()));
			table.addCell(emplist.getName());
			table.addCell(emplist.getEmail());
			table.addCell(emplist.getCont());

		}
		document.add(table);

	}
}