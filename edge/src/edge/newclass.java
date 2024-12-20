package edge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class newclass {

    public static void main(String[] args) {
        // Set up the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\SQA Course\\SQA soft\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Login Page
            driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for Username, Password, and Login button to be visible
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            // Enter login credentials and click the login button
            username.sendKeys("Anamul");
            password.sendKeys("Carelogix24!!");
            login.click();

            // Wait for the page to load after login
            Thread.sleep(5000);  // Replace with explicit wait if possible

            // Click on the profile using XPath
            WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[2]/div/div/div[11]/div[1]/div[1]/div/div/span/img")));
            profile.click();

            Thread.sleep(2000);  // Replace with explicit wait if possible

            // Click on the search icon using the new XPath
            WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[2]/header/div[2]/button/img")));
            searchIcon.click();

            
         // Wait for the search input to appear
            WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[2]/header/div/span/input")));

            // Enter text into the search input
            searchInput.sendKeys("SQA Final Project");
            System.out.println("Search text entered successfully!");

        } catch (Exception e) {
            System.out.println("Error here: " + e.getMessage());
        } finally {
            System.out.println("Test Completed!");
            
        }
    }
}
