package ourminiprojects.mykiosk.menuData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ourminiprojects.mykiosk.menuData.service.crawling.*;

@RestController
public class DummyController {
    @Autowired
    BeverageCrawling beverageCrawling;
    @Autowired
    ChickenCrawling chickenCrawling;
    @Autowired
    MorningCrawling morningCrawling;
    @Autowired
    NewMenuCrawling newMenuCrawling;
    @Autowired
    PremiumCrawling premiumCrawling;
    @Autowired
    SideMenuCrawling sideMenuCrawling;
    @Autowired
    WhopperCrawling whopperCrawling;



    @GetMapping("/whopper")
    public void whopper() {
        whopperCrawling.process();
    }

    @GetMapping("/chicken")
    public void chicken() {
        chickenCrawling.process();
    }
    @GetMapping("/morning")
    public void mornig() {
        morningCrawling.process();
    }

    @GetMapping("/newMenu")
    public void newMenu() {
        newMenuCrawling.process();
    }
    @GetMapping("/premium")
    public void premium() {
        premiumCrawling.process();
    }

    @GetMapping("/sideMenu")
    public void sideMenu() {
        sideMenuCrawling.process();
    }

    @GetMapping("/beverage")
    public void beverage() {
        beverageCrawling.process();
    }



}
