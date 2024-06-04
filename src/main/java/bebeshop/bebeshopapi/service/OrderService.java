package bebeshop.bebeshopapi.service;

import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final ProductService productService;
    private final CartService cartService;
    public List getOrderInfo(List<Long> cartNoList) {
        CartRequestDto cartRequestDto = new CartRequestDto();
        cartRequestDto.setCartNoList(cartNoList);
        cartRequestDto.setId("xxx");
        return cartService.findOrderListCart(cartRequestDto);
    }


}
