import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmexPage {
    private String inputText = "//*[@class='sc-7b3a4ed6-9 eNuudr']//input";
    private String buttonFind = "//*[@class='sc-7b3a4ed6-0 beguDV e-button e-button--sizeBig e-button--themeBlack']";
    private String firstShop = "//*[@data-testid='MapSearch:text:sideBarItemTitle[0]']";
    private String buttonAddBasket = "//div[@class='sc-6610f28-18 jZDDSd']//span";
    private String buttonBasket = "//div[@class='sc-2f223a1-2 BBpCm']";
    private String textBasketSparePart ="//a[@href='/products/1051859/Ford/17207']";
    private String itemsCatalog ="//div[@class=\"sc-480f8902-2 kkFiSh\"]/div";

    private WebDriver driver;

    public EmexPage(WebDriver driver) {
        this.driver = driver;
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

    public String getTextBasketSparePart(){
        return  driver.findElement(By.xpath(textBasketSparePart)).getText();
    }

    public List<WebElement> setItemCatalog() {
        return driver.findElements(By.xpath(itemsCatalog));
    }
}
