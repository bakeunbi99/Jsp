<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL core 태그 예제 - forEach</title>
	
</head>
<body>
	<c:forEach var="head" items="${headerValues}">
		<p>param : <c:out value="${head.key}" />
		<p>values:
			<c:forEach var="val" items="${head.value }">
				<c:out value="${val }" />
			</c:forEach>
	</c:forEach>
	
</body>
</html>