package ourminiprojects.mykiosk.menuData.service.crawling;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ourminiprojects.mykiosk.menuData.dto.SideMenu;
import ourminiprojects.mykiosk.menuData.dto.Whopper;
import ourminiprojects.mykiosk.menuData.repository.SideMenuRepository;
import ourminiprojects.mykiosk.menuData.repository.WhopperRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SideMenuCrawling {
    private WebDriver driver;
    private final SideMenuRepository whopperRepository;

    private static final String url = "https://www.burgerking.co.kr/#/home";

    public void process() {
        System.setProperty("webdriver.chrome.driver", "/Users/yuhyeonseung/Downloads/chromedriver_mac_arm64/chromedriver");

        //크롬 버전이 111인 경우 사용합니다.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //위의 옵션이 필요하지 않은 경우 driver = new ChromeDriver() 이렇게 쓰시면 됩니다.
        driver = new ChromeDriver(options);

        try{
            getDataList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();

    }

    @Transactional
    List<SideMenu> getDataList() throws InterruptedException {

        driver.get(url);
        Thread.sleep(1000);

        // GNBWrap 클래스의 메뉴소개 버튼을 클릭합니다.
        WebElement menuButton = driver.findElement(By.cssSelector(".GNBWrap > ul > li:first-child > button"));
        menuButton.click();
        Thread.sleep(1000); // 1초 대기

        // 신제품(NEW)을 클릭합니다.
        WebElement newProductButton = driver.findElement(By.cssSelector(".GNBWrap > ul > li:first-child > ul > li:nth-child(6) > a"));
        newProductButton.click();
        Thread.sleep(1000); // 1초 대기

        //메뉴 이름
        List<WebElement> elements = driver.findElements(By.cssSelector(".cont"));

        //메뉴 이미지
        List<WebElement> imgElements = driver.findElements(By.tagName("img"));

        WebElement element1 = elements.get(0);
        System.out.println(element1.getText());

        List<SideMenu> whoppers = new ArrayList<>(elements.size());

        System.out.println("whopper생성" + elements.size());

        int[] priceArr = {2400,1200,1000,2300,2200,1800};

        List<Integer> priceList = new ArrayList<>();
        System.out.println("price리스트생성" + elements.size());

        for (int price : priceArr) {
            priceList.add(price);
        }

        for (int i = 0; i < elements.size(); i++) {
            SideMenu whopper = new SideMenu();
            Collections.shuffle(priceList);

            WebElement element = elements.get(i);
            WebElement imgElement = imgElements.get(i);

            System.out.println(element.getText());
            System.out.println(imgElement.getAttribute("src"));

            whopper.setFoodName(element.getText());
            whopper.setImageUrl(imgElement.getAttribute("src"));
            whopper.setPrice(priceList.get(0));

            whopperRepository.saveAndFlush(whopper);
        }

        return whoppers;
    }


}


