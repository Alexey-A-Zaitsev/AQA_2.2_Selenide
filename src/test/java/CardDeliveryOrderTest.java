import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryOrderTest {

    private String generationDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldSuccessfullySubmitTheForm() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeADoubleName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Иванова Ева Оливия");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldAcceptAHyphenatedName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Иванова Анна-Мария");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeTheNameInLowerCase() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("сидоров михаил");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeTheNameInUpperCase() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("СИДОРОВ МИХАИЛ");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeANameWithSymbolYo() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Фёдоров Пётр");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeAShortName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Ин Ян");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeALongName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Абдурахмангаджи КОНСТАНТИНОПОЛЬСКИЙ");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTrimSpacesInTheNameField() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("    Петров     Василий    ");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }


    @Test
    public void shouldTakeTheCityInLowerCase() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Сидоров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeTheCityInUpperCase() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("МАЙКОП");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Сидоров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeTwoWordCityName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Нижний Новгород");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Сидоров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeCityNameWithAHyphen() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Ростов-На-Дону");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Сидоров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTrimSpacesInTheCityField() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("      Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Василий");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }


    // Негативные тесты

    @Test
    public void invalidCity() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Лабинск");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Василий");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = city] .input__sub").shouldHave(text("Доставка в выбранный город недоступна"));
    }

    @Test
    public void shouldNotFillInTheCityField() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Василий");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = city] .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }


    @Test
    public void invalidDataEntryInTheNameField1() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Ivanov Ivan");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = name] .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void invalidDataEntryInTheNameField2() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("123456789 87654");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = name] .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void invalidDataEntryInTheNameField3() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий$$$");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = name] .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldNotFillInTheNameField() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = name] .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void invalidDataEntryInThePhoneField1() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("восемьвосемьсот");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void invalidDataEntryInThePhoneField2() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("89881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void invalidDataEntryInThePhoneField3() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("+12345678912345678");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void invalidDataEntryInThePhoneField4() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("++7988123456");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void invalidDataEntryInThePhoneField5() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("+7988One23456");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void invalidDataEntryInThePhoneField6() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("+7988123456");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(" [data-test-id = phone] .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldNotFillInThePhoneField() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Кузнецов Юрий");
        $("[data-test-id = phone] input").setValue("");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $("[data-test-id = phone] .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldNotSubmitFormWithoutCheckbox() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Ин Ян");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("button.button").click();
        $("[data-test-id = agreement].input_invalid").shouldHave(text("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
    }


    // Граничные значения поля ДАТА
    @Test
    public void shouldNotTakeTodayDate() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(0, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Ин Ян");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("button.button").click();
        $("[data-test-id = date] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void shouldNotTakeAfterTomorrowDate() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(2, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Ин Ян");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("button.button").click();
        $("[data-test-id = date] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void shouldTakeIn3Days() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(3, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }

    @Test
    public void shouldTakeIn4Days() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Краснодар");
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }



    //Задание 2
    @Test
    public void shouldShowCityName() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Кр");
        $x("//span[contains(text(), 'Краснодар')]").click();
        String Date = generationDate(4, "dd.MM.YYYY");
        $("[data-test-id = date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id = date] input").sendKeys(Date);
        $("[data-test-id = name] input").setValue("Сидоров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + Date));
    }


    @Test
    public void shouldShowTheDateInAWeek() {
        //Configuration.holdBrowserOpen = true;
        //String todayDate = generationDate(0, "MM.YYYY"); // текущая дата
        //String dateInAWeek = generationDate(7,"MM.YYYY"); // дата через неделю
        int defaultDate = 3; // минимально возможная дата для заказа
        int daysToAdd = 7; // выбор даты на неделю вперёд
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Кр");
        $x("//span[contains(text(), 'Красноярск')]").click();
        $("[data-test-id = date] input").click();
        if(!(generationDate(defaultDate, "YYYY")).equals(generationDate(daysToAdd, "YYYY"))) {
            $("[data-step = '12']").click();
        }
        int resultMonth = (generationDate(defaultDate, "MM").compareTo(generationDate(daysToAdd, "MM")));
        if(resultMonth > 0) {
            $("[data-step = '-1']").click();
        } else if (resultMonth < 0) {
            $("[data-step = '1']").click();
        }        $$(".calendar__day").findBy(text(generationDate(daysToAdd, "d"))).click();
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + generationDate(daysToAdd, "dd.MM.YYYY")));
    }

    @Test
    public void shouldShowTheDateInAMonth() {
        //Configuration.holdBrowserOpen = true;
        int defaultDate = 3; // минимально возможная дата для заказа
        int daysToAdd = 31; // выбор даты на неделю вперёд
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Кр");
        $x("//span[contains(text(), 'Красноярск')]").click();
        $("[data-test-id = date] input").click();
        if(!(generationDate(defaultDate, "YYYY")).equals(generationDate(daysToAdd, "YYYY"))) {
            $("[data-step = '12']").click();
        }
        int resultMonth = (generationDate(defaultDate, "MM").compareTo(generationDate(daysToAdd, "MM")));
        if(resultMonth > 0) {
            $("[data-step = '-1']").click();
        } else if (resultMonth < 0) {
            $("[data-step = '1']").click();
        }        $$(".calendar__day").findBy(text(generationDate(daysToAdd, "d"))).click();
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + generationDate(daysToAdd, "dd.MM.YYYY")));
    }

    @Test
    public void shouldShowTheDateInAYear() {
        //Configuration.holdBrowserOpen = true;
        int defaultDate = 3; // минимально возможная дата для заказа
        int daysToAdd = 366; // выбор даты на неделю вперёд
        open("http://localhost:9999/");
        $("[data-test-id = city] input").setValue("Кр");
        $x("//span[contains(text(), 'Красноярск')]").click();
        $("[data-test-id = date] input").click();
        if(!(generationDate(defaultDate, "YYYY")).equals(generationDate(daysToAdd, "YYYY"))) {
            $("[data-step = '12']").click();
        }
        int resultMonth = (generationDate(defaultDate, "MM").compareTo(generationDate(daysToAdd, "MM")));
        if(resultMonth > 0) {
            $("[data-step = '-1']").click();
        } else if (resultMonth < 0) {
            $("[data-step = '1']").click();
        }
        $$(".calendar__day").findBy(text(generationDate(daysToAdd, "d"))).click();
        $("[data-test-id = name] input").setValue("Петров Иван");
        $("[data-test-id = phone] input").setValue("+79881234567");
        $("[data-test-id = agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + generationDate(daysToAdd, "dd.MM.YYYY")));
    }

}