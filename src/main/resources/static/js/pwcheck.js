$.validator.addMethod("regex", function(value, element, regexp) {
	let re = new RegExp(regexp);
	let res = re.test(value);
	console.log(res, value, regexp, re);
	return res;
});

$(function() {
	$(".form").validate({
		rules: {
			passwd: {
				required: true,
				regex: "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$",
				minlength: 8
			},
			newpwch: {
				required: true,
				equalTo: "#newpw",
			},
		},

		messages: {
			passwd: {
				required: "비밀번호는 필수 입력입니다.",
				minlength: "최소 8자리 이상 입력해주세요",
				regex: "비밀번호에 문자/숫자/특수문자를 포함해주세요",
			},
			newpwch: {
				required: "비밀번호를 확인하세요",
				equalTo: "비밀번호가 틀립니다",
			},
		},

		errorElement: "p",
		errorClass: "error",
		validClass: "vaild",
		submitHandler: function(form) {

			/*			alert($("#nowpw").val());
						alert($("#passwd").val());*/
			if ($("#nowpw").val() != $("#passwd").val()) {
				alert("현재 비밀번호가 일치하지 않습니다.");
				return;
			}

			else if ($("#nowpw").val() == $("#newpw").val()) {
				alert("현재 비밀번호와 동일합니다.");
				return;
			}

			else {
				form.submit();
				alert("변경 완료");
			}
		},
	});
});
