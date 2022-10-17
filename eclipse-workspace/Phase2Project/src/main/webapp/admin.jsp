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
<h2>Admin Login</h2>
<div class="flight" id="flightbox">
  <div id="flight-depart">
          <div class="info-box">

<form action="admin" method="post">

			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /></form>
			<a href="index.jsp">Back</a>
			</div></div></div>
			</body>
			
</html>