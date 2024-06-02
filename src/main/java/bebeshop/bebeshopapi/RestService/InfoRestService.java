package bebeshop.bebeshopapi.RestService;

import bebeshop.bebeshopapi.dto.MemberResponseDto;
import bebeshop.bebeshopapi.dto.OrderRequestDto;
import bebeshop.bebeshopapi.dto.OrderResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class InfoRestService {
    static String route = "http://localhost:8080/api/order";
    public ResponseEntity<List> findOrderList(String id) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<List> order = rt.postForEntity(route + "/findOrderList", id, List.class);
        return order;
    }
}
