package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.MemberRequestDto;
import bebeshop.bebeshopapi.dto.MemberResponseDto;
import bebeshop.bebeshopapi.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/user/login")
    public String loginPage(){
        return "login/login";
    }

    @PostMapping("/login/user")
    @ResponseBody
    public int loginUser(@RequestBody MemberRequestDto memberRequestDto, HttpSession session,
                            HttpServletRequest req, HttpServletResponse response){
        try{
            MemberResponseDto memberResponseDto = loginService.login(memberRequestDto);
            //쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
            session.setAttribute("selectUsers", 1);
            session.setAttribute("sessionUser", memberRequestDto.getId());
            session.setAttribute("sessionUserEmail", memberResponseDto.getEmailId());
            if(memberRequestDto.getIdSave()){
                Cookie c = new Cookie("saveId",memberRequestDto.getId());
                //쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
                c.setMaxAge(60*60*24*7); //7일간 저장
                response.addCookie(c);
            }

        }catch(Exception e){
            throw new IllegalStateException(e.getMessage());
        }
        return 1;
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
