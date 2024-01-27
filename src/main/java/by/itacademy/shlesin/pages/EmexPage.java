package by.itacademy.shlesin.pages;

import by.itacademy.shlesin.webdriver.SingleWebdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EmexPage {

    private WebDriver driver;

    public EmexPage() {
        this.driver = SingleWebdriver.getDriver();
    }

    public static String getUrl() {
        return EmexPageLocators.URL;
    }

    public EmexPage seachText(String numberSpearPart) throws InterruptedException {
        driver.findElement(By.xpath(EmexPageLocators.INPUT_TEXT)).sendKeys(numberSpearPart);
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_FIND)).click();
        Thread.sleep(6000);
        return this;
    }

    public void chooseFirstShop() throws InterruptedException {
        driver.findElement(By.xpath(EmexPageLocators.FIRST_SHOP)).click();
        Thread.sleep(3000);
    }

    public void addInBasket() {
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_ADD_BUSKET)).click();
    }

    public void enterBasket() throws InterruptedException {
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_BASKET)).click();
        Thread.sleep(3000);
    }

    public String getTextBasketSparePart() {
        return driver.findElement(By.xpath(EmexPageLocators.TEXT_BASKET_SPEAPARTS)).getText();
    }

    public List<WebElement> setItemCatalog() {
        return driver.findElements(By.xpath(EmexPageLocators.ITEM_CATALOG));
    }

    public void clickbuttonSubmitAccount() throws InterruptedException {
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_SUBMIT_ACCOUNT)).click();
        Thread.sleep(3000);
    }

    public void setInputLogin(String login) {
        driver.findElement(By.xpath(EmexPageLocators.INPUT_LOGIN)).sendKeys(login);
    }

    public void setInputPassword(String inputPassword) {
        driver.findElement(By.xpath(EmexPageLocators.INPUT_PASSWORDS)).sendKeys(inputPassword);
    }

    public void clickButtonEnter() {
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_ENTER)).click();
    }

    public String getPasswordsBordColor() {
        return driver.findElement(By.xpath(EmexPageLocators.INPUT_PASSWORD)).getCssValue("border-color");
    }

    public List<String> addElementsKatalogItems() {
        List<WebElement> itemList = setItemCatalog();
        List<String> catalogItemList = new ArrayList<>();
        for (WebElement itemlist : itemList) {
            catalogItemList.add(itemlist.getText());
            System.out.println(itemlist.getText());
        }
        return catalogItemList;
    }

    public List<String> addExpectedKatalogItems() {
        List<String> expectedKatalogItems = new ArrayList<>();
        expectedKatalogItems.add("Часто покупают");
        expectedKatalogItems.add("Запчасти из-за границы");
        expectedKatalogItems.add("Автотовары");
        expectedKatalogItems.add("Инструменты для СТО");
        expectedKatalogItems.add("Для грузового транспорта");
        return expectedKatalogItems;
    }

    public String getMessengWithEmtyLogin() {
        return driver.findElement(By.xpath(EmexPageLocators.MESSENG_WITH_EMTYLOGIN)).getText();
    }

    public EmexPage clickButtonContacts() throws InterruptedException {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(2000);
        driver.findElement(By.xpath(EmexPageLocators.BUTTON_CONTATS)).click();
        return this;
    }

    public String getPartnership() {
        return driver.findElement(By.xpath(EmexPageLocators.PARTNER_SHIP)).getText();
    }
}
