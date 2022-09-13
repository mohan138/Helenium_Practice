import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/div[2]/div[2]/img")).click();
        pastDate(driver);
    }
    public static void currentDate(WebDriver driver){
        driver.findElement(By.linkText(String.valueOf(Calendar.getInstance().get(Calendar.DATE)))).click();
    }

    public static void pastDate(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        while(true){
            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))).getText().equals("August"))
                break;
        }
        driver.findElement(By.linkText(String.valueOf(Calendar.getInstance().get(Calendar.DATE)))).click();
    }
}