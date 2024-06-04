package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import bebeshop.bebeshopapi.service.CartService;
import bebeshop.bebeshopapi.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    private final ProductService productService;

    @GetMapping("/user/cart")
    public String cartView(@ModelAttribute CartRequestDto cartRequestDto, HttpServletRequest req
    , HttpSession httpSession){

        cartRequestDto.setId(httpSession.getAttribute("sessionUser").toString());
        cartRequestDto.setDispYn('Y');
        List res = cartService.findCart(cartRequestDto);

        req.setAttribute("cartList",res);


        return "user/cart";
    }
    @PostMapping("/user/cart/insertCart")
    @ResponseBody
    public void insertCart(@RequestBody CartRequestDto cartRequestDto, HttpServletRequest req,
                          HttpSession httpSession) throws Exception {
        ModelAndView mv = new ModelAndView();
        cartRequestDto.setId(httpSession.getAttribute("sessionUser").toString());
        try{
            cartService.insetCart(cartRequestDto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/user/cart/addCartAndOrder")
    @ResponseBody
    public Long addCartAndOrder(@RequestBody CartRequestDto cartRequestDto, HttpServletRequest req,
                           HttpSession httpSession) throws Exception {
        ModelAndView mv = new ModelAndView();
        cartRequestDto.setId(httpSession.getAttribute("sessionUser").toString());
        Long cartNo =0L;
        try{
            cartNo = cartService.insetCart(cartRequestDto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return cartNo;
    }
    @PostMapping("/user/cart/deleteList")
    @ResponseBody
    public String deleteCart(@RequestBody CartRequestDto cartRequestDto, HttpServletRequest req){
        cartRequestDto.setId("xxx");
        cartRequestDto.setDispYn('N');
        cartService.deleteCartList(cartRequestDto);
        return null;
    }

}
