package by.itacademy.shlesin.domain;

import com.github.javafaker.Faker;

public class User {
    public static String getRundomNonCorrectEmail() {
        Faker faker = new Faker();
        return faker.name() + "@test";
    }

    public static String getRundomCorrectEmail() {
        Faker faker = new Faker();
        return faker.internet().safeEmailAddress(faker.name().firstName());
    }

    public static String getRundomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
