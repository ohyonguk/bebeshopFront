package bebeshop.bebeshopapi.RestService;

import bebeshop.bebeshopapi.dto.MemberRequestDto;
import bebeshop.bebeshopapi.dto.MemberResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginRestService {
    static String route = "http://localhost:8080/api/user";

    public MemberResponseDto login(MemberRequestDto memberRequestDto) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<MemberResponseDto> member = rt.postForEntity(route + "/login", memberRequestDto, MemberResponseDto.class);

        return member.getBody();
    }

}
