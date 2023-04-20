package ourminiprojects.mykiosk.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ourminiprojects.mykiosk.config.ResponseMsgDto;
import ourminiprojects.mykiosk.order.dto.Orders;
import ourminiprojects.mykiosk.order.dto.OrdersDto;
import ourminiprojects.mykiosk.order.dto.OrdersRequestDto;
import ourminiprojects.mykiosk.order.repository.OrdersRepository;

import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepository ordersRepository;

    //클라이언트 상태코드 수정을 위해 사용함
    public void exceptionHandler(HttpServletResponse response, int statusCode) {
        //setStatus를 통해 response의 상태 코드 set
        response.setStatus(statusCode);
        //콘텐츠 유형을 json으로 바꿔줌
        response.setContentType("application/json");
    }

    //위 핸들러를 쓰고 dto로 리턴하기
    private ResponseMsgDto handleException(String message, HttpStatus status, HttpServletResponse response) {
        exceptionHandler(response, status.value());
        return new ResponseMsgDto(message, status.value());
    }


    @Transactional
    public ResponseMsgDto orderMenu(List<OrdersRequestDto> ordersRequestDto, HttpServletResponse response) {
        // 랜덤한 바이트 배열 생성
        byte[] randomBytes = new byte[4];
        new SecureRandom().nextBytes(randomBytes);
        // 바이트 배열을 Base64 인코딩하여 문자열로 변환
        String orderNumber = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

        for (OrdersRequestDto requestDto : ordersRequestDto) {
            OrdersDto ordersDto = OrdersDto.builder()
                    .orderNum(orderNumber)
                    .menuName(requestDto.getMenuName())
                    .amount(requestDto.getAmount())
                    .build();

            Orders orders = new Orders(ordersDto);

            ordersRepository.save(orders);
        }

        return handleException("주문이 완료되었습니다", HttpStatus.OK, response);
    }
}
