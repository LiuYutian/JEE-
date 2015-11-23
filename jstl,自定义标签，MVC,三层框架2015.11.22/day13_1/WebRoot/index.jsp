<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 创建域属性：默认pageContext域 -->
    <c:set scope="request" var="code" value="<script>alert('hello');</script>"></c:set>
    
    <!-- 输出并转义 -->
    <c:out value="${code }" default="内容为null" escapeXml="true"></c:out>
    <br>
    <!-- 删除域变量 没有scope表示全部域中变量(属性)全部删除 -->
    <c:remove var="code"/>
    
    <!-- url保存到域或输出到页面，url后面加参数 ，默认添加项目名，-->
    <c:url value="/index.jsp"></c:url>
    <br>
    <c:url value="/index.jsp">
    	<c:param name="username" value="张三"></c:param>
    </c:url>
    <br>
    <!-- 保存到域 -->
    <c:url value="/index.jsp" var="url"></c:url>
    <c:out value="${url }" default="内容为null" escapeXml="true"></c:out>
    <br>
    <a href="<c:url value='index.jsp'/>">点击这里</a>
    <br>
    
    <!-- if标签  如果param.name如果为空执行内部标签-->
    <c:url value='/index.jsp'>
    	<c:param name="name">张三</c:param>
    </c:url>
    <br>
    
    <c:if test="${empty param.name }">
    	你没有给出名为name的参数
    </c:if>
    
    <!-- if else -->
	<c:choose>
		<c:when test="${empty param.name }">
			你没有给出name的参数
		</c:when>
		<c:otherwise>
			谁让你给出name参数的 ${param.name }
		</c:otherwise>
	</c:choose>
	<br>
	<!-- forEach 循环遍历数组集合-->
	<c:forEach var="i" begin="0" end="10" step="2">
		${i }
	</c:forEach>
	<!-- var 循环变量 begin起始变量，结束变量， step步长 -->
	<br>
	<% 
	String[] strs = {"one", "two", "three"}; 
	request.setAttribute("strs", strs);
	%>
	<c:forEach items="${requestScope.strs }" var="str">
	${str }
	</c:forEach>
	<!-- items 要遍历的对象 -->
	<hr>
	
	<!-- forEach 循环状态-->
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("一");
	list.add("二");
	list.add("三");
	pageContext.setAttribute("list", list);
	%>
	<c:forEach items="${list }" var="ele" varStatus="vs">
		${vs.count }
		${vs.index }
		${vs.first }
		${vs.last }
		${vs.current }<br>
	</c:forEach>
	<!-- 
	count：循环元素的个数
	index：元素下标
	first：是否为第一个元素
	last：是否为最后一个元素
	current：当前元素
	 -->

  </body>
</html>
