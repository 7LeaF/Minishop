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

<h1> 관리자 주문 관리 페이지 order_manage.jsp</h1>

<c:forEach var="order" items="${order}">

<a href="ProductView.do?product_Code=${order.productCodePk}">
<img src="${project}/resources/images/${order.productImage1}"></a>
상품명 : ${order.productName}<br>
상품코드 : ${order.productCodePk}<br>
상품상세설명 : ${order.productMessage}<br>
상품가 : ${order.productSale}<br>
상품수량 : ${order.orderAmount}<br>

구매자 이름:${order.buyerName}<br>
구매자 주소:${order.buyerAddress1}<br>
${order.buyerAddress2}<br>
구매자 이메일 : ${order.buyerEmail}<br>
구매자 전화번호:${order.buyerPhone}<br>
<br>

배송지 수취인:${order.rcptName}<br>
배송지 주소:${order.rcptAddress1}<br>
${order.rcptAddress2}<br>
배송지 전화번호:${order.rcptPhone}<br>
배송시 메세지:${order.rcptMessage}<br>

배송상태 코드:${order.orderState}<br>

<c:choose>
<c:when test="${order.orderState == 0}"><br>
	주문 확인중
</c:when>
<c:when test="${order.orderState == 1}"><br>
	배송 준비중
</c:when>
<c:when test="${order.orderState == 2}"><br>
	현재 배송중
</c:when>
<c:when test="${order.orderState == 3}"><br>
	배송 완료됨
</c:when>
</c:choose>

</c:forEach>



</body>
</html>