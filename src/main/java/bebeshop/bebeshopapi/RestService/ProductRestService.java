package bebeshop.bebeshopapi.RestService;

import bebeshop.bebeshopapi.dto.ApiResponse;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import bebeshop.bebeshopapi.dto.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductRestService {
    static String route = "http://localhost:8080/api/product";

    public ResponseEntity<List> searchPage(ProductRequestDto productRequestDto){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<List> res = rt.postForEntity(route+"/find",productRequestDto, List.class);
        return res;

    }

    public ProductResponseDto productDetail(ProductRequestDto productRequestDto) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<ProductResponseDto> res = rt.postForEntity(route+"/detail",productRequestDto, ProductResponseDto.class);
        log.info("{}",res);
        return res.getBody();

    }

    public Boolean productCntList(CartRequestDto cartRequestDto) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Boolean> res = rt.postForEntity(route+"/productCntList",cartRequestDto, Boolean.class);
        return res.getBody();
    }
}
