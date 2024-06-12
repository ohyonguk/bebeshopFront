package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.UploadFileUtils;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import bebeshop.bebeshopapi.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private String uploadPath;
    @GetMapping("/admin/product_add")
    public String productAdd(HttpServletRequest req, HttpSession httpSession){
        return "admin/product_add";
    }
    @PostMapping("/admin/addProduct")
    public String addProduct(@RequestPart(value = "img") MultipartFile[] file, @RequestPart(value = "json") ProductRequestDto productRequestDto, HttpServletRequest req ) throws Exception {

        String imgUploadPath = uploadPath + File.separator + "imgUpload";
//		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

        for (int i = 0; i < file.length; i++) {
            fileName = UploadFileUtils.fileUpload(imgUploadPath, file[i].getOriginalFilename(), file[i].getBytes());
            if (i == 0)
                productRequestDto.setProductImg1(File.separator + "imgUpload" +  File.separator + fileName);
            else if (i == 1)
                productRequestDto.setProductImg2(File.separator + "imgUpload" +  File.separator + fileName);
            else if (i == 2)
                productRequestDto.setProductImg3(File.separator + "imgUpload" + File.separator + fileName);
        }

        productService.addProduct(productRequestDto);
        return "1";

    }

    @GetMapping("/admin/product_mng")
    public String productMng(HttpServletRequest req , HttpSession httpSession){
        ProductRequestDto productRequest =new ProductRequestDto();
        productRequest.setOffset(0);
        productRequest.setLimit(999);
        List response = productService.searchPage(productRequest);

        req.setAttribute("productlist",response);
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
