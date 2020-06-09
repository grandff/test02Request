<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	<h2>이름 : ${model.name }</h2>
	<h2>번호 : ${model.tel }</h2>
	<div>
		<form name="form1" action="updateOK.do" method="post">
			${model.num }
			<input type="hidden" name="num" placeholder = "번호" value="${model.num }"/>
			<input type="text" name="name" placeholder = "이름" value="${model.name }"/>
			<input type="text" name="tel" placeholder = "번호" value="${model.tel }"/>			
			<input type="submit">				
		</form>
	</div>	
</body>
</html>