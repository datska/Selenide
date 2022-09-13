package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    @BeforeEach
    public void setForm() {
        Configuration.headless = true;
        open("http://localhost:9999/");
        SelenideElement form = $("form");
    }

    @Test
    void shouldSendFormPopularCity() {
        $("[data-test-id=city] input").setValue("Владимир");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormDoubleCity() {
        $("[data-test-id=city] input").setValue("Великий Новгород");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithDash() {
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithDoubleDash() {
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithYo() {
        $("[data-test-id=city] input").setValue("Орёл");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFromTenDays() {
        $("[data-test-id=city] input").setValue("Иркутск");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(10, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(10, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendInNextYear() {
        $("[data-test-id=city] input").setValue("Рязань");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(180, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(180, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormDoubleName() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна Мария Попова");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithDash() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна-Мария Попова");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithDoubleName() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна Мария Попова");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithYo() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Пётр Попов");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }



    @Test
    void shouldSendFormNameWithDoubleSurname() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Петр Попов Вайс");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameAndSurname() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Слава");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormSurnameWithYo() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Пeтр Сычёв");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }


}

