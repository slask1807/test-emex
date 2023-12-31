package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.SingleWebdriver;

import java.util.ArrayList;
import java.util.List;

public class EmexPage {
    private String inputText = "//*[@class='sc-7b3a4ed6-9 eNuudr']//input";
    private String buttonFind = "//*[@class='sc-7b3a4ed6-0 beguDV e-button e-button--sizeBig e-button--themeBlack']";
    private String firstShop = "//*[@data-testid='MapSearch:text:sideBarItemTitle[0]']";
    private String buttonAddBasket = "//div[@class='sc-6610f28-18 jZDDSd']//span";
    private String buttonBasket = "//div[@class='sc-2f223a1-2 BBpCm']";
    private String textBasketSparePart = "//a[@href='/products/1051859/Ford/17207']";
    private String itemsCatalog = "//div[@class=\"sc-480f8902-2 kkFiSh\"]/div";
    private String buttonSubmitAccount = "//a[@data-testid='Header:button:loginButton']";
    private String buttonEnter = "//div[@class= 'sc-dac0c06d-1 flqRoP']";
    private String inputLogin = "//input[@placeholder= 'Телефон, почта или id']";
    private String inputPassword = "//input[@id='signInPasswordInput']";
   // private String messengWithEmtyLogin = "//*[contains(text(), 'Введите логин')]";
    private String messengWithEmtyLogin = "//*[@class=\"e-message e-message--isError\"]";
    private String inputPasswords = "//*[@id=\"signInPasswordInput\"]";


    private WebDriver driver;

    public EmexPage() {
        this.driver = SingleWebdriver.getDriver();
    }

    public void seachText() throws InterruptedException {
        driver.findElement(By.xpath(inputText)).sendKeys("1051859");
        driver.findElement(By.xpath(buttonFind)).click();
        Thread.sleep(6000);
    }

    public void chooseFirstShop() throws InterruptedException {
        driver.findElement(By.xpath(firstShop)).click();
        Thread.sleep(3000);
    }

    public void addInBasket() {
        driver.findElement(By.xpath(buttonAddBasket)).click();
    }

    public void enterBasket() throws InterruptedException {
        driver.findElement(By.xpath(buttonBasket)).click();
        Thread.sleep(3000);
    }

    public String getTextBasketSparePart() {
        return driver.findElement(By.xpath(textBasketSparePart)).getText();
    }

    public List<WebElement> setItemCatalog() {
        return driver.findElements(By.xpath(itemsCatalog));
    }

    public void clickbuttonSubmitAccount() throws InterruptedException {
        driver.findElement(By.xpath(buttonSubmitAccount)).click();
        Thread.sleep(3000);
    }

    public void setInputLogin(String login) {
        driver.findElement(By.xpath(inputLogin)).sendKeys(login);
    }

    public void setInputPassword(String inputPassword) {
        driver.findElement(By.xpath(inputPasswords)).sendKeys(inputPassword);
    }

    public void clickButtonEnter() {
        driver.findElement(By.xpath(buttonEnter)).click();
    }

    public String getPasswordsBordColor() {
        return driver.findElement(By.xpath(inputPassword)).getCssValue("border-color");
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
        return driver.findElement(By.xpath(messengWithEmtyLogin)).getText();
    }
}
