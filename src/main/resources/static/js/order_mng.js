
function itemChange(){
 var changeItem = ["배송준비","배송중","배송완료"];  
 var changeItem2 = ["취소대기","취소완료"];  
 var selectItem = $("#category").val();
 
  $('#subcategory').empty();
  
 if(selectItem == "1"){
	 var option = $("<option value=''>분류 선택</option>");
  	$('#subcategory').append(option);
 		for(var count = 0; count < changeItem.length; count++){  
 		 	var option = $("<option value='"+changeItem[count]+"'>"+changeItem[count]+"</option>");
 			$('#subcategory').append(option);
 		}   
	$('#searchWord').attr("disabled", true);
 }

 else if(selectItem == "2"){
	 var option = $("<option value=''>분류 선택</option>");
  	$('#subcategory').append(option);
 		for(var count = 0; count < changeItem2.length; count++){  
 		 	var option = $("<option value='"+changeItem2[count]+"'>"+changeItem2[count]+"</option>");
 			$('#subcategory').append(option);
 		}   
	$('#searchWord').attr("disabled", true);
 }

 else if(selectItem == "3") {
    var option = $("<option value='3' selected disable>아이디</option>");
    $('#subcategory').append(option);
$('#searchWord').attr("disabled", false);
 }
 else{
     var option = $("<option value='4' selected disable>주문번호</option>");
    $('#subcategory').append(option);
$('#searchWord').attr("disabled", false);
 }  
 }



/*function checksts(){
	if($('#stsCancel').val() == $('#stsCancelSel').val() && $('#stsDeliverySel').val() == $('#stsDelivery').val()){
		alert("변동 사항이 없습니다");
		return false;
	}
	return true;
}*/