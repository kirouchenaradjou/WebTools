/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import pojo.CSV;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class ControllerCSV extends AbstractController {
    private PreparedStatement prepstm;
    private  int totalCount=0;

    public ControllerCSV() {
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
                                sql = "insert into sales values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            prepstm = connection.prepareStatement(sql);
            int count = 1;
            for (int i = 0; i <99; i++) {

                // create the mysql insert preparedstatement
                 String salesOrderID[] = request.getParameterValues("salesOrderID");
                String revisionNumber[] = request.getParameterValues("revisionNumber");
                String orderDate[] = request.getParameterValues("orderDate");
                String dueDate[] = request.getParameterValues("dueDate");
                String shipDate[] = request.getParameterValues("shipDate");
                String status[] = request.getParameterValues("status");
                String onlineOrderFlag[] = request.getParameterValues("onlineOrderFlag");
                String salesOrderNumber[] = request.getParameterValues("salesOrderNumber");
                String purchaseOrderNumber[] = request.getParameterValues("purchaseOrderNumber");
                String accountNumber[] = request.getParameterValues("accountNumber");
                String customerID[] = request.getParameterValues("customerID");
                String salesPersonID[] = request.getParameterValues("salesPersonID");
                String territoryID[] = request.getParameterValues("territoryID");
                String billToAddressID[] = request.getParameterValues("billToAddressID");
                String shipToAddressID[] = request.getParameterValues("shipToAddressID");
                String shipMethodID[] = request.getParameterValues("shipMethodID");
                String creditCardID[] = request.getParameterValues("creditCardID");
                String creditCardApprovalCode[] = request.getParameterValues("creditCardApprovalCode");
                String currencyRateID[] = request.getParameterValues("currencyRateID");
                String subTotal[] = request.getParameterValues("subTotal");
                String taxAmt[] = request.getParameterValues("taxAmt");
                String freight[] = request.getParameterValues("freight");
                String totalDue[] = request.getParameterValues("totalDue");
                String comment[] = request.getParameterValues("comment");
                String modifiedDate[] = request.getParameterValues("modifiedDate");
                
                       prepstm.setInt(1, Integer.parseInt(salesOrderID[i]));
                        prepstm.setInt(2, Integer.parseInt(revisionNumber[i]));
                        prepstm.setString(3, orderDate[i]);
                        prepstm.setString(4, dueDate[i]);
                        prepstm.setString(5, shipDate[i]);
                        prepstm.setInt(6, Integer.parseInt(status[i]));
                        prepstm.setInt(7, Integer.parseInt(onlineOrderFlag[i]));
                        prepstm.setString(8, salesOrderNumber[i]);
                        prepstm.setString(9, purchaseOrderNumber[i]);
                        prepstm.setString(10, accountNumber[i]);
                        prepstm.setInt(11, Integer.parseInt(customerID[i]));
                        prepstm.setInt(12, Integer.parseInt(salesPersonID[i]));
                        prepstm.setInt(13, Integer.parseInt(territoryID[i]));
                        prepstm.setInt(14, Integer.parseInt(billToAddressID[i]));
                        prepstm.setInt(15, Integer.parseInt(shipToAddressID[i]));
                        prepstm.setInt(16, Integer.parseInt(shipMethodID[i]));
                        prepstm.setInt(17, Integer.parseInt(creditCardID[i]));
                        prepstm.setString(18, creditCardApprovalCode[i]);
                        prepstm.setString(19, currencyRateID[i]);
                        prepstm.setFloat(20, Float.parseFloat(subTotal[i]));
                        prepstm.setFloat(21, Float.parseFloat(taxAmt[i]));
                        prepstm.setFloat(22, Float.parseFloat(freight[i]));
                        prepstm.setFloat(23, Float.parseFloat(totalDue[i]));
                        prepstm.setString(24, comment[i]);
                        prepstm.setString(25, modifiedDate[i]);

                        prepstm.addBatch();
                        count++;
            }

            prepstm.executeBatch();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("count", count);
            map.put("type", "insertData");
            return new ModelAndView("index", "map", map);

        } else {
            String fileName = request.getParameter("csvFileName");

            // Load the driver.
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("fileName", fileName);
            map.put("type", "csvRead");
            return new ModelAndView("index", "map", map);
        }
    }    }
    

