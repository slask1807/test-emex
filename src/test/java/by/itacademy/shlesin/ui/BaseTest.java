package by.itacademy.shlesin.ui;

import by.itacademy.shlesin.pages.EmexPage;
import by.itacademy.shlesin.webdriver.SingleWebdriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

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






