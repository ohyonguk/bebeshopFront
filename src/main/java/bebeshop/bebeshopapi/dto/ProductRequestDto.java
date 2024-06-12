package bebeshop.bebeshopapi.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequestDto{
    private Long productNo;
    private String categoryNo;
    private String productName;
    private Integer productCnt;
    private Long productPrice;
    private String productImg1;
    private String productImg2;
    private String productImg3;
    private MultipartFile productImg;
    private Integer offset;
    private Integer limit;
    private Integer pager;

}
