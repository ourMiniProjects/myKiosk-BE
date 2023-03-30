package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.Premium;

import java.util.List;

public interface PremiumRepository extends JpaRepository<Premium, Long> {
    List<Premium> findAllByOrderByIdDesc();
}
