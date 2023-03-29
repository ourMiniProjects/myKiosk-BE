package ourminiprojects.mykiosk.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ourminiprojects.mykiosk.menu.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final FoodRepository foodRepository;



}
