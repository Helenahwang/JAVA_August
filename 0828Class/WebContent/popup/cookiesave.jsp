<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie=new Cookie("popup", "12345");
		
		//쿠키의 수명 설정
		cookie.setMaxAge(60);

	    out.println(cookie.getMaxAge());
		
		
		Cookie cookie1=new Cookie("time", "60");
		//쿠키를 브라우저에 추가
		response.addCookie(cookie);
		response.addCookie(cookie1);
		
	%>

	<a href="cookieread.jsp">팝업띄우기</a>
	
</body>

</html>