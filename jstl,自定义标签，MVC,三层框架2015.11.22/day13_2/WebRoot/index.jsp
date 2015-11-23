<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="l" uri="http://www.lyt.com/tags/it-1.0" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
  	request.setAttribute("xxx", "XXX");
  %>
    <l:myTag1/>
    <br>
  	<l:myTag2/>
  	<br>
  	<l:myTag5 test="${empty param.xxx }">
	  	<l:myTag4/>
  	</l:myTag5>
  	<l:myTag3>lyt</l:myTag3>
  	<br>
  	<l:myTag3>${xxx }</l:myTag3>
  	<br>
  </body>
</html>
