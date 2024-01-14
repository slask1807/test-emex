package by.itacademy.shlesin.ua;

import by.itacademy.shlesin.webdriver.SingleWebdriver;
import org.junit.jupiter.api.AfterEach;

public class BasePage {
//   WebDriver driver;
//
////    @BeforeEach
////   public void baseStart() {
//////        driver = new ChromeDriver();
////        MyDriver.getDriver().manage().window().maximize();
//// }

    @AfterEach
    public void baseFinish() {
       SingleWebdriver.getDriver().quit();
    }

}






