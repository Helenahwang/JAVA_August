<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage = "true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>

	<h3>메세지 : <%=exception.getMessage() %></h3>
	<p>에러가 발생하였습니다. 조취를 취하세요.</p>

</body>
</html>