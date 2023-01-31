package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 calisti");
        // @Test notasyonu sdayesinde herbir tast method'u bagimsiz olarak calisabilir
        // eger testin icinde bir assertion yoksa
        // kod problem yasanmadan calisip bittiginde
        // JUnit test passed olarak raporlar

    }
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
        //@Ignore notasyonu yazidigi test method'unun calistirilmamasini saglar

    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }

}
