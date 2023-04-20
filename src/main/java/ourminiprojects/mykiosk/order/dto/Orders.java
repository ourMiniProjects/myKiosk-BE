package ourminiprojects.mykiosk.order.dto;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String orderNum;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private int amount;

    public Orders(OrdersDto ordersDto) {
        this.menuName = ordersDto.getMenuName();
        this.amount = ordersDto.getAmount();
        this.orderNum = ordersDto.getOrderNum();
    }

}
