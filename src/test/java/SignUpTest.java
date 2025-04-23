import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    @Test
    public void checkSignUpValidData(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDisplayed = browser.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        browser.findElement(By.name("first_name")).sendKeys("test");
        browser.findElement(By.name("last_name")).sendKeys("12345");
        browser.findElement(By.name("email")).sendKeys("gmail@gmail.com");
        browser.findElement(By.name("password1")).sendKeys("12345");
        browser.findElement(By.name("password2")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Register]")).click();
        String successMessage = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(successMessage, "Account is created!");
        browser.quit();
        }
    }
