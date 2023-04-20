package ourminiprojects.mykiosk.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourminiprojects.mykiosk.config.ResponseMsgDto;
import ourminiprojects.mykiosk.order.dto.OrdersRequestDto;
import ourminiprojects.mykiosk.order.service.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseMsgDto orderMenu(@RequestBody List<OrdersRequestDto> ordersRequestDto, HttpServletResponse response) {
        return orderService.orderMenu(ordersRequestDto,response);
    }






}
