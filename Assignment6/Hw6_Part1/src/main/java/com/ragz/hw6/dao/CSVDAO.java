/**
 * 
 */
package com.ragz.hw6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ragz.hw6.pojo.CSV;



/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class CSVDAO{

	
	 public List<CSV> getCSVData(String query,String PATH_CSV)  {
	        try {
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
	            ResultSet results = stmt.executeQuery("SELECT * from " + query);
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
	            }
				return csvList;

	           
	        }  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
}
