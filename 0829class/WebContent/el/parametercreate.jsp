<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터와 쿠키 생성 및 저</title>
</head>
<body>

<%
	Cookie cookie = new Cookie("sessionid","qwertyuiop");
	response.addCookie(cookie);
	
%>

<a href="parameterdisplay.jsp?query=rain">파라미터출력</a>

</body>
</html>