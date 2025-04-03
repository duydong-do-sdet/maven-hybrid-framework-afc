package dataConfig;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerConfig {
    private Faker faker;

    public DataFakerConfig(String locale) {
        switch (locale.toLowerCase()) {
            case "us":
                faker = new Faker(Locale.US);
                break;
            case "uk":
                faker = new Faker(Locale.UK);
                break;
            case "japan":
                faker = new Faker(Locale.JAPAN);
                break;
            case "korea":
                faker = new Faker(Locale.KOREA);
                break;
            case "china":
                faker = new Faker(Locale.CHINA);
                break;
            default:
                throw new RuntimeException("Invalid locale " + locale);
        }
    }

    public String fakeFirstName() {
        return faker.name().firstName();
    }

    public String fakeLastName() {
        return faker.name().lastName();
    }

    public String fakeEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String fakePassword() {
        return faker.internet().password();
    }

}
