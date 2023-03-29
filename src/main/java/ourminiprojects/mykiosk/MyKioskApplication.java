package ourminiprojects.mykiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ourminiprojects.mykiosk.menu.Crawling;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyKioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyKioskApplication.class, args);
    }

}
