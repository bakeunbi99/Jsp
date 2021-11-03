<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jQuery Ajax-load() 응답처리</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#b1").click(function(){
				$("#result").load("xhrTest3.test", function(responce.stu.xhr)){
					if(stu =="success")
						alert("로드 성공!")
					if(stu=="erroe")
						alert("에라: " + xhr.status+": "+xhr.stu)
				}
			})
			
		})
	</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>

</body>
</html>