package tests.day15_SoftAssert;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegativeLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){
        ReusableMethods.bekle(3);
        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // cookies i kabul edin
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("AA12345zz.");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
       Driver.closeDriver();
    }


    @Test
    public void yanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage= new QualitydemyPage();
         // cookies i kabul edin
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("rataxa8964@vingood.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }


    @Test
    public void yanlisEmailYanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage= new QualitydemyPage();
        // cookies i kabul edin
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
       Driver.closeDriver();
    }
}