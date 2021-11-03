<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <section id="board" class="view">
            <h3>글보기</h3>
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="${vo.title}" readonly/></td>
                </tr>
                <c:if test="${vo.file == 1}"></c:if>
                <tr>
                    <td>첨부파일</td>
                    <td>
                        <a href="/Jboard2/fileDownload.do?fseq=${vo.fb.fseq}">${vo.fb.oriName}</a>
                        <span>${vo.fb.download}회 다운로드</span>
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content" readonly>${vo.content}</textarea>
                    </td>
                </tr>
            </table>
            <div>
                <a href="#" class="btnDelete">삭제</a>
                <a href="/Jboard2/modify.do" class="btnModify">수정</a>
                <a href="/Jboard2/list.do" class="btnList">목록</a>
            </div>  
            
            <!-- 댓글리스트 -->
            <section class="commentList">
                <h3>댓글목록</h3>
                <c:forEach var="comment" items="${comments }">
	                <article class="comment">
	                    <span>
	                        <span>${comment.nick}</span>
	                        <span>${comment.rdate}</span>
	                    </span>
	                    <textarea name="comment" readonly>${comment.content }</textarea>
	                    <div>
	                        <a href="#">삭제</a>
	                        <a href="#">수정</a>
	                    </div>
	                </article>
                </c:forEach>
                
                <%-- <c:if test="${comments.size() ==0 }"> size도 가능, <c:if test="${vo.comment == 0 }"> --%>
                <c:if test="${comments.size() == 0 }">
	                <p class="empty">
	                    등록된 댓글이 없습니다.
	                </p>
                </c:if>
            </section>


            <!-- 댓글입력폼 -->
            <section class="commentForm">
                <h3>댓글쓰기</h3>
                <form action="/Jboard2/comment.do" method="post">
                	<input type="text" name="parent" value="${vo.seq} ">
                	<input type="text" name="uid" value="${sessMember.uid} ">
                	
                    <textarea name="content"></textarea>
                    <div>
                        <a href="#" class="btnCancel">취소</a>
                        <input type="submit" class="btnWrite" value="작성완료"/>
                    </div>
                </form>
            </section>


        </section>
    </div>
</body>
</html>

