package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JSExecutor extends TestBase {

    @Test
    public void test01(){

        // amazon sayfasina gidin
        driver.get("https://www.amazzon.com");

        // sell linkini JS executer kullanarak click yapin

        WebElement sellLinki = driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()",sellLinki);

        jse.executeScript("alert('Bu is bu kadar')");

        ReusableMethods.bekle(5);



    }
}
