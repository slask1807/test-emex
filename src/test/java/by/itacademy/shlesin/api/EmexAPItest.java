package by.itacademy.shlesin.api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EmexAPItest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testLoginWithInvalidCreations() {
        String requestBody = "{\"login\":\"+79878342494\",\"password\":\"43434\",\"t\":1703008689457}";
        given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when()
                .post("https://emex.ru/api/account/login")
                .then()
                .log().all()
                .statusCode(500);
        logger.info("Test passed \n");
    }

    @Test
    public void testWithOutILogin() {
        String requestBody = "{\"login\":,\"password\":\"43434\",\"t\":1703008689457}";
        given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when()
                .post("https://emex.ru/api/account/login")
                .then()
                .log().all()
                .statusCode(400);
        logger.info("Test passed \n");
    }
}

