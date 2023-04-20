package ourminiprojects.mykiosk.order.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrdersDto {
    private String menuName;
    private int amount;
    private String orderNum;
}
