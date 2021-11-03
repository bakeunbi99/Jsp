<%@page import="kr.co.farmstory2.bean.MemberBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String uri = request.getRequestURI();
	String uid = request.getParameter("uid");

	int start = uri.lastIndexOf("/")+1;
	int end   = uri.lastIndexOf(".");
	
	String cate = uri.substring(start, end);
	
	String cate2 = request.getParameter("cate");
	
	String group = request.getParameter("group");
	String includeFile = "./_aside"+group+".jsp";
	
	
%>


<%@ include file="../_header.jsp" %>

<jsp:include page="<%= includeFile %>">
	<jsp:param name="cate1" value="<%= cate %>"/>
</jsp:include>


<section id="board" class="write">
	
    <h3>글쓰기</h3>
    <article>
        <form action="/Farmstory2/board/proc/writeProc.jsp?cate=<%= cate2 %>" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="cate2" value="<%= cate2 %>"/>
        	<input type="hidden" name="uid" value="<%= mb.getUid() %>"/>
        	<input type="hidden" name="uri" value="<%= uri %>"/>
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content"></textarea>                                
                    </td>
                </tr>
                <tr>
                    <td>첨부</td>
                    <td><input type="file" name="fname"/></td>
                </tr>
            </table>
            <div>
                <a href="/Farmstory2/board/proc/writeProc.jsp?cate=<%= cate2 %>" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="작성완료">
            </div>
        </form>
    </article>
</section>

<%@ include file="../_footer.jsp" %>


