<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포함하는 페이지</title>
</head>
<body>
	<p> jsp include는 다른 페이지의 수행 결과를 포함하는 페이지이다.</p >
	<%@page import = "java.net.*" %>
	<%
		String data = URLEncoder.encode("데이터", "utf-8");	
	%>
	<jsp:include page="sub.jsp" flush="false" >
		<jsp:param name="data" value="<%=data %>"  />
	</jsp:include>
	
</body>
</html>