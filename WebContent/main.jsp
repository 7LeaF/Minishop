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

<%-- 절대경로 생성을 위한 현재 프로젝트 Context 명 저장 --%>
<c:set var="project" value="${pageContext.request.contextPath}"/>


<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
	<!-- 			<li data-target="#myCarousel" data-slide-to="2"></li> -->
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="${project}/resources/images/bigsale1.jpg">
			</div>
			<div class="item">
				<img src="${project}/resources/images/openevent1.jpg">
			</div>
	<!-- 			<div class="item">
					<img src="resources/images/1.jpg">
				</div> -->
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>


    <div class="row">
          <div class="col-xs-6 col-sm-4">
            <div class="thumbnail">
                <img class="img-responsive" src="${project}/resources/images/product_diva1.jpg" alt="송하나 인형">
                <div class="add-to-cart">
                      <a href="#" class="glyphicon glyphicon-shopping-cart pull-right" data-toggle="tooltip" data-placement="top" title="Add to cart"></a>
                </div>

                <div class="caption">
                  <h4 class="pull-right">&#8361;15,000</h4>
                  <h4><a href="product/product_detail.jsp">송하나 인형</a></h4>
                  <div class="ratings">
                      <p class="pull-right"><a href="#">25 reviews</a></p>
                      <p><span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span></p>
                  </div>
                </div>
            </div>
          </div>

          <div class="col-xs-6 col-sm-4">
            <div class="thumbnail">
                <img class="img-responsive" src="${project}/resources/images/product_ant1.jpg" alt="개미 인형">
                <div class="add-to-cart">
                      <a href="#" class="glyphicon glyphicon-shopping-cart pull-right" data-toggle="tooltip" data-placement="top" title="Add to cart"></a>
                </div>

                <div class="caption">
                  <h4 class="pull-right">&#8361;17,000</h4>
                  <h4><a href="product/product_detail.jsp">개미 인형</a></h4>
                  <div class="ratings">
                      <p class="pull-right"><a href="#">2 reviews</a></p>
                      <p><span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span></p>
                  </div>
                </div>
            </div>
          </div>

          <div class="col-xs-6 col-sm-4">
            <div class="thumbnail">
                <img class="img-responsive" src="${project}/resources/images/product_bear1.jpg" alt="곰 인형">
                <div class="add-to-cart">
                      <a href="#" class="glyphicon glyphicon-shopping-cart pull-right" data-toggle="tooltip" data-placement="top" title="Add to cart"></a>
                </div>

                <div class="caption">
                  <h4 class="pull-right">&#8361;22,000</h4>
                  <h4><a href="product/product_detail.jsp">곰 인형</a></h4>
                  <div class="ratings">
                      <p class="pull-right"><a href="#">3 reviews</a></p>
                      <p><span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span></p>
                  </div>
                </div>
            </div>
          </div>
      </div> <!-- close div row -->
</div>

</body>
</html>