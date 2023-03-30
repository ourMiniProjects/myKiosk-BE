package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.Whopper;

import java.util.List;

public interface WhopperRepository extends JpaRepository<Whopper, Long> {
    List<Whopper> findAllByOrderByIdDesc();
}
