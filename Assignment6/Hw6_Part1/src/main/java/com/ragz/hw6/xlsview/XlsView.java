/**
 * 
 */
package com.ragz.hw6.xlsview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ragz.hw6.pojo.CSV;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */

public class XlsView extends AbstractExcelView {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.view.document.AbstractExcelView#
	 * buildExcelDocument(java.util.Map, org.apache.poi.hssf.usermodel.HSSFWorkbook,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<CSV> csvList = (List<CSV>) model.get("csvList");
		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Sales Order");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("SalesOrderID");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("RevisionNumber");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("OrderDate");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("DueDate");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("ShipDate");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Status");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("OnlineOrderFlag");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("SalesOrderNumber");
		header.getCell(7).setCellStyle(style);
		
		header.createCell(8).setCellValue("PurchaseOrderNumber");
		header.getCell(8).setCellStyle(style);
		
		header.createCell(9).setCellValue("AccountNumber");
		header.getCell(9).setCellStyle(style);
		
		header.createCell(10).setCellValue("CustomerID");
		header.getCell(10).setCellStyle(style);
		
		header.createCell(11).setCellValue("SalesPersonID");
		header.getCell(11).setCellStyle(style);
		
		header.createCell(12).setCellValue("TerritoryID");
		header.getCell(12).setCellStyle(style);
		
		header.createCell(13).setCellValue("BillToAddressID");
		header.getCell(13).setCellStyle(style);
		
		header.createCell(14).setCellValue("ShipToAddressID");
		header.getCell(14).setCellStyle(style);
		
		header.createCell(15).setCellValue("ShipMethodID");
		header.getCell(15).setCellStyle(style);
		
		header.createCell(15).setCellValue("CreditCardID");
		header.getCell(15).setCellStyle(style);
		
		header.createCell(16).setCellValue("CreditCardApprovalCode");
		header.getCell(16).setCellStyle(style);
		
		header.createCell(17).setCellValue("CurrencyRateID");
		header.getCell(17).setCellStyle(style);
		
		header.createCell(18).setCellValue("SubTotal");
		header.getCell(18).setCellStyle(style);
		
		header.createCell(19).setCellValue("TaxAmt");
		header.getCell(19).setCellStyle(style);
		
		header.createCell(20).setCellValue("Freight");
		header.getCell(20).setCellStyle(style);
		
		header.createCell(21).setCellValue("TotalDue");
		header.getCell(21).setCellStyle(style);
		
		header.createCell(22).setCellValue("Comment");
		header.getCell(22).setCellStyle(style);
		
		header.createCell(23).setCellValue("Modified Date");
		header.getCell(23).setCellStyle(style);

		// create data rows
		int rowCount = 1;

		for (CSV csv : csvList) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(csv.getSalesOrderID());
			aRow.createCell(1).setCellValue(csv.getRevisionNumber());
			aRow.createCell(2).setCellValue(csv.getOrderDate());
			aRow.createCell(3).setCellValue(csv.getDueDate());
			aRow.createCell(4).setCellValue(csv.getShipDate());
			aRow.createCell(5).setCellValue(csv.getStatus());
			aRow.createCell(6).setCellValue(csv.getOnlineOrderFlag());
			aRow.createCell(7).setCellValue(csv.getSalesOrderNumber());
			aRow.createCell(8).setCellValue(csv.getPurchaseOrderNumber());
			aRow.createCell(9).setCellValue(csv.getAccountNumber());
			aRow.createCell(10).setCellValue(csv.getCustomerID());
			aRow.createCell(11).setCellValue(csv.getSalesPersonID());
			aRow.createCell(12).setCellValue(csv.getTerritoryID());
			aRow.createCell(13).setCellValue(csv.getBillToAddressID());
			aRow.createCell(14).setCellValue(csv.getShipToAddressID());
			aRow.createCell(15).setCellValue(csv.getShipMethodID());
			aRow.createCell(16).setCellValue(csv.getCreditCardID());
			aRow.createCell(17).setCellValue(csv.getCreditCardApprovalCode());
			aRow.createCell(18).setCellValue(csv.getCurrencyRateID());
			aRow.createCell(19).setCellValue(csv.getSubTotal());
			aRow.createCell(20).setCellValue(csv.getTaxAmt());
			aRow.createCell(21).setCellValue(csv.getFreight());
			aRow.createCell(22).setCellValue(csv.getTotalDue());
			aRow.createCell(23).setCellValue(csv.getComment());
			aRow.createCell(24).setCellValue(csv.getModifiedDate());


		}
	}

}
