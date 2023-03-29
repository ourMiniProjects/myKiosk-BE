package ourminiprojects.mykiosk.menu;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Crawling {
    private WebDriver driver;

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

    private List<String> getDataList() throws InterruptedException {


        List<String> list = new ArrayList<>();

        driver.get(url);
        Thread.sleep(1000);

        // GNBWrap 클래스의 메뉴소개 버튼을 클릭합니다.
        WebElement menuButton = driver.findElement(By.cssSelector(".GNBWrap > ul > li:first-child > button"));
        menuButton.click();
        Thread.sleep(1000); // 1초 대기

        // 신제품(NEW)을 클릭합니다.
        WebElement newProductButton = driver.findElement(By.cssSelector(".GNBWrap > ul > li:first-child > ul > li:nth-child(3) > a"));
        newProductButton.click();
        Thread.sleep(1000); // 1초 대기

        List<WebElement> elements = driver.findElements(By.cssSelector(".tab_cont .prdmenu_list .cont"));

        for (WebElement element : elements) {

            System.out.println(element.getText());
        }

        List<WebElement> imgElements = driver.findElements(By.tagName("img"));

        for (WebElement imgElement : imgElements) {
            //base64로 인코딩 된 게 나와서 그거 없애주려고
            if (imgElement.getAttribute("src").contains("data:image/png;base64")) {
                continue;
            }
            String srcValue = imgElement.getAttribute("src");
            System.out.println("src value: " + srcValue);


    }
        return list;
    }


}


