package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.Beverage;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
    List<Beverage> findAllByOrderByIdDesc();
}
