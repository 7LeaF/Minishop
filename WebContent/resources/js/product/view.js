//상품 수량 증가 버튼
function QntyUp() {
	var qnt= parseInt($("#productQnty").val());
	qnt+= 1;
	$("#productQnty").val(qnt);
	UpdateTtlProductAmount();
}

//상품 수량 감소 버튼
function QntyDown() {
	var qnt= parseInt($("#productQnty").val());
	if (qnt<=1) return;
	qnt-= 1;
	$("#productQnty").val(qnt);
	UpdateTtlProductAmount();
	
}

//총금액 계산, 총 결제금액 계산 추가
function UpdateTtlProductAmount() {
	
    var salesPrice = $.toInt($("#salesPrice").text()); // 유료회원가/일반회원가 추가
    var $prodTtlPayAmt = $("#prodTtlPayAmt");       // 총 결제금액 추가
    var qnt = $("#productQnty").toInt();	//제품 수량
    var prodTtlPayAmt = qnt * salesPrice;
    
    $prodTtlPayAmt.text($.format.number(prodTtlPayAmt, "#,###") + "원");
}

/*function NumberWithComma(numElement){
	alert(numElement.html);
}*/