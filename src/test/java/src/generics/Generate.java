package src.generics;

import com.github.javafaker.Faker;

public class Generate {
    static private final Faker faker = new Faker();
    ;

    public static int id() {
        String id = faker.number().digit();
        return Integer.parseInt(id);
    }

    public static String title() {
        return faker.harryPotter().character();
    }

    public static String body() {
        return faker.harryPotter().quote();
    }
}
