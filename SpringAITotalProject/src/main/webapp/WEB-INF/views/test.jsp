<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
	1. Front : Vue / React / Jquery
	                            | 유지보수
	                  | 대기업 / 금융
	          | 중소기업
	2. DB단 : MyBatis / JPA
	3. Back : SpringFramework / Spring-Boot
	              | JSP             | ThymeLeaf
	4. 보안 : Spring Security / JWT
	5. SE : CI/CD
	------------------------------------------ Full Stack
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach var="str" items="${map }">
			<li>${str }</li>
		</c:forEach>
			
		
	</ul>
</body>
</html>