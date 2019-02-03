/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import pojo.CSV;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class CustomTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
     private String fileName;
    private static final String PATH_CSV = "C:\\webToolsLab\\assignment4\\";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void doTag() throws JspException {
         JspWriter out = getJspContext().getOut(); //To change body of generated methods, choose Tools | Templates.

        try {
            ArrayList<CSV> list = new ArrayList<CSV>();
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            // Create a connection. The first command line parameter is
            // the directory containing the .csv files.
            // A single connection is thread-safe for use by several threads.
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + PATH_CSV);

            // Create a Statement object to execute the query with.
            // A Statement is not thread-safe.
            Statement stmt = conn.createStatement();
            // Select the ID and NAME columns from sample.csv
            ResultSet results;
            results = stmt.executeQuery("SELECT * FROM " + fileName);

            // Dump out the results to a CSV file with the same format
            // using CsvJdbc helper function
            while (results.next()) {
                CSV csv = new CSV();
                csv.setSalesOrderID(results.getInt(1));
                csv.setRevisionNumber(results.getInt(2));
                csv.setOrderDate(results.getString(3));
                csv.setDueDate(results.getString(4));
                csv.setShipDate(results.getString(5));
                csv.setStatus(results.getInt(6));
                csv.setOnlineOrderFlag(results.getInt(7));
                csv.setSalesOrderNumber(results.getString(8));
                csv.setPurchaseOrderNumber(results.getString(9));
                csv.setAccountNumber(results.getString(10));
                csv.setCustomerID(results.getInt(11));
                csv.setSalesPersonID(results.getInt(12));
                csv.setTerritoryID(results.getInt(13));
                csv.setBillToAddressID(results.getInt(14));
                csv.setShipToAddressID(results.getInt(15));
                csv.setShipMethodID(results.getInt(16));
                csv.setCreditCardID(results.getInt(17));
                csv.setCreditCardApprovalCode(results.getString(18));
                csv.setCurrencyRateID(results.getString(19));
                csv.setSubTotal(results.getFloat(20));
                csv.setTaxAmt(results.getFloat(21));
                csv.setFreight(results.getFloat(22));
                csv.setTotalDue(results.getFloat(23));
                csv.setComment(results.getString(24));
                csv.setModifiedDate(results.getString(25));
                list.add(csv);

            }

            // out.println("<form action=\"next.htm\" method=\"post\">\n"
            out.println("    <table>\n"
                    + "                    <thead>\n"
                    + "                        <tr>\n"
                    + "                            <th>SalesOrderID</th>\n"
                    + "                            <th>RevisionNumber</th>\n"
                    + "                            <th>OrderDate</th>\n"
                    + "                            <th>DueDate</th>\n"
                    + "                            <th>ShipDate</th>\n"
                    + "                            <th>Status</th>\n"
                    + "                            <th>OnlineOrderFlag</th>\n"
                    + "                            <th>SalesOrderNumber</th>\n"
                    + "                            <th>PurchaseOrderNumber</th>\n"
                    + "                            <th>AccountNumber</th>\n"
                    + "                            <th>CustomerID</th>\n"
                    + "                            <th>SalesPersonID</th>\n"
                    + "                            <th>TerritoryID</th>\n"
                    + "                            <th>BillToAddressID</th>\n"
                    + "                            <th>ShipToAddressID</th>\n"
                    + "                            <th>ShipMethodID</th>\n"
                    + "                            <th>CreditCardID</th>\n"
                    + "                            <th>CreditCardApprovalCode</th>\n"
                    + "                            <th>CurrencyRateID</th>\n"
                    + "                            <th>SubTotal</th>\n"
                    + "                            <th>TaxAmt</th>\n"
                    + "                            <th>Freight</th>\n"
                    + "                            <th>TotalDue</th>\n"
                    + "                            <th>Comment</th>\n"
                    + "                            <th>ModifiedDate</th>\n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + "                    <tbody>");
            for (int i = 1; i < 100; i++) {
                out.println("<tr>\n");
                out.println("<td><input type=\"text\" name=\"salesOrderID\" value='" + list.get(i).getSalesOrderID() + "'></td>");
                out.println("<td><input type=\"text\" name=\"revisionNumber\" value='" + list.get(i).getRevisionNumber() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"orderDate\" value='" + list.get(i).getOrderDate() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"dueDate\" value='" + list.get(i).getDueDate() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"shipDate\" value='" + list.get(i).getShipDate() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"status\" value='" + list.get(i).getStatus() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"onlineOrderFlag\" value='" + list.get(i).getOnlineOrderFlag() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"salesOrderNumber\" value='" + list.get(i).getSalesOrderNumber() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"purchaseOrderNumber\" value='" + list.get(i).getPurchaseOrderNumber() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"accountNumber\" value='" + list.get(i).getAccountNumber() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"customerID\" value='" + list.get(i).getCustomerID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"salesPersonID\" value='" + list.get(i).getSalesPersonID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"territoryID\" value='" + list.get(i).getTerritoryID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"billToAddressID\" value='" + list.get(i).getBillToAddressID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"shipToAddressID\" value='" + list.get(i).getShipToAddressID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"shipMethodID\" value='" + list.get(i).getShipMethodID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"creditCardID\" value='" + list.get(i).getCreditCardID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"creditCardApprovalCode\" value='" + list.get(i).getCreditCardApprovalCode() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"currencyRateID\" value='" + list.get(i).getCurrencyRateID() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"subTotal\" value='" + list.get(i).getSubTotal() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"taxAmt\" value='" + list.get(i).getTaxAmt() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"freight\" value='" + list.get(i).getFreight() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"totalDue\" value='" + list.get(i).getTotalDue() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"comment\" value='" + list.get(i).getComment() + "'></td>\n"
                        + "                                <td><input type=\"text\" name=\"modifiedDate\" value='" + list.get(i).getModifiedDate() + "'></td>");
                out.println("</tr>");

            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<input type=\"hidden\" name=\"action\" value=\"Insert\">\n");
            //  + "  <input type=\"submit\" value=\"add to DB\">\n");
            //  + "  </form>");

        } catch (Exception e) {
            System.out.println("Error Message " + e.getMessage());
        }

    }
}
