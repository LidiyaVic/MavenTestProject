import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
    }

    @Test
    public void loginIsSuccessful() {
        WebDriver driver = new ChromeDriver();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assertions.assertTrue(successMessage.isDisplayed());
        driver.quit();
    }
    @Test
    public void loginIsNotSuccessful() {
        WebDriver driver = new ChromeDriver();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Lidiia");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assertions.assertTrue(successMessage.isDisplayed());
        driver.quit();
    }
}

