import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/");
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("submit")).click();

        if(driver.getTitle().equals("Login: Mercury Tours"))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        driver.quit();
    }
}