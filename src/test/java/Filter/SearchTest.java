package Filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


// для себя потренироваться
public class SearchTest {

    @Test
    public void checkValidSearch() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://www.sharelane.com/cgi-bin/main.py");
        webDriver.findElement(By.name("keyword")).sendKeys("The Alchemist");
        webDriver.findElement(By.cssSelector("[value=Search]")).click();
        webDriver.quit();
    }

    @Test
    public void checkSearch3Character() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://www.sharelane.com/cgi-bin/main.py");
        webDriver.findElement(By.name("keyword")).sendKeys("Hii");
        webDriver.findElement(By.cssSelector("[value=Search]")).click();
        String validationMessage = webDriver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(validationMessage, "Please, note that current MySQL settings don't allow " +
                "searches for words containing less than 4 chars");
        webDriver.quit();
    }

    @Test
    public void checkNotFoundSearch() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://www.sharelane.com/cgi-bin/main.py");
        webDriver.findElement(By.name("keyword")).sendKeys("TESTOVIY SCENARIY");
        webDriver.findElement(By.cssSelector("[value=Search]")).click();
        String notFoundMessage = webDriver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(notFoundMessage, "Nothing is found :(");
        webDriver.quit();
    }
}
