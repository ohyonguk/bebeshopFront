package bebeshop.bebeshopapi.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductV2{
    private Long productNo;

    private String categoryNo;

    private String productImg1;

    private String productImg2;

    private String productImg3;

    private Long productPrice;

    private String productName;

    private Integer productCnt;

    private List<ProductV2> list;

}
