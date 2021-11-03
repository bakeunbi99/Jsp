<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5_5_Ajax</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			
			var table = $('table > tbody');
			
			$('button').click(function(){
				//데이터 요청하기.
				$.ajax({
					url: './5_3_Json.jsp',
					type: 'get',
					dataType: 'json',
					success: function(data){ //list가 들어옴 (jQuery 배열)
						
					
						//통적 태그 추가 <td>
						for(var i=0; i<data.length; i++){
							//alert(data[i].name);
							table.append('<tr></tr>'); //동적태그를 삽입하는 태그	
							
							table.find('tr:last-child').append('<td>'+data[i].uid+'</td>');
							table.find('tr:last-child').append('<td>'+data[i].name+'</td>');
							table.find('tr:last-child').append('<td>'+data[i].hp+'</td>');
							table.find('tr:last-child').append('<td>'+data[i].pos+'</td>');
							table.find('tr:last-child').append('<td>'+data[i].dep+'</td>');
							table.find('tr:last-child').append('<td>'+data[i].rdate+'</td>');
						}
						
					}
				
				});//ajax
				
			})//button click Event
			
		});//Ready() Event
		
	</script>
	
	
	<!--
		날짜 : 2021/08/09 11:55
		이름 : 박은비
		내용 : Ajax 
	 -->
	 
	 
</head>
<body>
	<h3>5.Ajax 통신 실습하기</h3>
	
	<button>데이터 불러오기</button>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>입사일</th>
		</tr>
	</table>

</body>
</html>