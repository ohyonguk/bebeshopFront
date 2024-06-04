package bebeshop.bebeshopapi.service;

import bebeshop.bebeshopapi.RestService.CartRestService;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRestService cartRestService;
    private final ProductService productService;

    public List findCart(CartRequestDto cartRequestDto){
        ResponseEntity<List> res =  cartRestService.findCart(cartRequestDto);
        return res.getBody();
    }
    public List findOrderListCart(CartRequestDto cartRequestDto){
        ResponseEntity<List> res =  cartRestService.findOrderListCart(cartRequestDto);
        return res.getBody();
    }

    public void deleteCartList(CartRequestDto cartRequestDto) {
        cartRestService.deleteCartList(cartRequestDto);
    }

    public Long insetCart(CartRequestDto cartRequestDto) throws Exception {
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setProductNo(cartRequestDto.getProductNo());
        int cnt = productService.productCnt(productRequestDto);

        if(cnt<cartRequestDto.getCount()){
            throw new Exception("최대 수량을 초과하여 담을 수 없습니다.");
        }

        return cartRestService.insertCart(cartRequestDto);

    }
}
