package ourminiprojects.mykiosk.menuData.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourminiprojects.mykiosk.menuData.dto.*;
import ourminiprojects.mykiosk.menuData.service.MenuService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/beverage")
    public Map<String, List<Beverage>> getBeverage() {
        return menuService.getBeverage();
    }

    @GetMapping("/chicken")
    public Map<String, List<Chicken>> getChicken() {
        return menuService.getChicken();
    }

    @GetMapping("/morning")
    public Map<String, List<Morning>> getMoring() {
        return menuService.getMorning();
    }

    @GetMapping("/newMenu")
    public Map<String, List<NewMenu>> getNewMenu() {
        return menuService.getNewMenu();
    }

    @GetMapping("/premium")
    public Map<String, List<Premium>> getPremium() {
        return menuService.getPremium();
    }

    @GetMapping("/sideMenu")
    public Map<String, List<SideMenu>> getSideMenu() {
        return menuService.getSideMenu();
    }

    @GetMapping("/whopper")
    public Map<String, List<Whopper>> getWhopper() {
        return menuService.getWhopper();
    }
}
