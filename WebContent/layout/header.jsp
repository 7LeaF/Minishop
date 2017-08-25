<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<c:set var="project" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="${project}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${project}/resources/css/animate.css">
<link rel="stylesheet" href="${project}/resources/css/custom.css">
<script src="${project}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${project}/resources/js/bootstrap.min.js"></script>

<!-- <h1> Header </h1> -->

<div class="container">
   <header>
     <div class="row">
       <div class="col-md-4 col-sm-12">
       	<a href="${project}/main.do">
         <!-- <h1 class="logo"><i class="glyphicon glyphicon-tag"></i> Mini Shop</h1> -->
         <img src="${pageContext.request.contextPath}/resources/images/Minishop-logo-resize.png" width="200" height="67">
        </a>
         <p class="subtext">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>1조 미니 프로젝트 : 소규모 쇼핑몰</small></p>
       </div>
       
       <div class="col-md-8 col-sm-12 top-right">
       
       <c:choose>
       	<c:when test="${sessionScope.userId== 'admin'}">
	       <a href="${project}/user/user_modify.jsp">회원관리</a>
	        &nbsp;|&nbsp;
	       <a href="LogoutAction.do">로그아웃</a>
	       	&nbsp;|&nbsp;
	       <a href="${project}/admin/admin_main.jsp">관리자</a>
	       <br>${sessionScope.userId }님 반갑습니다.
       	</c:when>
       	<c:when test="${!empty sessionScope.userId}">
	       <a href="${project}/user/user_modify.jsp">회원관리</a>
	        &nbsp;|&nbsp;
	       <a href="LogoutAction.do">로그아웃</a>
	       <br>${sessionScope.userId }님 반갑습니다.
       	</c:when>
       	<c:otherwise>
       	   <a href="${project}/user/login.jsp">로그인</a>
	       	&nbsp;|&nbsp;
	       <a href="${project}/user/join.jsp">회원가입</a>
       	</c:otherwise>
       </c:choose>
       
       </div>
       
     </div>
   </header>
   
<!-- Static navbar -->

   <nav class="navbar navbar-default">
     <div class="container-fluid">
       <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
         </button>
       </div>
       <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
           <c:choose>
           <c:when test="${sessionScope.userId== 'admin' && pageContext.request.servletPath== '/admin/admin_main.jsp'}">
	           <li><a href="${project}/board/NoticeList.do"><p style="color:SlateBlue;">공지사항</p></a></li>
	           <li><a href="${project}/admin/product_manage.jsp"><p style="color:SlateBlue;">상품관리</p></a></li>
	           <li><a href="${project}/admin/order_manage.jsp"><p style="color:SlateBlue;">주문관리</p></a></li>
	           <li><a href="${project}/admin/user_manage.jsp"><p style="color:SlateBlue;">회원관리</p></a></li>
	           <li><a href="${project}/board/qna_board.jsp"><p style="color:SlateBlue;">Q&A 게시판</p></a></li>
           </c:when>
           <c:otherwise>
	           <li><a href="${project}/board/NoticeList.do">공지사항</a></li>
	           <li><a href="${project}/product/product_list.jsp">카테고리</a></li>
	           <li><a href="${project}/user/order_check.jsp">주문조회</a></li>
	           <li><a href="${project}/user/cart.jsp">장바구니</a></li>
	           <li><a href="${project}/board/qna_board.jsp">Q&A 게시판</a></li>
           </c:otherwise>
           </c:choose>
         </ul>
         <ul class="nav navbar-nav navbar-right">
          <form class="navbar-form" action="${project}/product/product_search.jsp">
           <div class="form-group">
             <input type="text" class="form-control" placeholder="Search...">
           </div>
           <button type="submit" class="btn btn-default">Search</button>
          </form>
         </ul>
       </div><!--/.nav-collapse -->
     </div><!--/.container-fluid -->
   </nav>
   
</div> <!-- end of container -->
