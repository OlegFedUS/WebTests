import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserStackTest {

    @Test
    public void SeleniumPractice() {

        System.setProperty("webdriver.chrome.driver", "c:\\program files\\google\\chrome\\application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.browserstack.com/users/sing_in");

        WebElement login = driver.findElement(By.linkText("Sign in"));
        login.click();

        WebElement user = driver.findElement(By.id("user_email_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement login2 = driver.findElement(By.id("user_submit"));
        user.sendKeys("abc@gmail.com");
        password.sendKeys("12345abc");
        login2.click();

        WebElement error = driver.findElement(By.id("bs-alert-text-id"));
        String errorText = error.getText();

        Assert.assertEquals(errorText, "There have been several failed attempts to sign in from this account. Please wait a while and try again later.");


    }
}
