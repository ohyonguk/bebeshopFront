package bebeshop.bebeshopapi.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderResponseDto {
    private Long ordersNo;
    private String orderStatus;
    private Long totalPrice;
    private List<OrderDetail> orderDetailList;
    private Delivery delivery;
}
