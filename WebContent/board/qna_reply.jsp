<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mini Shop</title>
</head>
<body>

<jsp:include page="/layout/header.jsp" />

<div class="container">
	<div class="row">
	<form method="post" action="QnaReplyAction.do?qnaIdx=${requestScope.vo.qnaIdx}">
	
		<input type="hidden" name="qnaGroup" value="${requestScope.vo.qnaGroup}">
		<input type="hidden" name="qnaStep" value="${requestScope.vo.qnaStep}">
		<input type="hidden" name="qnaIndent" value="${requestScope.vo.qnaIndent}">
		
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #eeeeee; text-align: center;">문의 게시판 답변</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="qnaTitle" maxlength="50" value="RE: ${requestScope.vo.qnaTitle}"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="qnaContent" maxlength="2048" style="height: 350px;">${requestScope.vo.qnaContent}</textarea></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-primary pull-right" value="답글달기"  onclick="return confirm('정말로 답변글을 등록 하시겠습니까?')">
	</form>
	</div>
</div>

</body>
</html>