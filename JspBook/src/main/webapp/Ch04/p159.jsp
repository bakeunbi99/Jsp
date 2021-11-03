<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>session</title>
	
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(id.equals("kingdora") && pass.equals("1234") )
			session.setAttribute("id", id);
		
		response.sendRedirect("p160.jsp");
	
	%>


</body>
</html>