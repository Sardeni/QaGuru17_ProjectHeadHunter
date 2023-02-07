package com.sardeni;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class HhVacancyTests extends TestBase {

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Названия вакансии, зарплата, опыт, формат работы, оформление")
    public void checkTitleVacanCy() {

        step("Название вакансии, З/П, опыт", () -> {

            $("[data-qa=vacancy-title]").shouldHave(text("Middle manual QA specialist"));
            $("[data-qa=vacancy-salary]").shouldHave(text("от 120 000 руб. на руки"));
            $("[data-qa=vacancy-experience]").shouldHave(text("3–6 лет"));
            $("[data-qa=vacancy-view-employment-mode]").shouldHave(text("Полная занятость"));
            $("[data-qa=vacancy-view-employment-mode]").$("span").shouldHave(text("удаленная работа"));
            $("[data-qa=vacancy-view-accept-temporary]").shouldHave(text("Возможно временное оформление: договор услуг, подряда, ГПХ, самозанятые, ИП"));

        });
    }

    @Test
    @Tag("regress")
    @DisplayName("Проверка блока о компании: название, лого, иконнка проверки")
    public void checkBlockCompanyData() {

        step("Название компании и ссылка на профиль", () -> {
            $$("span[data-qa=bloko-header-2] span").last().shouldHave(text("Americor Funding Inc"));
            $("[data-qa=vacancy-company-name]").shouldHave(attribute("href", "https://hh.ru/employer/4354272?hhtmFrom=vacancy"));
        });

        step("Наличие иконки проверки компании и ссылки на раздел", () -> {
            $(".vacancy-company-icon a").shouldHave(attribute("href", "https://feedback.hh.ru/article/details/id/5951"));
        });

        step("Отображение лого компании и ссылка на профиль", () -> {
            $("[data-qa=vacancy-company]").$("a")
                    .shouldHave(attribute("href", "https://hh.ru/employer/4354272?hhtmFrom=vacancy"));
        });
    }

    @Test
    @DisplayName("Проверка текста о компании в вакансии")
    public void checkAboutCompanyText() {

        step("Проверяем текст о компании в вакансии", () -> {
            $("[data-qa=vacancy-description]").shouldHave(text("Техническая команда распределена по миру и находится в разных странах и часовых поясах."));
            $("[data-qa=vacancy-description]").shouldHave(text("Команда QA активно работает над улучшением процесса разработки и ускорением доставки задач на прод."));
            $("[data-qa=vacancy-description]").shouldHave(text("Головной офис компании находится в USA, California, Irvine."));
        });
    }

    @Test
    @DisplayName("Проверка ключевых навыков в вакансии")
    public void checkKeySkills() {

        step("Проверяем заголовок", () -> {
            $$("h2[data-qa=bloko-header-2]").first().shouldHave(text("Ключевые навыки"));
        });
        step("Текст первого элемента в списке", () -> {
            $$("span[data-qa=bloko-tag__text]").first().shouldHave(text("SQL"));
        });
    }

    @Test
    @DisplayName("Блок с вопросами о компании")
    public void checkQuestionsAboutCompany() {

        step("Проверяем заголовок", () -> {
            $$("h2[data-qa=bloko-header-1]").first().shouldHave(text("Задайте вопрос работодателю"));
        });
        step("Текст первого вопроса в списке", () -> {
            $$("a.bloko-chips-chip-link").first().shouldHave(text("Где располагается место работы?"));
        });
    }

    @Test
    @DisplayName("Блок с отзывами о компании")
    public void checkReviewsAboutCompany() {

        step("Проверяем заголовок", () -> {
            $("h1[data-qa=bloko-header-1]").shouldHave(text("Отзывы о компании"));
        });
        step("Текст блока отзывов", () -> {
            $("div.chgqU1p___summary-no-reviews").shouldHave(text("Здесь пока нет отзывов, но ваш может стать первым"));
        });
    }

}