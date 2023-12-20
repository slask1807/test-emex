import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        List<WebElement> itemList = emexPage.setItemCatalog();
        List<String> catalogItemList = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i).getText());
            catalogItemList.add(itemList.get(i).getText());
        }
        List<String> expectedKatalogItems = new ArrayList<>();
        expectedKatalogItems.add("Часто покупают");
        expectedKatalogItems.add("Запчасти из-за границы");
        expectedKatalogItems.add("Автотовары");
        expectedKatalogItems.add("Инструменты для СТО");
        expectedKatalogItems.add("Для грузового транспорта");
        Assertions.assertEquals(expectedKatalogItems, catalogItemList);
    }
}
