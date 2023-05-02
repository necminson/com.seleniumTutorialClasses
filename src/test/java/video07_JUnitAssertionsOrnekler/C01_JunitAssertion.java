package video07_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitAssertion {

    @Test
    public void test02(){
        // Benim çözümüm

        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        Assert.assertEquals("expectedURL does not exist",actualURL,expectedURL);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginYazisi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYazisi.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ahmet@nehaber.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement userName = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));

        Assert.assertTrue(userName.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        String actualURL02 = driver.getCurrentUrl();
        String expectedURL02 ="https://automationexercise.com/login";
       Assert.assertEquals(expectedURL02,actualURL02);
        //11. quit driver
        driver.quit();


    }

    @Test
    public void test01() {

       // AHMET Hocanın çözümü
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logoElementi= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signUpLinki= driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
        signUpLinki.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginYaziElementi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());
        //6. Enter correct email address and password
        WebElement emailAdresKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdresKutusu.sendKeys("ahmet@nehaber.com");
        WebElement passwordKutusu= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordKutusu.sendKeys("12345");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInYazisi= driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedInYazisi.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[text()=' Logout'] ")).click();
        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //11. Close driver
        driver.close();

    }


}