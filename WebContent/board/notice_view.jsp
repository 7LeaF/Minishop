<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">공지사항 게시판</th>
					</tr>
				</thead>
				<tbody>

					<c:set var="vo" value="${requestScope.vo}" />
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2">${vo.noticeTitle}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${vo.noticeWriter}</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">${fn:substring(vo.noticeDate,0,11)} ${fn:substring(vo.noticeDate,11,13)}시 ${fn:substring(vo.noticeDate,14,16)}분</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left; ">${vo.noticeContent}</td>
						<%-- <td colspan="2" style="min-height: 200px; text-align: left; "><%= content.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td> --%>
					</tr>
				</tbody>
			</table>
			<a href="NoticeList.do" class="btn btn-primary">목록</a>
			<%-- ${vo.noticeWriter } : ${sessionScope.userId} --%> <!-- userId != null && userId.equals(vo.getNoticeWriter()) -->
			<c:if test="${sessionScope.userId!= null && sessionScope.userId== vo.noticeWriter }">
					<a href="NoticeUpdateView.do?noticeIdx=${vo.noticeIdx}" class="btn btn-primary">수정</a>
					<a href="NoticeDeleteAction.do?noticeIdx=${vo.noticeIdx}" class="btn btn-primary" onclick="return confirm('정말로 삭제 하시겠습니까?')">삭제</a>
			</c:if>
	</div>
</div>

</body>
</html>