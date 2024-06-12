package bebeshop.bebeshopapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private String orderNo;
    private String id;
    private Delivery delivery;
    private List<OrderDetail> orderDetail;
    private Long totalPrice;
}
