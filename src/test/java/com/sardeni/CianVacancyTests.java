package com.sardeni;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CianVacancyTests extends TestBase {

    @Test
    @DisplayName("Проверка названия вакансии и поля зарплаты")
   public void assertTitleVacanCy() {
            $("[data-qa=vacancy-title]").shouldHave(Condition.text("Middle QA Engineer (Web)"));
            $("[data-qa=vacancy-salary]").shouldHave(Condition.text("з/п не указана"));
   }

    @Test
    @DisplayName("Проверка блока о компании: название, лого, блок ТОП-20")
   public void assertBlockCompany() {

        step("Название компании и ссылка", () -> {

            $("[data-qa=vacancy-company-name] -> span").shouldHave(Condition.text("Циан"))
                    .shouldHave(Condition.attribute("href", "/employer/1429999?hhtmFrom=vacancy"));
        }  );

        step("Наличие иконки проверки компании и ссылки на раздел", () -> {

            $(".vacancy-company-icon a").shouldBe(Condition.visible)
                    .shouldHave(Condition.attribute("href", "https://feedback.hh.ru/article/details/id/5951"));
        }  );

        step("Отображение блока ТОП-20", () -> {

            $("[data-qa=employer-card-rating employer-card-rating_position-11 employer-card-rating_with-url]").shouldBe(Condition.visible)
                    .shouldHave(Condition.attribute("href", "https://rating.hh.ru/history/rating2022"));
        }  );

        step("Отображение лого компании", () -> {

            $("[data-qa=vacancy-company]").$("a").shouldBe(Condition.visible)
                    .shouldHave(Condition.attribute("href", "/employer/1429999?hhtmFrom=vacancy"));
        }  );
   }





}
