<%@page import="com.kpi.greenbank.controller.websession.ActiveSession" %>
<%
    ActiveSession.deleteUserFromActiveSession(request);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>