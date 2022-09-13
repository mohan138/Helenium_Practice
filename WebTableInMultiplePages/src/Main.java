import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");

        int count = 1;
        while (true){
            int rows = driver.findElements(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr")).size();
            int columns = driver.findElements(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[1]/td")).size();
            for (int row=1; row<=rows; row++){
                for(int column=1; column<=columns; column++){
                    System.out.print(driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr["+row+"]/td["+column+"]")).getText());
                    System.out.println();
                }
                System.out.println();
            }
            count++;
            try {
                driver.findElement(By.linkText("Next")).click();
            }catch (Exception e){
                break;
            }
        }
        driver.quit();
    }
}

