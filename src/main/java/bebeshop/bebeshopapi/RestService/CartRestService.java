package bebeshop.bebeshopapi.RestService;

import bebeshop.bebeshopapi.dto.ApiResponse;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class CartRestService {
    static String route = "http://localhost:8080/api/cart";

    public ResponseEntity<List> findCart(CartRequestDto cartRequestDto){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<List> res = rt.postForEntity(route+"/findCart",cartRequestDto, List.class);
        log.info("{}", res);
        return res;

    }

    public void deleteCartList(CartRequestDto cartRequestDto) {
        RestTemplate rt = new RestTemplate();
        rt.postForEntity(route+"/deleteList",cartRequestDto, void.class);

    }

    public void insertCart(CartRequestDto cartRequestDto) {
        RestTemplate rt = new RestTemplate();
        rt.postForEntity(route+"/save",cartRequestDto, void.class);

    }
}
