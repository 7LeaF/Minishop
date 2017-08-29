<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mini Shop</title>
<!-- <script>
	$(document).ready(function(){
	$("#mytable #checkall").click(function () {
	        if ($("#mytable #checkall").is(':checked')) {
	            $("#mytable input[type=checkbox]").each(function () {
	                $(this).prop("checked", true);
	            });
	
	        } else {
	            $("#mytable input[type=checkbox]").each(function () {
	                $(this).prop("checked", false);
	            });
	        }
	    });
	    
	    $("[data-toggle=tooltip]").tooltip();
	});
</script> -->
</head>
<body>

<jsp:include page="/layout/header.jsp" />

<div class="container">
<p style="padding-left:10px;"><a href="main.do">홈</a> > <a href="ProductManageView.do">상품관리</a></p>
		
		<div class="page-header">
			  <h3 style="text-align: center;">상품 관리 페이지</h3>
		</div>
		
        <form class="form-horizontal" action="${pageContext.request.contextPath}/product/product_add.jsp">

			<div class="form-group">
				<label class="control-label col-md-2" for="category">카테고리: </label>
				<div class="col-md-6">
				<select class="form-control" id="category" name ="ctgryName">
					<option>0001</option>
					<option>0002</option>
					<option>0003</option>
					<option>0004</option>
				</select>
				</div>

				<div class="col-md-4">
					<input type="submit" class="btn btn-primary" value="상품등록">
				</div>
			</div>
		
		</form>
        
       <br>
        
       <div class="row">
       <div class="col-md-offset-1 col-md-10">
       <div class="table-responsive">
             
           <table id="mytable" class="table table-bordred">
                  
			<thead>
				<th style= "width: 5%; text-align: center;"><input type="checkbox" id="checkall" /></th>
				<th style= "width: 20%; text-align: center;">상품 사진</th>
				<th style= "width: 65%; text-align: center;">상품 설명</th>

				<th style= "width: 5%; text-align: center;">수정</th>
				<th style= "width: 5%; text-align: center;">제거</th>
			</thead>
  				
  			<tbody>
  				<c:forEach items="${list}" var="list">
			    <tr>
			    <td style= "text-align: center;"><input type="checkbox" class="checkthis" /></td>
			    <td style= "text-align: center;"><img class="product-image" src="${pageContext.request.contextPath}/resources/images/products/${list.productImage1}"></td>
			    <td>상품 이름 : ${list.productName}<br>상품 설명 : ${list.productMessage}<br><br></td>

			    <td style= "text-align: center;"><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
			    <td style= "text-align: center;"><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
			    </tr>
   				</c:forEach>
   			</tbody>
		</table>
	</div>
	</div>
	</div>
</div>
</body>
</html>