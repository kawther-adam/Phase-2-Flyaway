<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/index-styles.css" rel="stylesheet" />
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<div id="search-form">
    <div id="header">
    </div>
</head>
<body>
<h2>Search Flight Details</h2>
<div class="flight" id="flightbox">
  <div id="flight-depart">
          <div class="info-box">
<form action="SearchFlightDetails" method="post">
	<label>DOJ</label>
	<input type="date" name="doj">
	<label>Source</label>
	<input type="text" name="source">
	<label>Destination</label>
	<input type="text" name="destination">
	<label>NumberOfTicket</label>
	<input type="number" name="seats"><br/>
	<input type="submit" value="Search Flight Details">
	<input type="reset" value="reset">
</form></div></div></div>
<br/>
<%
Object obj = request.getAttribute("flightDetails");
if(obj!= null){
		
		List<Object[]> listOfFlight= (List<Object[]>)obj;
		if(listOfFlight.size()==0){
			out.println("No Flight are availabe");
		}else {
			Iterator<Object[]> li = listOfFlight.iterator();
			while(li.hasNext()){
				Object o[] = li.next();
				%>
				<li>Flight Name <%=o[0] %> Price <%=o[1] %> <a href="BookFlight?fid=<%=o[2]%>&pid=<%=o[3]%>&seats=<%=request.getAttribute("seats")%>">Book</a></li>
				<%
			}
		}
}
%>
<br/>
<a href="index.jsp">Back</a>
</body>
</html>