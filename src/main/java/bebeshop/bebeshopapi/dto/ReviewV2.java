package bebeshop.bebeshopapi.dto;

import lombok.Data;

@Data
public class ReviewV2 {
    private String reviewNo;

    private String productNo;

    private String id;

    private String reviewScore;

    private String reviewContent;

    private Long reviewLike;
}
