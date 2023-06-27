package au.com.ncs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class playgroundTests {

    @Test
    public void demoTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("www.google.com");
    }
}
