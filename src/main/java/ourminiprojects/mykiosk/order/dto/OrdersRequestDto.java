package ourminiprojects.mykiosk.order.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrdersRequestDto {
    private String menuName;

    private int amount;
}
