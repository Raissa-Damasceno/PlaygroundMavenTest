package tests;

import models.Form;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;

public class playgroundTests {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = getWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
    @Test
    public void fillOutAndClickSubmitButton() {
        driver.findElement(By.id("forename")).sendKeys("Raissa Damasceno");
        driver.findElement(By.id("submit")).click();
    }
    @Test
    public void checkTitle() {
        String titleValue = driver.findElement(By.cssSelector("h1.display-1.mb-3")).getText();
        Assertions.assertEquals("Web Playground", titleValue);
    }
    @Test
    public void chickMeDownToUpTest() {
        By buttonBy = By.cssSelector("[role=button]");
        driver.findElement(buttonBy).click();

        String buttonText = driver.findElement(buttonBy).getText();
        waitTime(buttonBy, "CLICK ME UP!");
        Assertions.assertEquals("CLICK ME UP!", buttonText);
    }
    @Test
    public void clickMeUpToDownTest() {
        By buttonBy = By.cssSelector("[role=button]");
        driver.findElement(buttonBy).click();

        String buttonText = driver.findElement(buttonBy).getText();
        waitTime(buttonBy, "CLICK ME DOWN!");
        Assertions.assertEquals("CLICK ME DOWN!", buttonText);
    }

    // Form
    @Test
    public void formTest(){
        Form form = new Form(driver);
        form.enterName("Raissa Damasceno");
        form.enterEmail("raissa.cod@gmail.com");
        form.selectState("nsw");
        form.clickAgree();
        form.submit();


        By byPopUpMessage = By.className("popup-message");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(byPopUpMessage)
        );

        Assertions.assertEquals("Thanks for your feedback Raissa Damasceno", driver.findElement(byPopUpMessage).getText());
    }


    @AfterEach
    public void afterAll() {
        //driver.quit();
    }

    private WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    private void waitTime(By buttonBy, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                ExpectedConditions.textToBe(buttonBy, text)
        );
    }

}