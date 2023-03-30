package ourminiprojects.mykiosk.menuData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.menuData.dto.SideMenu;

import java.util.List;

public interface SideMenuRepository extends JpaRepository<SideMenu, Long> {
    List<SideMenu> findAllByOrderByIdDesc();
}
