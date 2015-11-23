<h1>b.jsp</h1>
<%
	out.print(request.getParameter("username"));
	out.print(",");
	out.print(request.getParameter("password"));
%>