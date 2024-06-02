package bebeshop.bebeshopapi.service;

import bebeshop.bebeshopapi.RestService.InfoRestService;
import bebeshop.bebeshopapi.dto.OrderRequestDto;
import bebeshop.bebeshopapi.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final InfoRestService infoRestService;

    public List<OrderResponseDto> findOrderList(String id){
        return infoRestService.findOrderList(id).getBody();
    }

}
