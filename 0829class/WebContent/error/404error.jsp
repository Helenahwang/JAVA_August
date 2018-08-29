<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404에러페이지</title>
</head>
<body>
	<p>3초후에 메인페이지로 이동합니다.</p>
	<h3>404. That’s an error.</h3>
	
	The requested URL /aksjdkfjaksldjg was not found on this server. That’s all we know.
	
</body>

<script>
	setTimeout(function(){
		location.href="javabean/beancreate.jsp"},3000) //3초뒤 이동 

</script>


</html>