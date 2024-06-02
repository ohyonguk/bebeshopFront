package bebeshop.bebeshopapi.dto;

import lombok.Data;

@Data
public class MemberRequestDto {
    private String id;
    private String password;
    private Boolean idSave;
}
