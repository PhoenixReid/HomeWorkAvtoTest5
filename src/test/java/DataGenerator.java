import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private static Faker faker;

    public static String randomcity() {
        String[] administrativeCenters = {"Москва",
                "Санкт-Петербург", "Махачкала", "Симферополь", "Екатеринбург", "Челябинск",
                "Новосибирск", "Красноярск", "Пермь", "Воронеж", "Волгоград", "Ростов-на-Дону", "Уфа", "Краснодар", "Самара", "Казань", "Нижний Новгород", "Омск", "Саратов",
                "Тюмень", "Владивосток", "Хабаровск", "Иркутск", "Ярославль", "Якутск", "Барнаул", "Владикавказ", "Иваново", "Ижевск", "Калининград", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Магадан", "Мурманск",
                "Нижний Тагил", "Новокузнецк", "Новороссийск", "Пенза", "Петрозаводск",
                "Псков", "Рязань", "Саранск", "Смоленск", "Ставрополь", "Тамбов", "Томск",
                "Тула", "Ульяновск", "Чебоксары", "Череповец", "Чита", "Астрахань", "Белгород", "Брянск", "Владимир", "Вологда",
                "Грозный", "Архангельск", "Севастополь", "Ханты-Мансийск", "Южно-Сахалинск", "Петропавловск-Камчатский", "Сыктывкар", "Великий Новгород", "Калуга", "Кировск", "Когалым", "Королев", "Краснокамск", "Краснотурьинск", "Кызыл", "Майкоп", "Мирный", "Надым", "Нарьян-Мар", "Новый Уренгой", "Новый Ургал", "Оренбург",
        };
        return administrativeCenters[new Random().nextInt(administrativeCenters.length)];
    }

    public static String generateDate(int daysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(daysToAdd).format(formatter);
        return date;
    }


    public static String generateName(String locale) {
        faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            return new UserInfo(randomcity(),generateName(locale),generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
