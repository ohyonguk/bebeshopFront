package bebeshop.bebeshopapi.dto;

import lombok.Data;

@Data
public class ProductRequestDto{
    private Long productNo;
    private String categoryNo;
    private String productName;
    private Integer offset;
    private Integer limit;
    private Integer pager;

}
