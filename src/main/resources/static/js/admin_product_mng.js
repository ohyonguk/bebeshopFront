
setSelect(); 


function itemChange(){
 var changeItem = ["용품","의류","사료","간식"];  
 var selectItem = $("#mainCategory").val();
 
  $('#subCategory').empty();

  
 if(selectItem == "1" || selectItem == "2"){
	  var option = $("<option value=''>분류 선택</option>");
  	$('#subCategory').append(option);
 		for(var count = 0; count < 2; count++){  
 		 	var option = $("<option value='"+selectItem+"0"+(count+1)+"'>"+changeItem[count]+"</option>");
 			$('#subCategory').append(option);
 		}   
 }
 else if(selectItem == "3") {
    var option = $("<option value='301' selected disable>"+changeItem[selectItem-1]+"</option>");
    $('#subCategory').append(option);
 }
 else{
     var option = $("<option value='401' selected disable>"+changeItem[selectItem-1]+"</option>");
    $('#subCategory').append(option);
 }  
  }


$('#delbtn').click(function() {
	
/*	var proNo = new Array();
        var obj_length = document.getElementsByName("checkproductno").length;
  
        for (var i=0; i<obj_length; i++) {
            if (document.getElementsByName("checkproductno")[i].checked == true) {
                proNo[i] = document.getElementsByName("checkproductno")[i].value;
				console.log(proNo[i]);
            }
        }*/

/*	var frm = document.createElement('form');	
	frm.setAttribute('method','post');
	frm.setAttribute('action',"/admin/deleteProduct")
	document.charset = "utf-8";
	var hiddenField = document.createElement('input');
	hiddenField.setAttribute('checkproductno',)*/
	
	
/*	jQuery.ajaxSettings.traditional = true;
	$.ajax({
    url: "/admin/deleteProduct",
    type: 'post',
    data: {"checkproductno": proNo},
    success: function (data) {
            alert("데이터 전송이 성공적으로 끝났을 때 실행");
        }
});*/
   var frm = document.formproduct;
		frm.action = "/admin/deleteProduct";
		frm.method = "post";
		frm.submit();
 });


function setSelect(){
	var main = "";
	var sub = "";
	if($('#mainCategoryval').val() != null){
		main = $('#mainCategoryval').val();
	}
	if($('#subCategoryval').val() != null){
		sub = $('#subCategoryval').val();
	}

$('#mainCategory').val(main);

itemChange();

$('#subCategory').val(sub);

	if($('#searchWordval').val() != null){
		$('#searchWord').val($('#searchWordval').val());
	}
}

/*$('#search').click(function() {
 
            // json 형식으로 데이터 set
            var params = {
                      mainCategory      : $("#mainCategory").val()
                    , subCategory       : $("#subCategory").val()
                    , searchWord       : $("#searchWord").val()
            }
                
            // ajax 통신
            $.ajax({
                type : "POST",            // HTTP method type(GET, POST) 형식이다.
                url : "/admin/searchproduct",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
   				 alert("통신성공")
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        });
*/