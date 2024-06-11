package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.CartRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/admin/product_add")
    public String productAdd(HttpServletRequest req, HttpSession httpSession){
        return "admin/product_add";
    }
    @GetMapping("/admin/product_mng")
    public String productMng(HttpServletRequest req , HttpSession httpSession){
        return "admin/product_mng";
    }
    @GetMapping("/admin/user_mng")
    public String userMng(HttpServletRequest req, HttpSession httpSession){
        return "admin/user_mng";
    }
    @GetMapping("/admin/order_mng")
    public String orderMng(HttpServletRequest req, HttpSession httpSession){

        return "admin/order_mng";
    }

}
