<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<c:set var="project" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mini Shop</title>
</head>
<body>

<jsp:include page="/layout/header.jsp" />

<div class="container">
<p style="padding-left:10px;"><a href="main.do">홈</a> > <a href="OrderCheckView.do">조회하기</a></p>

		  <h3 style="text-align: center;">주문 조회</h3>
		  <br>
	
	<div class="row">
	
       <div class="col-md-offset-1 col-md-10">
       <div class="table-responsive">
             
           <table id="mytable" class="table table-custom">
                  
			<thead>
				<th style= "width: 10%;">주문 번호</th>
				<th style= "width: 10%;">상품 사진</th>
				<th style= "width: 50%;">주문 정보</th>
				<th style= "width: 30%;">주문 상태</th>
			</thead>
  			
  			<tbody>
  			<c:forEach var="vo" items="${requestScope.voList}">	
			    <tr>
			    <td>${vo.orderCode}</td>
			    <td><img class="product-image" src="${project}/resources/images/products/${vo.productImage1}"></td>
			    <td style="text-align: left; padding-left: 30px;">상품 이름 : ${vo.productName}<br>결제 금액 : ${vo.orderAmount}<br>${vo.orderDate}</td>
			    <td>
					<c:choose>
					<c:when test="${vo.orderState == 0}">
						주문 확인중
					</c:when>
					<c:when test="${vo.orderState == 1}">
						배송 준비중
					</c:when>
					<c:when test="${vo.orderState == 2}">
						현재 배송중
					</c:when>
					<c:when test="${vo.orderState == 3}">
						배송 완료됨
					</c:when>
					</c:choose>
				</td>
			    </tr>
			</c:forEach>
   			</tbody>
		</table>
	</div>
	</div>
	
	</div> <!-- div row end -->
</div> <!-- div container end -->

</body>
</html>