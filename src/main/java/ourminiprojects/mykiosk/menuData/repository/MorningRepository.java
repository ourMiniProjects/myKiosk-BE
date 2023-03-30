package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.Morning;

import java.util.List;

public interface MorningRepository extends JpaRepository<Morning, Long> {
    List<Morning> findAllByOrderByIdDesc();
}
