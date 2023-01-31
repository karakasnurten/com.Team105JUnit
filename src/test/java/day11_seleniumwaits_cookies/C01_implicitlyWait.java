package day11_seleniumwaits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_implicitlyWait {

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Selenium 4'e kadar 15 saniyeyi belirtmek icin
        // Timeouts class'indan 15  saniye tanimliyorduk,  yani duration yerine timeouts. kullanilirdi
        // Selenium 4 ile birlikte zaman belirleme class'i Duration oldu
    }
    }

