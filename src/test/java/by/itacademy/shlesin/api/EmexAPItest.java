package by.itacademy.shlesin.api;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EmexAPItest {
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
    }
}

