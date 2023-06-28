package models;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {

    private WebDriver driver;
    private String name;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        this.name = name;
        this.driver.findElement(By.cssSelector("[aria-label=forms]")).click();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void selectState(String state) {
        By bySelectEl = By.cssSelector("div.v-select__selections");
        driver.findElement(bySelectEl).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(bySelectEl)
        );

        for(WebElement option : driver.findElements(By.cssSelector("[role=option]"))) {
            if(option.getText().equalsIgnoreCase(state)) {
                option.click();
                break;
            }
        }
    }
    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }
    public void submit() {
        for (WebElement button : driver.findElements(By.cssSelector("[type=button]"))) {
            if(button.getText().equalsIgnoreCase("submit")) {
                button.click();
            }
        }
    }

}
