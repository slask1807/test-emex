import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EmexPage;

public class EmexTest extends BasePage {
    @Test
    public void checkSpearPartInBasket() throws InterruptedException {
        EmexPage emexPage = new EmexPage();
        emexPage.seachText();
        emexPage.chooseFirstShop();
        emexPage.addInBasket();
        emexPage.enterBasket();
        Assertions.assertEquals("Ford 1 051 859", emexPage.getTextBasketSparePart());
    }

    @Test
    public void testMenu() {
        EmexPage emexPage = new EmexPage();
        Assertions.assertEquals(emexPage.addExpectedKatalogItems(), emexPage.addElementsKatalogItems());
    }

    @Test
    public void checkEnterWithEmptyPassword() throws InterruptedException {
        EmexPage emexPage = new EmexPage();
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("rgb(255, 0, 0)", emexPage.getPasswordsBordColor());
    }

    @Test
    public void checkEnterWithEmptyLogin() throws InterruptedException {
        EmexPage emexPage = new EmexPage();
        emexPage.clickbuttonSubmitAccount();
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Введите логин", emexPage.getMessengWithEmtyLogin());
    }

    @Test
    public void checkEnterCorrectEmil() throws InterruptedException {
        EmexPage emexPage = new EmexPage();
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();

    }
    @Test
    public void checkEnterNonCorrectEmil() throws InterruptedException {
        EmexPage emexPage = new EmexPage();
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomNonCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Номер телефона, емейл или id введены неверно", emexPage.getMessengWithEmtyLogin());
    }
}
