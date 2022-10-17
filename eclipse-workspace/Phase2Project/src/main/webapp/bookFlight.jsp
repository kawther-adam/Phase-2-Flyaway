<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Booking Flight Details</h2>
<%
Object obj = request.getAttribute("bookingDetails");
if(obj!= null){
		
		List<Object[]> listOfFlight= (List<Object[]>)obj;
		if(listOfFlight.size()==0){
			out.println("No Flight are availabe");
		}else {
			Iterator<Object[]> li = listOfFlight.iterator();
			while(li.hasNext()){
				Object o[] = li.next();
				%>
				<form action="BookFlightConfimation" method="post">
				<label>Flight Name</label>
				<input type="text" name="flightname" value="<%=o[0]%>" readonly="readonly"><br/>
				<label>Flight Price</label>
	<input type="text" name="price" value="<%=Float.parseFloat(o[1].toString())* Integer.parseInt(request.getParameter("seats").toString())%>" readonly="readonly"><br/>
				
				<label>NumberOfSearchj</label>
				<input type="text" name="numberofseats" value="<%=request.getParameter("seats") %>" readonly="readonly"><br/>
				<label>FID</label>
				<input type="text" name="fid" value="<%=o[2]%>" readonly="readonly"><br/>
				<label>PID</label>
				<input type="text" name="pid" value="<%=o[3]%>" readonly="readonly"><br/>
				<label>Source</label>
				<input type="text" name="source" value="<%=o[4]%>" readonly="readonly"><br/>
				<label>Destination</label>
				<input type="text" name="destination" value="<%=o[5]%>" readonly="readonly"><br/>
				<label>PName</label>
				<input type="text" name="pname"><br/>
				<label>CreditCard/Debit Card Nubmer</label>
				<input type="text" name="cart" placeholder="0000-0000-0000-000"><br/>
				<label>PinNumber</label>
				<input type="password" name="pin"><br/>
				<input type="submit" value="Book Confirmation">
				<input type="reset" value="reset">
				</form>
				<%
			}
		}
}
%>
</body>
</html>