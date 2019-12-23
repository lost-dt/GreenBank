<%@ page import="java.util.List" %>
<%@ page import="com.kpi.greenbank.model.dto.AmountTransactionDTO" %>
<%@ page import="com.kpi.greenbank.model.dao.interfase.AmountTransactionDao" %>
<%@ page import="com.kpi.greenbank.model.dto.UserDTO" %>
<%@ page import="com.kpi.greenbank.model.service.AmountTransactionService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Loan Request List</title>
    <link rel="shortcut icon" type="image/png" href="image/favicon.png"/>
    <link rel="stylesheet" type="text/css" href="css/loan_request.css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row">
    <jsp:include page="header.jsp"/>
</div>
<div class="container-fullwidth">
	<%
		UserDTO user = (UserDTO) session.getAttribute("currentUserEntity");
		if (user != null) {
	%>
    <div class="row" style="margin-top: 50px;">
        <div class="col-md-8 col-md-offset-2">
            <h3>Loan Requests</h3>
            <div class="table-responsive" style="margin-top: 40px">


					<%
						UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");
						List<AmountTransactionDTO> amountTransactionDTOS =
								new AmountTransactionService().loadAllAmountTransactionsByUserEmail(userDTO.getEmail());
						System.err.println(amountTransactionDTOS);
					%>


					<table id="mytable" class="table table-bordred table-striped">

                        <thead>
                        <th>Amount ID</th>
                        <th>Amount Value</th>
                        <th>Status</th>
                        </thead>
                        <tbody>
                        <%
                            for (AmountTransactionDTO l : amountTransactionDTOS) {
                        %>
                        <tr>
                            <td><%=l.getId()%>
                            </td>
                            <td><%=l.getAmountValue()%>
                            </td>
                            <td><%=l.getStatus().getTitle()%>
                            </td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>

                    </table>
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