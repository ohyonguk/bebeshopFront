package bebeshop.bebeshopapi.dto;

import lombok.Data;

@Data
public class OrderDetail {
    private String orderDetailId;

    private String orderDetailNo;

    private Long productNo;

    private Integer orderQty;

    private Long orderPrice;

}
