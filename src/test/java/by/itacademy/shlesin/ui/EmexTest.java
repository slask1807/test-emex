package by.itacademy.shlesin.ui;

import by.itacademy.shlesin.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class EmexTest extends BaseTest {

    @Test
    @DisplayName("Поиск по номеру запчасти, добавление в корзину, проверка содержимого корзины ")
    public void checkSpearPartInBasket() throws InterruptedException {
        emexPage.seachText("1051859");
        emexPage.chooseFirstShop();
        emexPage.addInBasket();
        emexPage.enterBasket();
        Assertions.assertEquals("Ford 1 051 859", emexPage.getTextBasketSparePart());
    }

    @Test
    @DisplayName("Провека каталога товаров")
    public void testMenu() {
        Assertions.assertEquals(emexPage.addExpectedKatalogItems(), emexPage.addElementsKatalogItems());
    }

    @Test
    @DisplayName("Проверка входа в личный кабинет без пароля")
    public void checkEnterWithEmptyPassword() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("rgb(255, 0, 0)", emexPage.getPasswordsBordColor());
    }

    @Test
    @DisplayName("Проверка входа вличный кабинет без логина")
    public void checkEnterWithEmptyLogin() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Введите логин", emexPage.getMessengWithEmtyLogin());
    }

    @Test
    @DisplayName("Проверка входа в личный кабинет с валидным логиным и паролем")
    public void checkEnterCorrectEmail() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Неверный логин или пароль", emexPage.getMessengWithCorrectLoginAndEmail());
    }

    @Test
    @DisplayName("Проверка входа вличный кабинет с невалидным логином и паролем")
    public void checkEnterNonCorrectEmail() throws InterruptedException {
        emexPage.clickbuttonSubmitAccount();
        emexPage.setInputLogin(User.getRundomNonCorrectEmail());
        emexPage.setInputPassword(User.getRundomPassword());
        emexPage.clickButtonEnter();
        Assertions.assertEquals("Номер телефона, емейл или id введены неверно", emexPage.getMessengWithEmtyLogin());
    }

    @Test
    @DisplayName("Проверка отображения выражения на главной странице")
    public void wordPartnership() throws InterruptedException {
        emexPage.clickButtonContacts();
        Assertions.assertEquals("СОТРУДНИЧЕСТВО", emexPage.getPartnership());
    }
}
мсч