package bebeshop.bebeshopapi.RestService;

import bebeshop.bebeshopapi.dto.OrderRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderRestService {
    static String route = "http://localhost:8080/api/order";
    public static void saveOrder(OrderRequestDto orderRequestDto) {
        RestTemplate rt = new RestTemplate();
        rt.postForEntity(route+"/saveOrder",orderRequestDto, void.class);
    }
}
