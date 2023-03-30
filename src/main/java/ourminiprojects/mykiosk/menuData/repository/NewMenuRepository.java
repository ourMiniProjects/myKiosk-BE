package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.NewMenu;

import java.util.List;

public interface NewMenuRepository extends JpaRepository<NewMenu, Long> {
    List<NewMenu> findAllByOrderByIdDesc();
}
