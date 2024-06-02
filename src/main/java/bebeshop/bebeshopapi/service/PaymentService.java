package bebeshop.bebeshopapi.service;

import bebeshop.bebeshopapi.RestService.OrderRestService;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CartService cartService;
    private final OrderRestService orderRestService;


    public void saveOrder(OrderRequestDto orderRequestDtoList) {
        OrderRestService.saveOrder(orderRequestDtoList);

    }
}
