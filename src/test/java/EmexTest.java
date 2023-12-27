import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmexTest extends BasePage {
    @Test
    public void checkSpearPartInBasket() throws InterruptedException {
        EmexPage emexPage = new EmexPage(driver);
        driver.navigate().to("https://emex.ru/");
        emexPage.seachText();
        emexPage.chooseFirstShop();
        emexPage.addInBasket();
        emexPage.enterBasket();
        Assertions.assertEquals("Ford 1 051 859", emexPage.getTextBasketSparePart());
    }

    @Test
    public void testMenu() {
        EmexPage emexPage = new EmexPage(driver);
        driver.navigate().to("https://emex.ru/");
        Assertions.assertEquals(emexPage.addExpectedKatalogItems(), emexPage.addElementsKatalogItems());
    }

    @Test
    public void checkEnterWithEmptyPassword() throws InterruptedException {
        EmexPage emexPage = new EmexPage(driver);
        driver.navigate().to("https://emex.ru/");
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin();
        emexPage.clickButtonEnter();
        Assertions.assertEquals("rgb(255, 0, 0)", emexPage.getPasswordsBordColor());
    }
}
