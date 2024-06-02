package bebeshop.bebeshopapi.service;


import bebeshop.bebeshopapi.RestService.LoginRestService;
import bebeshop.bebeshopapi.dto.MemberRequestDto;
import bebeshop.bebeshopapi.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRestService loginRestService;
    public MemberResponseDto login(MemberRequestDto memberRequestDto) {
        return loginRestService.login(memberRequestDto);
    }
}
