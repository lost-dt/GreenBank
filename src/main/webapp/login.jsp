<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
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
		<div class="row">
			<div class="jumbotron col-md-6 col-md-offset-3"
				style="margin-top: 50px">
				<h1 style="margin-bottom: 30px" class="col-md-10 col-md-offset-1">Sign
					in to your account</h1>
				<div class="row">
					<div class="col-md-6 col-md-offset-2">
						<form method="post" action="${pageContext.request.contextPath}/login">
							<div class="form-group">
								<label>Email</label>
								<input type="text" name="email" required class="form-control" id="email">
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" name="password" required class="form-control" id="password">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">
									Remember Me
								</label>
							</div>
							<%
							    String userExists = (String) request.getAttribute("userExists");
								if (userExists != null) {
							%>
							<div class="alert alert-danger" role="alert">

								<strong>Account No/Password doesn't match.</strong>
							</div>
							<%
								}
							%>
							<%
								String userAlreadyLogin = (String) request.getAttribute("userAlreadyLogin");
								if (userAlreadyLogin !=null && userAlreadyLogin.equals("yes")) {

							%>
							<div class="alert alert-danger" role="alert">
								<strong>You already login!</strong>
							</div>
							<%
								}
							%>
							<input type="submit" class="btn btn-primary btn-lg" value="Sign to your account"/>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"/>
		</div>
	</div>
</body>
</html>