import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginIsSuccessful() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assertions.assertTrue(successMessage.isDisplayed());
    }
    @Test
    public void loginIsNotSuccessful() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Lidiia");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assertions.assertTrue(successMessage.isDisplayed());
    }

    @AfterEach
    public void closePage() {
        driver.close();
    }
}

