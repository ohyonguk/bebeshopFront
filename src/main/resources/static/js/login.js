function login(){
    var param ={
        "id" : $("[name=id]").val(),
        "password" : $("[name=passwd]").val(),
        "idSave" : $("[name=saveId]").is(":checked")
    }

    $.ajax({
        url : "/login/user",
        type : 'POST',
        contentType: 'application/json',
        data : JSON.stringify(param),
        async : false,
        success : function(res) {
            if(res===1){
                window.location.href= "/index";
            }
        }, // success
        error : function(res) {
            alert("id 혹은 비밀번호가 틀렸습니다.");
        },
    });
}

function onSignIn(googleUser) {

    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId());
    var email = profile.getEmail();
    $('#id').val(email);
    console.log("Email: " + email);

    var frm = document.socialLogin;
    frm.action = "/login/socailLogin";
    frm.method = "get";
    frm.submit();
}
/*

//카카오로그인
function kakaoLogin(){
    window.Kakao.init("f0e088ffc8de3aeaca97aa4221edcafb");
    window.Kakao.Auth.login({
        scope: 'profile_nickname, account_email',
        success: function(authObj){
            console.log(authObj);
            window.Kakao.API.request({
                url:'/v2/user/me',
                success: res=>{
                    const kakao_account = res.kakao_account;
                    var email = kakao_account.email;
                    console.log("email : "+email);
                    $('#id').val(email);
                    console.log($('#id').val());
                    var frm = document.socialLogin;
                    frm.action = "/login/socailLogin";
                    frm.method = "get";
                    frm.submit();
                }
            });
        }
    });
}

//네이버로그인

var naver_id_login = new naver_id_login("ifOs8Sf6tF3Y_TBfc808", "http://bebeshop.iptime.org:8080/login/naverCallback");

var state = naver_id_login.getUniqState();
naver_id_login.setButton("green", 1, 25);
naver_id_login.setDomain("http://bebeshop.iptime.org:8080/login/login");

naver_id_login.setState(state);
//naver_id_login.setPopup();
naver_id_login.init_naver_id_login();*/
