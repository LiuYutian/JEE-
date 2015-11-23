<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function _change() {
			// 得到img元素，修改src
			var imgEle = document.getElementById("img");
			imgEle.src = "/day11_3/VerifyCodeServlet?a=" + new Date().getTime();
		}
	</script>

  </head>
  <body>
    <%-- 本页面提供登录表单，还显示错误信息 --%>
    <h1>登录</h1>
    <%
    	String message = "";
    	String msg = (String)request.getAttribute("msg");
    	if(msg != null) {
    		message = msg;
    	}
    	String uname = "";
    	Cookie[] cookies = request.getCookies();
    	if(cookies!=null) {
    		for(Cookie c : cookies) {
    			if("uname".equals(c.getName())) {
    				uname = c.getValue();
    			}
    		}
    	}
    %>
    
    <font color="red"><b><%=message%></b></font>
    <form action="/day11_3/LoginServlet" method="post">
    	用户名：<input type="text" name="username" value="<%=uname%>"/><br>
    	密    码：<input type="password" name="password"><br>
    	验证码：<input type="text" name="verifyCode" size="3"/>
	    	<%-- 请求VersifyCodeServlet，获取OutputStream中的数据  --%>
	    	<img id="img" alt="验证码" src="/day11_3/VerifyCodeServlet">
	    	<a href="javascript:_change()">换一张</a>
    	<br>
    	<input type="submit" value="登录"/><br>
    </form>
  </body>
</html>
