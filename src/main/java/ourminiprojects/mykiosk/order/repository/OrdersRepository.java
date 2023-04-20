package ourminiprojects.mykiosk.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.order.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
