package ourminiprojects.mykiosk.menuData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ourminiprojects.mykiosk.menuData.dto.*;
import ourminiprojects.mykiosk.menuData.repository.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final BeverageRepository beverageRepository;
    private final ChickenRepository chickenRepository;
    private final MorningRepository morningRepository;
    private final NewMenuRepository newMenuRepository;
    private final PremiumRepository premiumRepository;
    private final SideMenuRepository sideMenuRepository;
    private final WhopperRepository whopperRepository;

    public Map<String, List<Beverage>> getBeverage() {
        List<Beverage> beverages = beverageRepository.findAllByOrderByIdDesc();
        Map<String, List<Beverage>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }


    public Map<String, List<Chicken>> getChicken() {
        List<Chicken> beverages = chickenRepository.findAllByOrderByIdDesc();
        Map<String, List<Chicken>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }

    public Map<String, List<Morning>> getMorning() {
        List<Morning> beverages = morningRepository.findAllByOrderByIdDesc();
        Map<String, List<Morning>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }

    public Map<String, List<NewMenu>> getNewMenu() {
        List<NewMenu> beverages = newMenuRepository.findAllByOrderByIdDesc();
        Map<String, List<NewMenu>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }

    public Map<String, List<Premium>> getPremium() {
        List<Premium> beverages = premiumRepository.findAllByOrderByIdDesc();
        Map<String, List<Premium>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }

    public Map<String, List<SideMenu>> getSideMenu() {
        List<SideMenu> beverages = sideMenuRepository.findAllByOrderByIdDesc();
        Map<String, List<SideMenu>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }

    public Map<String, List<Whopper>> getWhopper() {
        List<Whopper> beverages = whopperRepository.findAllByOrderByIdDesc();
        Map<String, List<Whopper>> result = new HashMap<>();
        result.put("data", beverages);
        return result;
    }
}
