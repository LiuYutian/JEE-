<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();	// 获取项目名
// http://localhost:8080/day11_1/
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					// 获取协议名					// 获取地址名				// 获取服务器端口号			// 项目名称
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 页面输出basePath base中地址会写在每一个链接地址的前面，用以统一路径 -->
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
    This is my JSP page. <br>
    <a href="hello.html">hello</a>
    
    <% int a = 10; %>
    <% out.print(a); %>
    <%=add(1, 4)%>
    <%! int add(int a, int b) {
    	return a + b;
    } %>
    <%-- 客户端看不到 --%>
  </body>
</html>
