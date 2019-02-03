<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page - CSV</title>
    </head>

    <body>
        <h1> CSV Read and Upload</h1>
        <form id="myForm" action="csv/csv.htm" method="post">
            <c:if test="${(requestScope.map.type ne 'csvRead') && (requestScope.map.type ne 'insertData')}">
                Enter the file name : <input type="text" name="csvFileName"/>
                <br/><input type="submit" value="Submit"/>
            </c:if>
            <c:if test="${(requestScope.map.type eq 'csvRead')}">
                <table style="width:80%">
                    <!-- here should go some titles... -->
                    <tr>
                        <th>SalesOrderID</th>
                        <th>RevisionNumber</th>
                        <th>OrderDate</th>
                        <th>DueDate</th>
                        <th>ShipDate</th>
                        <th>Status</th> 
                        <th>OnlineOrderFlag</th>
                        <th>SalesOrderNumber</th>
                        <th>PurchaseOrderNumber</th>
                        <th>AccountNumber</th>
                        <th>CustomerID</th>
                        <th>SalesPersonID</th>
                        <th>TerritoryID</th>
                        <th>BillToAddressID</th>
                        <th>ShipToAddressID</th>
                        <th>ShipMethodID</th>
                        <th>CreditCardID</th>
                        <th>CreditCardApprovalCode</th>
                        <th>CurrencyRateID</th>
                        <th>SubTotal</th>
                        <th>TaxAmt</th>
                        <th>Freight</th>
                        <th>TotalDue</th>
                        <th>Comment</th>
                        <th>ModifiedDate</th>

                    </tr>
                    <c:set var="i"   value="0" />

                    <c:forEach items="${requestScope.map.csvList}" begin="0" end="100" step="1" var="data" >
                        <tr>

                            <td><input style="width:100%"  type="text" name="salesOrderID${i}" value=${data.salesOrderID} /></td>
                            <td><input style="width:100%"  type="text" name="revisionNumber${i}" value=${data.revisionNumber} /></td>
                            <td><input style="width:100%"  type="text" name="orderDate${i}" value=${data.orderDate} /></td>
                            <td><input style="width:100%"  type="text"  name="dueDate${i}" value=${data.dueDate} /></td>

                            <td><input style="width:100%"  type="text" name="shipDate${i}" value=${data.shipDate} /></td>
                            <td><input style="width:100%"  type="text" name="status${i}" value=${data.status} /></td>
                            <td><input style="width:100%"  type="text" name="onlineOrderFlag${i}" value=${data.onlineOrderFlag} /></td>
                            <td><input style="width:100%"  type="text"  name="salesOrderNumber${i}" value=${data.salesOrderNumber} /></td>

                            <td><input style="width:100%"  type="text" name="purchaseOrderNumber${i}" value=${data.purchaseOrderNumber} /></td>
                            <td><input style="width:100%"  type="text" name="accountNumber${i}" value=${data.accountNumber} /></td>
                            <td><input style="width:100%"  type="text" name="customerID${i}" value=${data.customerID} /></td>
                            <td><input style="width:100%"  type="text"  name="salesPersonID${i}" value=${data.salesPersonID} /></td>

                            <td><input style="width:100%"  type="text" name="territoryID${i}" value=${data.territoryID} /></td>
                            <td><input style="width:100%"  type="text" name="billToAddressID${i}" value=${data.billToAddressID} /></td>
                            <td><input style="width:100%"  type="text" name="shipToAddressID${i}" value=${data.shipToAddressID} /></td>
                            <td><input style="width:100%"  type="text"  name="shipMethodID${i}" value=${data.shipMethodID} /></td>

                            <td><input style="width:100%"  type="text" name="creditCardID${i}" value=${data.creditCardID} /></td>
                            <td><input style="width:100%"  type="text" name="creditCardApprovalCode${i}" value=${data.creditCardApprovalCode} /></td>
                            <td><input style="width:100%"  type="text" name="currencyRateID${i}" value=${data.currencyRateID} /></td>
                            <td><input style="width:100%"  type="text"  name="subTotal${i}" value=${data.subTotal} /></td>

                            <td><input style="width:100%"  type="text" name="taxAmt${i}" value=${data.taxAmt} /></td>
                            <td><input style="width:100%"  type="text" name="freight${i}" value=${data.freight} /></td>
                            <td><input style="width:100%"  type="text" name="totalDue${i}" value=${data.totalDue} /></td>
                            <td><input style="width:100%"  type="text"  name="comment${i}" value=${data.comment} /></td>

                            <td><input style="width:100%"  type="text"  name="modifiedDate${i}" value=${data.modifiedDate} /></td>

                            <c:set var="i" value="${i+1}"/>

                        </tr>
                    </c:forEach>
                </table>
                    <input type="submit" value="Insert" name="action"/>
            </c:if>
            <c:if test="${(requestScope.map.type eq 'insertData')}">
                  <h3>${requestScope.map.count} records is been added to DataBase</h3>
            </c:if>
        </form>
    </body>
</html>
