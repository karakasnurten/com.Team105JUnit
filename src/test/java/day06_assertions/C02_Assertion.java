package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
    jUnit framework'u calistirilan testlerin pass yada failed olmasini raporlar
    Ancak raporlamanin dogru sonuc vermesi icin
    Test'lerin Assert class'indaki hazir method'larla yapilmasi gerekir

    Eger Assert class'i kullanilmazsa
    JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
    C01 'DE testleri if-else ile yaptigimiz icin
    Testler failed olsa da kodlar sorunsuz calistigi icin
    testler yesil tik olarak isaretlendi

     */
    int P1yas=60;
    int P2yas=66;
    int P3yas=70;

    @Test
    public void test01(){
        // emekli 65 olduguna gore
        // P2yas nin emekli olabilecegini test edin
        Assert.assertTrue(P2yas>65);

    }
    @Test
    public void test02(){
        // emekli 65 olduguna gore
        // P1yas nin emekli olabilecegini test edin
        Assert.assertFalse(P1yas>65);

    }
    @Test
    public void test03(){
        // emekli 65 olduguna gore
        // P3yas nin emekli olabilecegini test edin
        Assert.assertFalse("Girilen yas 65'den kıucuk olmadigindan emekli olabilir",P3yas>65);



    }
}
