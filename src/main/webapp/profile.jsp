<%@page import="com.kpi.greenbank.model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	UserDTO user = (UserDTO) session.getAttribute("currentUserEntity");
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=user.getFirstName() + " " + user.getLastName()%></title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/profile.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>

	<div class="container-fullwidth">
		<div class="jumbotron col-md-6 col-md-offset-3"
			style="margin-top: 50px">
			<div class="row">
				<div class="profile-head col-md-10 col-md-offset-1">
					<div class="col-md-4 ">
						<img class="img-circle img-responsive" alt="" src="image/user.png">
					</div>


					<div class="col-md-6 ">
						<h2><%=user.getFirstName() + " " + user.getLastName()%></h2>
						<ul>
							<li class="navli"><span
								class="glyphicon glyphicon-map-marker"></span> <%=user.getBranch().getTitle()%></li>
							<li class="navli"><span class="glyphicon glyphicon-home"></span>
								<%=user.getAddress()%></li>
							<li class="navli"><span class="glyphicon glyphicon-phone"></span><%=user.getPhoneNumber()%></li>
							<li class="navli"><span class="glyphicon glyphicon-envelope"></span><%=user.getEmail()%></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="account_details col-md-10 col-md-offset-1"
					style="margin-top: 30px;">
					<h2>Account Details</h2>
					<hr class="divider">
					<table class="table table-user-information col-md-6">
						<tbody>
							<tr>
								<td><b>First Name:</b></td>
								<td><%=user.getFirstName()%></td>
							</tr>
							<tr>
								<td><b>Last Name:</b></td>
								<td><%=user.getLastName()%></td>
							</tr>
							<tr>
								<td><b>Account Value:</b></td>
								<td><%=user.getAmount()%></td>
							</tr>
							<tr>
								<td><b>City</b></td>
								<td><%=user.getCity()%></td>
							</tr>
							<tr>
								<td><b>Branch Name</b></td>
								<td><%=user.getBranch().getTitle()%></td>
							</tr>
							<tr>
								<td><b>Zip</b></td>
								<td><%=user.getZip()%></td>
							</tr>
							<tr>
								<td><b>Phone Number</b></td>
								<td><%=user.getPhoneNumber()%></td>
							</tr>
							<tr>
								<td><b>Email</b></td>
								<td><a href="mailto:" + <%=user.getEmail()%>><%=user.getEmail()%></a></td>
							</tr>
							<tr>
								<td><b>User Role</b></td>
								<td><%=user.getRole().getTitle()%></td>
							</tr>
							<tr>
								<td><b>Amount</b></td>
								<td><%=user.getAmount()%>&#x24;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row"></div>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"/>
		</div>
	</div>
</body>
</html>