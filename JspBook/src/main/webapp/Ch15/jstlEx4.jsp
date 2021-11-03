<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL core 태그 예제 - forTokens</title>
	
</head>
<body>
	<h3>JSTL core 태그예제 - forTokens</h3>
		<c:forTokens items="tech" items="금강불괴,허공담보,열양기공,천마군림보" delims="."></c:forTokens>
		<p>익혀야할 기술 : <c:out value="${tech }" /></p>
		
	
</body>
</html>


