package au.com.ncs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class playgroundTests {


    @Test
    public void demoTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.findElement(By.id("forename")).sendKeys("Raissa Damasceno");
        driver.findElement(By.id("submit")).click();
        driver.quit();
    }

    @Test
    public void checkTitle() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        String titleValue = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div/div[1]/div/h1")).getText();
        Assertions.assertEquals(titleValue, "Web Playground");
        driver.quit();
    }

}
