package by.itacademy.shlesin.ua;

import by.itacademy.shlesin.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmexTest extends BasePage {

    @Test
    public void checkSpearPartInBasket() throws InterruptedException {
        emexPage.seachText("1051859");
        emexPage.chooseFirstShop();
        emexPage.addInBasket();
        emexPage.enterBasket();
        Assertions.assertEquals("Ford 1 051 859", emexPage.getTextBasketSparePart());
    }

    @Test
    public void testMenu() {
        Assertions.assertEquals(emexPage.addExpectedKatalogItems(), emexPage.addElementsKatalogItems());
    }

    @Test
    public void checkEnterWithEmptyPassword() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("rgb(255, 0, 0)", emexPage.getPasswordsBordColor());
    }

    @Test
    public void checkEnterWithEmptyLogin() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Введите логин", emexPage.getMessengWithEmtyLogin());
    }

    @Test
    public void checkEnterCorrectEmail() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();

    }

    @Test
    public void checkEnterNonCorrectEmail() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomNonCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Номер телефона, емейл или id введены неверно", emexPage.getMessengWithEmtyLogin());
    }

    @Test
    public void wordPartnership() throws InterruptedException {
               emexPage.clickButtonContacts();
                Assertions.assertEquals("СОТРУДНИЧЕСТВО",emexPage.getPartnership());
    }
}
