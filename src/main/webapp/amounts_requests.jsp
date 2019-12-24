<%@ page import="java.util.List" %>
<%@ page import="com.kpi.greenbank.model.dto.AmountTransactionDTO" %>
<%@ page import="com.kpi.greenbank.model.dto.UserDTO" %>
<%@ page import="com.kpi.greenbank.model.service.AmountTransactionService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Request List</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/loan_request.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%
	UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");
	List<AmountTransactionDTO> amountTransactionDTOS =
			new AmountTransactionService().loadAllWaitAmountTransactions();
%>


	<div class="row">
		<jsp:include page="header.jsp" />
	</div>
	<div class="container-fullwidth">
		<div class="row" style="margin-top: 50px;">
			<div class="col-md-8 col-md-offset-2">
				<h3>Loan Requests</h3>
				<div class="table-responsive" style="margin-top: 40px">


					<table id="mytable" class="table table-bordred table-striped">

						<thead>
							<th>Amount ID</th>
							<th>User Email</th>
							<th>Amount Value</th>
							<th>Status</th>
							<th>Approve</th>
							<th>Delete</th>
						</thead>
						<tbody>
							<%
								for (AmountTransactionDTO l : amountTransactionDTOS) {
							%>
							<tr>
								<td><%=l.getId()%>
								</td>
								<td><%=l.getUserEmail()%>
								</td>
								<td><%=l.getAmountValue()%>
								</td>
								<td><%=l.getStatus().getTitle()%>
								</td>
								<td><p data-placement="top" data-toggle="tooltip" title="Approve">
										<a
											href="${pageContext.request.contextPath}/amount_request?
											userEmail=<%=l.getUserEmail()%>
											&amountValue=<%=l.getAmountValue()%>
											&transactionId=<%=l.getId()%>
											&status=ACCEPT
											&handledBy=<%=userDTO.getEmail()%>"><button
												class="btn btn-primary btn-sm" data-title="Approve"
												data-toggle="modal" data-target="#edit">
												<span class="glyphicon glyphicon-ok"></span>
											</button></a>
									</p></td>
								<td><p data-placement="top" data-toggle="tooltip" title="Delete">
										<a
											href="${pageContext.request.contextPath}/amount_request?
											userEmail=<%=l.getUserEmail()%>
											&amountValue=<%=l.getAmountValue()%>
											&transactionId=<%=l.getId()%>
											&status=CLOSE
											&handledBy=<%=userDTO.getEmail()%>">
										<button class="btn btn-danger btn-sm" data-title="Delete"
											data-toggle="modal" data-target="#delete">
											<span class="glyphicon glyphicon-trash"></span>
										</button></a>
									</p></td>
							</tr>
							<%
								}
							%>

						</tbody>

					</table>


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