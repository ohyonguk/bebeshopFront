package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.OrderResponseDto;
import bebeshop.bebeshopapi.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class InfoController {
    private final InfoService infoService;
    @GetMapping("/user/user_info")
    public String userInfoPage(){
        return "user/user_info";
    }
    @GetMapping("/user/mylog")
    public String mylogPage(){
        return "user/mylog";
    }
    @GetMapping("/user/purchase_history")
    public String historyPage(@RequestParam String id){
        infoService.findOrderList(id);
        return "user/purchaseHistory";
    }
}
