import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Object>chromeProperties = new HashMap<String, Object>();
        chromeProperties.put("download.default_directory","/Users/mohanaditya/TestDownloads");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromeProperties);

        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demo.automationtesting.in/FileDownload.html");
        driver.findElement(By.linkText("Download")).click();
    }
}