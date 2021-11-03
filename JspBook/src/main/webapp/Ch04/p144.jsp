<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width.initial-scale=1.0"/>

<h2>request 예제 - 요청 메소드</h2>

<form action="p146.jsp" method="post">
	<dl>
		<dd>
			<lable for="name"> 이름 </lable>
			<input id="name" name="name" type="text"
				placeholder="김개동"	aufofocus required />
		</dd>
		
		<dd>
			<lable for="age"> 나이 </lable>
			<input id="age" name="age" type="number"
				min = "20" max="99" value = "20" required>
		</dd>
		
		<dd>
			<fieldset style="width:300px">
				<legend>성별</legend>
				<input id="gender" name="gender" type="radio" value="m" checked>
				<lable for="gender">남</lable>
				<input id="gender" name="gender" type="radio" value="f">
				<lable for="gender">여</lable>
			</fieldset>
		</dd>
		<dd>
			<lable for="hobby"> 취미 </lable>
			<select id="hobby" name="hobby" required>
				<option value="잠자기" selected> 잠자기
				<option value="무협지보기"> 무협지보기
				<option value="애니메이션시청"> 애니메이션시청
				<option value="건프라"> 건프라
			</select>
		</dd>
		
		<dd>
			<input type="submit" value="전송">
		</dd>
		
	</dl>

</form>