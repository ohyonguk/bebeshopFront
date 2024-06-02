package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.service.OrderService;
import bebeshop.bebeshopapi.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @PostMapping("/order/checkStock")
    @ResponseBody
    public boolean checkStock(@RequestBody CartRequestDto cartRequestDto,HttpServletRequest req) throws Exception {
        boolean chk = productService.productCntList(cartRequestDto);
        if(chk){
            return true;
        }else{
            throw new Exception("재고 초과");
        }

    }
    @GetMapping("/order/goOrder/{cartList}")
    public String order(@ModelAttribute CartRequestDto cartRequestDto,
                        //RequestParam(value = "cartList", required = true) List<Long> cartNoList ,
                        HttpServletRequest req, HttpSession session){
        List orderInfoList = orderService.getOrderInfo(cartRequestDto.getCartNoList());

        req.setAttribute("info",orderInfoList);

        return "order/order";
    }
    @GetMapping("/order/order_sc")
    public String order_sc(){
        return "order/order_sc";
    }


}
