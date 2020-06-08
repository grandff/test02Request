<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>목록 화면</h1>
		<table border = "1">
			<thead>
				<tr>
					<th>이름</th>
					<th>연락처</th>
				</tr>
			</thead>
			<tbody>
			<!-- 목록 on -->
				<c:forEach var="vo" items="${list }" >
				<tr>
					<td><a href="selectOne.do?name=${vo.name }&tel=${vo.tel}">${vo.name }</a></td>
					<td>${vo.tel }</td>
				</tr>
				</c:forEach>								
			<!-- 목록 off -->
			</tbody>
		</table>		
	</div>
</body>
</html>