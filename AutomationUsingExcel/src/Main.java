import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","/Users/mohanaditya/Documents/Browser Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        WebElement principal = driver.findElement(By.id("principal"));
        WebElement interest = driver.findElement(By.id("interest"));
        WebElement tenure = driver.findElement(By.id("tenure"));
        Select tenurePeriod = new Select(driver.findElement(By.id("tenurePeriod")));
        Select frequency = new Select(driver.findElement(By.id("frequency")));
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img"));
        WebElement clear = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img"));

        driver.findElement(By.id("wzrk-cancel")).click();
        actions.moveByOffset(0,25).perform();

        ReadingExcel readingExcel = new ReadingExcel("/Users/mohanaditya/Documents/caldata.xlsx");
        WriteExcel writeExcel = new WriteExcel("/Users/mohanaditya/Documents/caldata.xlsx");
        readingExcel.read();
        List<OneCycleInputs> allInputs = readingExcel.getAllInputs();

        for(int rows=0; rows<readingExcel.numberOfRows(); rows++){
            principal.sendKeys(allInputs.get(rows).principle());
            interest.sendKeys(allInputs.get(rows).rateOfInterest());
            tenure.sendKeys(allInputs.get(rows).period());
            tenurePeriod.selectByVisibleText("year(s)");
            frequency.selectByVisibleText(allInputs.get(rows).frequency());
            calculate.click();
            String value = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
            writeExcel.write(rows+1,value);
            clear.click();
        }
    }
}