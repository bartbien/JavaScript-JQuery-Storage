
<%@ page import="java.lang.String" %>
<%
	String q = request.getParameter("q");
	
	response.getWriter().write("test " + q);
%>