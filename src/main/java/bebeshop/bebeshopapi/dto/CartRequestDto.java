package bebeshop.bebeshopapi.dto;

import bebeshop.bebeshopapi.service.ProductV2;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CartRequestDto {
    private String id;
    private Character dispYn;
    private Long cartNo;
    private Long productNo;
    private Long count;
    private List<Long> productNoList;
    private List<ProductV2> productList;
    private List<Long> cartNoList;
    private String btn;

}