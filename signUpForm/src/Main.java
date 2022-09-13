import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://goo.gl/RVdKM9");

        driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Hello");
        driver.findElement(By.id("RESULT_TextField-2")).sendKeys("World");
        driver.findElement(By.id("RESULT_TextField-3")).sendKeys("1234567890");
        driver.findElement(By.id("RESULT_TextField-4")).sendKeys("India");
        driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Mumbai");
        driver.findElement(By.id("RESULT_TextField-6")).sendKeys("helloworld@gmail.com");

        WebElement RadioButton = driver.findElement(By.id("RESULT_RadioButton-7_0"));
        System.out.println(RadioButton.isDisplayed());
        System.out.println(RadioButton.isEnabled());
        System.out.println(RadioButton.isSelected());
        JavascriptExecutor RadioButtonClick = (JavascriptExecutor)driver;
        RadioButtonClick.executeScript("arguments[0].click()",RadioButton);
        System.out.println(RadioButton.isSelected());

        JavascriptExecutor Monday = (JavascriptExecutor)driver;
        Monday.executeScript("arguments[0].click()",driver.findElement(By.id("RESULT_CheckBox-8_1")));

        JavascriptExecutor Friday = (JavascriptExecutor)driver;
        Monday.executeScript("arguments[0].click()",driver.findElement(By.id("RESULT_CheckBox-8_5")));

        JavascriptExecutor Saturday = (JavascriptExecutor)driver;
        Monday.executeScript("arguments[0].click()",driver.findElement(By.id("RESULT_CheckBox-8_6")));


        Select BestTimeToContactDropDown = new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
        List<WebElement> options = BestTimeToContactDropDown.getOptions();

        for(WebElement i:options){
            System.out.println(i.getText());
        }

        BestTimeToContactDropDown.selectByVisibleText("Morning");

        driver.quit();
    }
}