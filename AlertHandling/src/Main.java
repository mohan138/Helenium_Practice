import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();

        driver.switchTo().alert().accept();

        driver.quit();
    }
}