package video02_DriverMetodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMetodlari {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        // 1- driver.get("url") --> yazdigimiz url'e gider
        driver.get("https://www.amazon.com"); // Mutlaka https:// yazılmalı. Sadece www.amazon.com yazılması yeterli değildir.

        // 2- driver.getTitle() --> icinde oldugu sayfanin basligini döndürür
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle); //Amazon.com. Spend less. Smile more.

        // 3- driver.getCurrentUrl() --> icinde oldugu sayfanin URL'ini döndürür
        String amazonUrl = driver.getCurrentUrl();
        System.out.println("amazonUrl = " + amazonUrl);  // https://www.amazon.com/

        // 4- driver.getPageSource(); --> icinde oldugu sayfanin kaynak kodlarini döndürür
        System.out.println("===========================================================");
        String amazonPageSrc = driver.getPageSource();
        System.out.println("amazonPageSrc = " + amazonPageSrc); // arka planda calisan sayfa kodlarini yazdirir
        System.out.println("===========================================================");

        // 5- driver.getWindowHandle() --> icinde oldugu sayfanin UNIQUE hash kodunu döndürür
        String amazonCdWindow = driver.getWindowHandle();
        System.out.println("amazonCdWindow = " + amazonCdWindow);  // CDwindow-F4A35FD5413FE52C6DEB0B03CA6DFB9F

        // 6- driver.getWindowHandles() --> driver calisirken acilan tum sayfalarin UNIQUE hash kodunu döndürür

    }
}
