import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        WebElement buttonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        Assert.assertTrue(buttonRegister.isDisplayed(), "Кнопка 'Register' отсутствует, открыта неверная форма");
        driver.findElement(By.name("first_name")).sendKeys("Dasha");
        driver.findElement(By.name("last_name")).sendKeys("Bulycheva");
        driver.findElement(By.name("email")).sendKeys("123456@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("Db123456!");
        driver.findElement(By.name("password2")).sendKeys("Db123456!");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String passesMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(passesMessage, "Account is created!");
        driver.quit();
    }
}
