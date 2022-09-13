import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        int rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
        int columns = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th")).size();

        for(int row=1; row<=1; row++){
            for(int column=1; column<=columns; column++){
                System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+row+"]/th["+column+"]")).getText());
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int row=2; row<=rows; row++){
            for(int column=1; column<columns;column++){
                System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+row+"]/td["+column+"]")).getText());
                System.out.print("  ");
            }
            System.out.println();
        }
        driver.quit();
    }
}

