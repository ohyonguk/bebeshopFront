package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.ProductRequestDto;
import bebeshop.bebeshopapi.dto.ProductResponseDto;
import bebeshop.bebeshopapi.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{categoryNo}/{pager}")
    public String prodcut(@ModelAttribute ProductRequestDto productRequest, HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        Integer a = productRequest.getPager();
        productRequest.setOffset((productRequest.getPager()/10) * 100);
        productRequest.setLimit(99);
        List response = productService.searchPage(productRequest);
        List returnVal = response.subList((a-1)*3, Math.min(response.size(), (a - 1) * 3 + 3));

        req.setAttribute("list",returnVal);
        req.setAttribute("size", response.size());
        req.setAttribute("category",productRequest.getCategoryNo());
        req.setAttribute("page",productRequest.getPager());

        return "product/searchPage";
    }

    @GetMapping("/product/detail/{productNo}")
    public String productDetail(@ModelAttribute ProductRequestDto productRequest, HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        ProductResponseDto productResponseDto = productService.productDetail(productRequest);

        req.setAttribute("detMain", productResponseDto);

        return "product/detail";
    }


    @PostMapping("/productdetail/options.stock")
    public int productCnt(@ModelAttribute ProductRequestDto productRequest, HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        int cnt = productService.productCnt(productRequest);

        return cnt;
    }



}
