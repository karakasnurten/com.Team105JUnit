package Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {

 static WebDriver driver;

@BeforeClass
    public static void setUp(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    System.out.println("setUp method'u calisti");
}

    @Before
    public  void beforeTest(){
        driver.get("http://www.google.com");
    }

    @Test
    public void test01(){

        driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click();
    driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings" + Keys.ENTER);

        WebElement sonuc1= driver.findElement(By.id("result-starts"));
        System.out.println(sonuc1.getText());

    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart" + Keys.ENTER);

        WebElement sonuc2= driver.findElement(By.id("result-starts"));
        System.out.println(sonuc2.getText());

    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter" + Keys.ENTER);

        WebElement sonuc3= driver.findElement(By.id("resul-starts"));
        System.out.println(sonuc3.getText());

    }
    @AfterClass
    public static void tearDown(){
        driver .close();
        System.out.println("teardown method'u calisti");

    }




}
