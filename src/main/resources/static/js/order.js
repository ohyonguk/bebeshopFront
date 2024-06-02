function sample6_execDaumPostcode() {
    new daum.Postcode(
        {
            oncomplete : function(data) {

                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                document.getElementById('zipcode').value = data.zonecode;
                document.getElementById("addrDetail").value = addr;

                document.getElementById("addrDetail2")
                    .focus();
            }
        }).open();
}


//아임포트
function iamport(){
    console.log("아임포트 함수 시작");
    var IMP = window.IMP;
    IMP.init('imp46949506');
    IMP.request_pay({
        pg : 'kcp',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '${opn}' + '외' +' ${oc}'+'개' , //결제창에서 보여질 이름
        amount : 100 ,
        buyer_name  : '${sessionUser.id}'
    }, function(rsp) {
        console.log(rsp);
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;

            alert("결제 성공");
            //TODO 주문정보 관련
            var orderList = {};

            var param = {
                totalPrice : $("#totalPrc").val(),
                zipCode: $("#zipcode").val(),

                receiver: $("#addrReceiver").val(),
                addrReq:$("[name=addrRequest]").val()

            }

            $.ajax({
                cache : false,
                url : "/order/payment", // 요기에
                type : 'POST',
                data : formData,
                success : function(data) {
                    alert("데이터 전송 성공")
                    location.replace('/order/order_sc');
                }, // success

                error : function(xhr, status) {
                    alert(xhr + " : " + status);
                }// $.ajax */
            });

        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
    });
}