package bebeshop.bebeshopapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Long productNo;

    private String categoryNo;
    private String productImg1;
    private String productImg2;
    private String productImg3;
    private Long productPrice;
    private String productName;
    private Integer productCnt;
    private List<ReviewV2> reviewList;
}
