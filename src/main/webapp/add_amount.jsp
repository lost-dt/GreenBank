<%@ page import="com.kpi.greenbank.model.dto.UserDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amount</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/deposit.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>
	<div class="container-fullwidth">
		<%
			UserDTO user = (UserDTO) session.getAttribute("currentUserEntity");
			if (user != null) {
		%>
		<div class="row" style="margin-top: 50px;">
			<div class="col-md-4 col-md-offset-4">
				<h2>Amount Request</h2>
				<hr>
				<div class="col-md-12">
					<form method="post" action="${pageContext.request.contextPath}/amount_transaction">
						<div class="form-group">
							<label for="input" class="col-sm-4 control-label">
								Amount Value</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon">&#x24;</span> <input
										name="amountValue" class="form-control input-sm" id="input"
										placeholder="Enter amount value" type="number"> <input
										type="hidden" name="account_no"
										value="<%=user.getEmail()%>" />
										
										<input
										type="hidden" name="first_name"
										value="<%=user.getFirstName()%>" />
										
										<input
										type="hidden" name="last_name"
										value="<%=user.getLastName()%>" />
										
										<input
										type="hidden" name="address"
										value="<%=user.getAddress()%>" />
										
										<input
										type="hidden" name="email"
										value="<%=user.getEmail()%>" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-12" style="margin-top: 20px;">
								<input type="submit" class="btn btn-primary btn-lg"
									   value="Submit"/>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="row" style="margin-top: 150px;">
			<div class="alert alert-warning col-md-4 col-md-offset-4"
				role="alert">
				<strong>Warning!</strong> You have to login first.
			</div>
		</div>

		<%
			}
		%>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"/>
		</div>
	</div>
</body>
</html>