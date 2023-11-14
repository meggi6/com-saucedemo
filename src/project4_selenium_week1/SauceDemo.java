package project4_selenium_week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field. 7. Enter the password to password field. 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class SauceDemo {
    static String browser = "Chrome"; //setting browser
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;  //declaring webdriver interface

    public static void main(String[] args) {
        //checking for multiple browsers to launch
        if (browser.equalsIgnoreCase("Chrome")){
            driver =  new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        } else {
            System.out.println("wrong browser name");
        }

        //launching url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //setting Implicit wait to driver until page is fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //printing website title on console
        System.out.println("Title of website is: " + driver.getTitle());
        //printing current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //printing page source
        System.out.println("The page source is: " + driver.getPageSource());

        //Enter email id on email field element
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password on password field element
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on login button element
        driver.findElement(By.id("login-button")).click();
        System.out.println("The current url is : "+ driver.getCurrentUrl());

        //navigation
        driver.navigate().to(baseUrl);
        driver.navigate().refresh();

        driver.quit();  //to close browser
    }
}
