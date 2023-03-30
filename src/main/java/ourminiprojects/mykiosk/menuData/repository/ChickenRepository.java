package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.Chicken;

import java.util.List;

public interface ChickenRepository extends JpaRepository<Chicken, Long> {
    List<Chicken> findAllByOrderByIdDesc();

}
