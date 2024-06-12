package bebeshop.bebeshopapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartRequestDto {
    private String id;
    private Character dispYn;
    private Long cartNo;
    private Long productNo;
    private Long count;
    private List<Long> productNoList;
    private List<ProductRequestDto> productList;
    private List<Long> cartNoList;
    private String btn;

}