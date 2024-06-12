package bebeshop.bebeshopapi.service;

import bebeshop.bebeshopapi.RestService.ProductRestService;
import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.ProductRequestDto;
import bebeshop.bebeshopapi.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRestService productRestService;

    public List searchPage(ProductRequestDto productRequestDto){
        ResponseEntity<List> v = productRestService.searchPage(productRequestDto);
        return v.getBody();
    }
    public ProductResponseDto productDetail(ProductRequestDto productRequestDto){
        ProductResponseDto response =  productRestService.productDetail(productRequestDto);
        return response;

    }
    public int  productCnt(ProductRequestDto productRequestDto){
        ProductResponseDto prd = productRestService.productDetail(productRequestDto);
        return prd.getProductCnt();
    }

    public Boolean productCntList(CartRequestDto cartRequestDto){
        return productRestService.productCntList(cartRequestDto);
    }


    public void addProduct(ProductRequestDto productRequestDto) {
        productRestService.addProduct(productRequestDto);
    }
}
