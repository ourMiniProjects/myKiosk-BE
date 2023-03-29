package ourminiprojects.mykiosk.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    Crawling crawling;
    @GetMapping("/test")
    public void tester() {
        crawling.process();
    }
}
