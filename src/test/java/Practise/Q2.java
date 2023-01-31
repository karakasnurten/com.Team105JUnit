package Practise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q2 extends TestBase {

    //              ..Exercise2...
    //  http://www.bestbuy.com 'a gidin,


    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin

    //  Ayrica Relative Locator kullanarak;
    //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    //  Ayrica Relative Locator kullanarak;
    //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
    @Before
    public void beforeTest(){
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void titleTest(){
        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin

        String expTitle ="Best";
        String actTitle = driver.getTitle();

        System.out.println(actTitle);
        // Best Buy International: Select your Country - Best Buy

        assertTrue(actTitle.contains(expTitle));

    }

    @Test
    public void logoTest(){
        //  Ayrica Relative Locator kullanarak;
        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloHeading= driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement bestBuyLogo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));


        assertTrue(bestBuyLogo.isDisplayed());

    }
    @Test
    public void mexicoLinkTest(){
        //  Ayrica Relative Locator kullanarak;
        //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        WebElement usFlag = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));

        boolean goruntuluyorMu = mexicoFlag.isDisplayed();

        assertTrue(goruntuluyorMu);
        // yukarda import edip asset'u static olarak import ettik sonuna .* koyarak equals, false ve true icin de tanimladik
       // assertEquals();
       // assertFalse();



    }



}
