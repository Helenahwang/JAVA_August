<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ page errorPage="errorview.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생 페이지</title>
</head>
<body>

	<!-- <%= request.getParameter("email") %> --> <!-- 에러발생하지 않는다 -->
	
	<!-- email이라는 파라미터가 없는데 메소드(trim())를 호출해서 NullPointerException이 발생한다 -->
	<%= request.getParameter("email").trim() %>
	
</body>
</html>