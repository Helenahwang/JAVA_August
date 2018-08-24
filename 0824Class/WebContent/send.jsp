<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전송</title>
</head>
<body>
	<!--첫번째 방법 -->
	<a href="parameterreceive.jsp?name=park&age=33&address=서울시 종로">파라미터 전송</a>
	
	<!--두번째 방법 <form action = "파라미터 받을 주소" method = "전송방식">-->
	<form action = "formreceive.jsp" method = "get">
	이메일<input type="email" name="email"/><br/>
	<fieldset>
		<legend>성별</legend>
		<input type="radio" value="woman" name="gender" checked="checked"/>여자
		<input type="radio" value="man" name="gender"/> 남자
	</fieldset>
	
	<fieldset>
		<legend>취미</legend>
		<input type="checkbox" value="reading" name="hobby"/>독서
		<input type="checkbox" value="game" name="hobby"/>게임
		<input type="checkbox" value="workout" name="hobby"/>운동
		<input type="checkbox" value="programming" name="hobby"/>프로그래밍
	</fieldset>
	
	<br/><input type = "submit" value="전송" />
	
	</form>
	
</body>
</html>