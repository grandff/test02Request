<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>등록 화면</h1>
		<form name="form1" action="insertOK.do" method="post">
			<input type="text" name="name" placeholder = "이름"/>
			<input type="text" name="tel" placeholder = "010"/>			
			<input type="submit">				
		</form>
		
		<a href="/insert.do">등록</a>
		<a href="/selectAll.do">목록</a>
		<a href="/">홈으로</a>
	</div>
</body>
</html>