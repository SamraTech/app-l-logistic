package com.coder.squad.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.coder.squad.model.Employee;

public class EmployeeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		response.addHeader("content-disposition", "attachment;filename=employee.xlsx");
		@SuppressWarnings("unchecked")

		List<Employee> emp = (List<Employee>) model.get("list");
		Sheet sheet = workbook.createSheet("Dummy");
		setHeader(sheet);
		setBody(sheet, emp);

	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Email");
		row.createCell(3).setCellValue("Cont");
	}

	private void setBody(Sheet sheet, List<Employee> emp) {
		int row = 1;
		for (Employee employee : emp) {
			Row createRow = sheet.createRow(row++);
			createRow.createCell(0).setCellValue(employee.getId());
			createRow.createCell(1).setCellValue(employee.getName());
			createRow.createCell(2).setCellValue(employee.getEmail());
			createRow.createCell(3).setCellValue(employee.getCont());
		}

	}

}
