package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Planet {

    private WebDriver driver;

    public Planet(WebDriver driver) {
        this.driver = driver;
    }


    public void openPlanetPage() {
        driver.findElement(By.cssSelector("[aria-label=\"planets\"]")).click();
    }

    public void getPlanetCards() {

        for (WebElement card : driver.findElements(By.className("planet"))){
            System.out.println(card);

        }
    }
}
