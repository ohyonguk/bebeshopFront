// $('.sizebtn>input').click(function() {
//     var i = $(this).css('border') == 'none';
//     if ($(this).css('border') == 'none') {
//         $(this).css({ 'border': '2px solid black' })
//     } else {
//         $(this).css({ 'border': 'none' })
//     }
// })

    
/*function previewImage(targetObj, View_area) {
    var preview = document.getElementById(View_area); //div id
    var ua = window.navigator.userAgent;

    var files = targetObj.files;
    for (var i = 0; i < files.length; i++) {
        var file = files[i];
        var imageType = /image.*; //이미지 파일일경우만.. 뿌려준다.
        if (!file.type.match(imageType))
            continue;
        var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
        if (prevImg) {
            preview.removeChild(prevImg);
        }
        var img = document.createElement("img");
        img.id = "prev_" + View_area;
        img.classList.add("obj");
        img.file = file;
        img.style.width = '160px';
        img.style.height = '160px';
        preview.appendChild(img);
        if (window.FileReader) { // FireFox, Chrome, Opera 확인.
            var reader = new FileReader();
            reader.onloadend = (function(aImg) {
                return function(e) {
                    aImg.src = e.target.result;
                };
            })(img);
            reader.readAsDataURL(file);
        } else { // safari is not supported FileReader
            //alert('not supported FileReader');
            if (!document.getElementById("sfr_preview_error_" +
                    View_area)) {
                var info = document.createElement("p");
                info.id = "sfr_preview_error_" + View_area;
                info.innerHTML = "not supported FileReader";
                preview.insertBefore(info, null);
            }
        }
    }
}*/

/*  $("#imgfile").change(function(){
	alert("함수탑승")
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $("#img1 img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });*/

function itemChange(){
 var changeItem = ["용품","의류","사료","간식"];  
 var selectItem = $("#category").val();
 
  $('#subcategory').empty();

  
 if(selectItem == "1" || selectItem == "2"){
	  var option = $("<option value=''>분류 선택</option>");
 	 $('#subcategory').append(option);
 		for(var count = 0; count < 2; count++){  
 		 	var option = $("<option value='"+selectItem+(count+1)+"'>"+changeItem[count]+"</option>");
 			$('#subcategory').append(option);
 		}   
 }
 else if(selectItem == "3") {
    var option = $("<option value='3' selected disable>"+changeItem[selectItem-1]+"</option>");
    $('#subcategory').append(option);
 }
 else{
     var option = $("<option value='4' selected disable>"+changeItem[selectItem-1]+"</option>");
    $('#subcategory').append(option);
 }
  
}


$(".imgfile").change(function(){
    var index = $(".imgfile").index(this) + 1;
    if(this.files && this.files[0]) {
        var reader = new FileReader;
        reader.onload = function(data) {
            $('#img'+index+' img').attr("src", data.target.result).width(150);
        }
        reader.readAsDataURL(this.files[0]);
    }
});
function addProduct() {
    const formData = new FormData();

    var param = {
        categoryNo : $("#subcategory option:selected").val(),
        productName : $("[name=productName]").val(),
        productCnt : $("[name=productStock]").val(),
        productPrice : $("[name=productPrice]").val(),
    }
    var inputFile = $("input[name='file']");
    var files = inputFile[0].files;
    for(var i=0; i<files.length;i++){
        formData.append("img",files[i]);
    }
    formData.append("jsonxx",new Blob([JSON.stringify(param)],{type:"application/json"}));
    console.log(param);
    $.ajax({
        url: '/admin/addProduct',
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            alert("장바구니에 상품이 담겼습니다.");
        },
        error: function (request, status, error) {
            alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    })
}
  
  
  