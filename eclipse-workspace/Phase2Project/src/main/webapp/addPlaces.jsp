<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="css/index-styles.css" rel="stylesheet" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<div id="search-form">
    <div id="header">
    </div>
</head>
<body>
<h2>Add Place Details</h2>
<div class="flight" id="flightbox">
  <div id="flight-depart">
          <div class="info-box">
<form action="AddPlaceDetails" method="post">
<label>Place ID</label>
<input type="number" name="pid"><br/>
<label>Source</label>
<input type="text" name="source"><br/>
<label>Destination</label>
<input type="text" name="destination"><br/>
<input type="submit" value="Store Place Details">
<input type="reset" value="reset">
</form>
</div></div></div>
<br/>
<a href="index.jsp">Back</a>
</body>
</html>