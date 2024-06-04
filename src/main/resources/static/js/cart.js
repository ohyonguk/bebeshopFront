$('#allCheck').change(() => {
	if ($('#allCheck').prop('checked')) {
		$('input[name="RowCheck"]').prop('checked', true);
		$('input[name="checked"]').val("true");
	} else {
		$('input[name="RowCheck"]').prop('checked', false);
		$('input[name="checked"]').val("false");
	}
});


$(".RowCheck").click(function () {

	console.log($(".RowCheck").index(this));

	$("#allCheck").prop("checked", false);

	if ($(this).prop('checked')) {
		$(".checked").eq($(".RowCheck").index(this)).val("true");
	} else {
		$(".checked").eq($(".RowCheck").index(this)).val("false");
	}
});

function addCart() {
	if($("#userId").val()===undefined){
		alert("로그인 후 가능합니다.");
	}else{
		var param = {
			productNo : $("#productNo").val(),
			count : $("#quantity").val()
		}

		$.ajax({
			url: '/user/cart/insertCart',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(param),
			success: function (data) {
				alert("장바구니에 상품이 담겼습니다.");
			},
			error: function (request, status, error) {
				alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			}
		})
	}
}
function addCartAndOrder() {
	if($("#userId").val()===undefined){
		alert("로그인 후 가능합니다.");
	}else{
		var param = {
			productNo : $("#productNo").val(),
			count : $("#quantity").val(),
			btn: "order"
		}

		$.ajax({
			url: '/user/cart/addCartAndOrder',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(param),
			success: function (data) {
				location.href = "/order/goOrder/" +data
			},
			error: function (request, status, error) {
				alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			}
		})
	}
}


var qty = parseInt($('#quantity').val());
console.log(qty);
function selDelete(){
	var cnt = $("input[name='RowCheck']:checked").length;
	if(cnt == 0){
		alert("선택된 상품이 없습니다.");
	}else{
		var productNoList = new Array();
		$('[name = RowCheck]:checked').each(function (index){
			productNoList.push($(this).val());
		})
		var param = {
			productNoList:productNoList
		}

		$.ajax({
			url : "/user/cart/deleteList",
			type : 'POST',
			contentType: 'application/json',
			data : JSON.stringify(param),
			async : false,
			success : function(res) {
				alert("삭제 성공");
				location.reload(true);
			}, // success
			error : function(request) {
				alert("삭제 실패");
			},
		});
	}
}

function selOrder(){
	var cartNoList = new Array();
	cartNoList.push(1);
	cartNoList.push(2);
	location.href = "/order/goOrder/"+cartNoList;

}

function checkStock(){

	var productNoList = new Array();
	$('[name = RowCheck]:checked').each(function (index){
		productNoList.push($(this).val());
	})
	var param = {
		productList: [{
			productNo: 1,
			productCnt : 10
		}]


	}

	$.ajax({
		url : "/order/checkStock",
		type : 'POST',
		contentType: 'application/json',
		data : JSON.stringify(param),
		async : false,
		success : function(res) {
			console.log(res);
			if(res){
				selOrder();
			}else{
				alert(decodeURIComponent(data) + " 상품의 재고가 없습니다");
			}
		}, // success

		error : function(xhr, status) {
			alert("전송실패");
		}// $.ajax
	});
}
