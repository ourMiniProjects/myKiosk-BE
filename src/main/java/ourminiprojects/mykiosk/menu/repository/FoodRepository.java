package ourminiprojects.mykiosk.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menu.dto.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
