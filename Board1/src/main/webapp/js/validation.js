/**
 * 회원가인 validation 체크
   Validation( 유효성 검증, 검사 )
 */

// Validation(유효성 검증)
		$(document).ready(function(){
			
			//폼 전송이 시작 되기 전에 실행되는 이벤트
			$('.register > form').submit(function(){
				//alert('폼 전송 전');
				
				if(!isUidOk){ //아이디가 유효하지 않는다면
					alert('아이디가 유효하지 않습니다. 다시 입력하세요.');
					
					return false; // 전송취소	
				}
											
				if(!isPassOk){ //비밀번호가 유효하지 않는다면
					alert('비밀번호 유효하지 않습니다. 다시 입력하세요.');
					
					return false; // 전송취소	
				}
				
				if(!isNameOk){ //이름이 유효하지 않는다면
					alert('이름이 유효하지 않습니다. 다시 입력하세요.');
					
					return false; // 전송취소	
				}
				
				if(!isNickOk){ //닉네임이 유효하지 않는다면
					alert('닉네임이 유효하지 않습니다. 다시 입력하세요.');
					
					return false; // 전송취소	
				}
				
				return true; // 서버에 전송 시작	
			});
		});