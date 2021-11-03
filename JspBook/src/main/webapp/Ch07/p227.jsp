<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5_4_Ajax</title>
	
	<!-- 
		날짜 : 2021/08/09
		이름 : 박은비
		내용 : AJAX 실습하기.
		
		AJAX(Asynchronous JavaScript And xml)
			- 일반적인 페이지 요청을 위한 HTTP 통신과 다르게 데이터 요청을 위한 부분적인 통신(비동기)
			- 데이터 결과는 일반적으로 Json 사용
	 -->
	 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	 <script>
		//jQuery 시작 함수 
	 	$(document).ready(function(){

	 		$('button').click(function(){
	 			alert('button click event');
	 		})
			
	 		
	 	}); //ready() 시작하는 이벤트
	 	
	 </script>
	 
	 
</head>
<body>
	<h3> Ajax 실습하기 </h3>

	<button>데이터 가져오기</button>
	
	
</body>
</html>
