package bebeshop.bebeshopapi.contoller;

import bebeshop.bebeshopapi.dto.CartRequestDto;
import bebeshop.bebeshopapi.dto.OrderRequestDto;
import bebeshop.bebeshopapi.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private IamportClient iamportClient;
    private final PaymentService paymentService;

    @Value("${import.code}")
    String code;
    @Value("${import.api.key}")
    String apiKey;
    @Value("${import.api.secretKey}")
    String secretKey;

    @PostConstruct
    public void init() {
        this.iamportClient = new IamportClient(apiKey, secretKey);
    }



    @PostMapping(value = "/order/payment")
    @ResponseBody
    public void payment(@RequestBody OrderRequestDto orderRequestDtoList,
                          HttpServletRequest req, HttpSession session){
        paymentService.saveOrder(orderRequestDtoList);
    }

    @PostMapping("/payment/validation/{imp_uid}")
    @ResponseBody
    public IamportResponse<Payment> validateIamport(@PathVariable String imp_uid, @RequestBody List<OrderRequestDto> orderRequestDtoList) {
        IamportResponse<Payment> payment = iamportClient.paymentByImpUid(imp_uid);
        return payment;
    }
}
