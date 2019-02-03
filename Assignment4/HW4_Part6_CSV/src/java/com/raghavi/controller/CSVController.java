/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.controller;

import com.raghavi.pojo.CSV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class CSVController extends AbstractController {

    private PreparedStatement preparedStmt;
    private  int totalCount=0;
    private static final String PATH_CSV = "C:\\webToolsLab\\assignment4\\";

    public CSVController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("Insert")) {
            java.sql.Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesdb", "root", "root");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException" + ex.getMessage());

            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());

            }
            String sql;
            sql = "Insert into sales(salesOrderID,revisionNumber,orderDate,dueDate,shipDate,status,"
                    + "onlineOrderFlag,salesOrderNumber,purchaseOrderNumber,accountNumber,customerID,salesPersonID,"
                    + "territoryID,billToAddressID,shipToAddressID,shipMethodID,creditCardID,creditCardApprovalCode,"
                    + "currencyRateID,subTotal,taxAmt,freight,totalDue,comment,modifiedDate)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparedStmt = connection.prepareStatement(sql);
            int count = 0;
            for (int i = 0; i < 100; i++) {

                // create the mysql insert preparedstatement
                int salesOrderID = Integer.parseInt(request.getParameter("salesOrderID" + i));
                int revisionNumber = Integer.parseInt(request.getParameter("revisionNumber" + i));
                String orderDate = request.getParameter("orderDate" + i);
                String dueDate = (request.getParameter("dueDate" + i));

                String shipDate = request.getParameter("shipDate" + i);
                int status = Integer.parseInt(request.getParameter("status" + i));
                int onlineOrderFlag = Integer.parseInt(request.getParameter("onlineOrderFlag" + i));
                String salesOrderNumber = request.getParameter("salesOrderNumber" + i);

                String purchaseOrderNumber = request.getParameter("purchaseOrderNumber" + i);
                String accountNumber = request.getParameter("accountNumber" + i);
                int customerID = Integer.parseInt(request.getParameter("customerID" + i));
                int salesPersonID = Integer.parseInt(request.getParameter("salesPersonID" + i));

                int territoryID = Integer.parseInt(request.getParameter("territoryID" + i));
                int billToAddressID = Integer.parseInt(request.getParameter("billToAddressID" + i));
                int shipToAddressID = Integer.parseInt(request.getParameter("shipToAddressID" + i));
                int shipMethodID = Integer.parseInt(request.getParameter("shipMethodID" + i));

                int creditCardID = Integer.parseInt(request.getParameter("creditCardID" + i));
                String creditCardApprovalCode = request.getParameter("creditCardApprovalCode" + i);
                String currencyRateID = request.getParameter("currencyRateID" + i);
                Float subTotal = Float.parseFloat(request.getParameter("subTotal" + i));

                Float taxAmt = Float.parseFloat(request.getParameter("taxAmt" + i));
                Float freight = Float.parseFloat(request.getParameter("freight" + i));
                Float totalDue = Float.parseFloat(request.getParameter("totalDue" + i));
                String comment = request.getParameter("comment" + i);

                String modifiedDate = request.getParameter("modifiedDate" + i);

                preparedStmt.setInt(1, salesOrderID);
                preparedStmt.setInt(2, revisionNumber);
                preparedStmt.setString(3, orderDate);
                preparedStmt.setString(4, dueDate);
                preparedStmt.setString(5, shipDate);
                preparedStmt.setInt(6, status);
                preparedStmt.setInt(7, onlineOrderFlag);
                preparedStmt.setString(8, salesOrderNumber);
                preparedStmt.setString(9, purchaseOrderNumber);
                preparedStmt.setString(10, accountNumber);
                preparedStmt.setInt(11, customerID);
                preparedStmt.setInt(12, salesPersonID);
                preparedStmt.setInt(13, territoryID);
                preparedStmt.setInt(14, billToAddressID);
                preparedStmt.setInt(15, shipToAddressID);
                preparedStmt.setInt(16, shipMethodID);
                preparedStmt.setInt(17, creditCardID);
                preparedStmt.setString(18, creditCardApprovalCode);
                preparedStmt.setString(19, currencyRateID);
                preparedStmt.setFloat(20, subTotal);
                preparedStmt.setFloat(21, taxAmt);
                preparedStmt.setFloat(22, freight);
                preparedStmt.setFloat(23, totalDue);
                preparedStmt.setString(24, comment);
                preparedStmt.setString(25, modifiedDate);

                preparedStmt.addBatch();
                // execute the preparedstatement
                count++;
            }

            preparedStmt.executeBatch();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("count", count);
            map.put("type", "insertData");
            return new ModelAndView("index", "map", map);

        } else {
            String fileName = request.getParameter("csvFileName");
            ArrayList<CSV> csvList = new ArrayList<CSV>();

            // Load the driver.
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            // Create a connection. The first command line parameter is
            // the directory containing the .csv files.
            // A single connection is thread-safe for use by several threads.
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + PATH_CSV);

            // Create a Statement object to execute the query with.
            // A Statement is not thread-safe.
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * from " + fileName);
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
                csvList.add(csv);
                totalCount++;
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("csvList", csvList);
            map.put("type", "csvRead");
            return new ModelAndView("index", "map", map);
        }
    }
}
