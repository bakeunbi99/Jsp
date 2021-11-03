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
	 		//Ajax 통신(데이터 요청), 기본 옵션 4개(url, type, dataType, success)
	 		
	 		// 데이터 출력 태그객체 선택
	 		var tds = $('tr > td:nth-child(2)'); //4개짜리 태그 객체

	 		
	 		$('button').click(function(){
	 			$.ajax({
		 			url: './5_1.Json.jsp', //page경로
		 			type: 'get', //get/post
		 			dataType: 'json', //결과의 타입
		 			success: function(data){ //핸들러 이벤트
		 				//alert(data.uid);
		 				//text 함수는 태그안에 내용을 입력하는
		 				tds.eq(0).text(data.uid);
		 				tds.eq(1).text(data.name);
		 				tds.eq(2).text(data.hp);
		 				tds.eq(3).text(data.age);
		 			}
		 		});				
			});
	 		
	 		
	 		//alert('Hello jQuery!');
			//버튼 이벤트(click) 구현 
			//function() - 핸들러
			//$('button').click(function(){
			//	alert('Click!');				
			//});
	 		
	 	}); //ready() 시작하는 이벤트
	 	
	 </script>
	 
	 
</head>
<body>
	<h3> 4. Ajax 통신 실습하기 </h3>

	<button>데이터 가져오기</button>
	
	<table border="1">
		<tr>	
			<th>아이디</th>
			<td>-</td>
		</tr>
		<tr>	
			<th>이름</th>
			<td>-</td>
		</tr>
		<tr>	
			<th>휴대폰</th>
			<td>-</td>
		</tr>
		<tr>	
			<th>나이</th>
			<td>-</td>
		</tr>
		
	</table>
	
	
	
</body>
</html>

