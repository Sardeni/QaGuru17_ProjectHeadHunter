package com.sardeni;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CianVacancyTests extends TestBase {

    @Test
    @Disabled
    @DisplayName("Названия вакансии, зарплата, опыт")
    public void assertTitleVacanCy() {
        open("https://hh.ru/vacancy/75846595");
        $("[data-qa=vacancy-title]").shouldHave(text("Middle QA Engineer (Web)"));
        $("[data-qa=vacancy-salary]").shouldHave(text("з/п не указана"));
        $("[data-qa=vacancy-experience]").shouldHave(text("3–6 лет"));
    }

    @Test
    @DisplayName("Проверка блока о компании: название, лого")
    public void assertBlockCompany() {


        open("https://hh.ru/vacancy/75846595");
        executeJavaScript("$('[data-qa=bloko-notification]').remove()");

        step("Название компании и ссылка", () -> {
            $("[data-qa=bloko-header-2] span").shouldHave(text("Циан"));
            $("[data-qa=vacancy-company-name]").shouldHave(attribute("href", "https://hh.ru/employer/1429999?hhtmFrom=vacancy"));
        });

        step("Наличие иконки проверки компании и ссылки на раздел", () -> {
            $(".vacancy-company-icon a").shouldHave(attribute("href", "https://feedback.hh.ru/article/details/id/5951"));
        });

        step("Отображение лого компании", () -> {
            $("[data-qa=vacancy-company]").$("a")
                    .shouldHave(attribute("href", "https://hh.ru/employer/1429999?hhtmFrom=vacancy"));
        });
    }


}
