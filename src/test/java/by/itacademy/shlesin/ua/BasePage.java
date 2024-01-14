package by.itacademy.shlesin.ua;

import by.itacademy.shlesin.pages.EmexPage;
import by.itacademy.shlesin.webdriver.SingleWebdriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BasePage {
//   WebDriver driver;
//
////    @BeforeEach
////   public void baseStart() {
//////        driver = new ChromeDriver();
////        MyDriver.getDriver().manage().window().maximize();
//// }
EmexPage emexPage;
@BeforeEach
public void testStart() {
    emexPage = new EmexPage();
   }


    @AfterEach
    public void baseFinish() {
       SingleWebdriver.quitDriver();
    }

}






