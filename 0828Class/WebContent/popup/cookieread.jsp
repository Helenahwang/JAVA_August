<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
</head>
<body>
<%@ page import = "java.util.*" %>
	<%
		Cookie[] cookies=request.getCookies(); //서버에서 쿠키만들어 클라이언트에 저장하고, 쿠키를 불러옴 
	
		boolean flag = false;
		int a = -1;
		int b = -1;
		if(cookies != null){
			for(Cookie cookie:cookies){
				
				if(cookie.getName().equals("popup")){
					flag = true;
					out.println(cookie.getMaxAge());
					b=cookie.getMaxAge()*100;
					out.println(b);
					
				}
				if(cookie.getName().equals("time")){
				
					a = Integer.parseInt(cookie.getValue());
					a = a * 100;
				}
			}
		}
		
		/*
		if(flag==false){ //유효시간이 끝나면 팝업창 뜨도록... 
			out.println("<script>");
			// window.open(디렉토리, 이름, 옵션...)
			out.println("window.open('https://www.google.com','google','width=600','height=300')");
			out.println("</script>");
		}
		*/
		
		
		if(flag==true){ //유효시간이 끝나면 팝업창 뜨도록... 
			
			out.println("<script>");
			
			// window.open(디렉토리, 이름, 옵션...)
			out.println("var x = window.open('https://www.google.com','google','width=600','height=300')");
			out.println("setTimeout(function(){x.close()}," + b+")");
			out.println("</script>");
		}
		
		
		
		
	%>
</body>
</html>