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
<div align = "center" >
<h2>Add Flight Details</h2>
<div class="flight" id="flightbox">
  <div id="flight-depart">
          <div class="info-box">
         
<form action="AddFlightDetails" method="post">
<label>Flight ID</label>
<input type="number" name="fid"><br/>
<label>Flight Name</label>
<input type="text" name="flightname"><br/>
<label>Price</label>
<input type="number" name="price"><br/>
<label>Date Of Flight</label>
<input type="date" name="dof"><br/>
<label>Number of seats</label>
<input type="number" name="seats"><br/>
<label>PlaceId</label>
<input type="number" name="pid"><br/>
<input type="submit" value="Store Flight Details">
<input type="reset" value="reset">
</form>
</div>
</div></div></div>
<br/>
<div align = "center">
<a href="index.jsp">Back</a></div></div>
</body>
</html>