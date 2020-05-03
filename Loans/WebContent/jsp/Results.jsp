<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Loans</title>
<h1 style="color:white; text-align:center;"> Loan Repayment Schedule</h1>

</head>
<body bgcolor="#008080" style="text-align:center;">
<center>

	<table id="messages" border="1" style="background-color: #eee">
            <tr>
                <th><h3  style="color:#001f3f">Payment No</h3></th>
                <th><h3  style="color:#001f3f">Principal</h3></th>
                <th><h3  style="color:#001f3f">Interest</h3></th>
                <th><h3  style="color:#001f3f">Unpaid Amount</h3></th>
                <th><h3  style="color:#001f3f">Total Interest</h3></th>                
            </tr>
			
			<c:forEach var="msg" items="${messageList}">
            
                <tr>
                    <td><h4 style="color:#001f3f" align="right">${msg[0]}</h4></td>
                    <td><h4 style="color:#001f3f" align="right">${msg[1]}</h4></td>
                    <td><h4 style="color:#001f3f" align="right">${msg[2]}</h4></td>
                    <td><h4 style="color:#001f3f" align="right">${msg[3]}</h4></td>
                    <td><h4 style="color:#001f3f" align="right">${msg[4]}</h4></td>
            	</tr>
            </c:forEach>    
     </table>   
<center>
</body>
</html>