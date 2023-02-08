package com.sardeni;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class HeadHunterVacancyTests extends TestBase {
    String vacancyTitleText = "Middle manual QA specialist",
            vacancySalaryText = "от 120 000 руб. на руки",
            vacancyExperienceText = "3–6 лет",
            vacancyEmploymentModeText = "Полная занятость, удаленная работа",
            vacancyAcceptTemporaryText = "Возможно временное оформление: договор услуг, подряда, ГПХ, самозанятые, ИП",
            companyNameText = "Americor Funding Inc",
            companyLinkPage = "https://hh.ru/employer/4354272?hhtmFrom=vacancy",
            verifiedCompaniesArticleLink = "https://feedback.hh.ru/article/details/id/5951",
            vacancyDescriptionText = "Техническая команда распределена по миру и находится в разных странах и часовых поясах.",
            vacancyDescriptionTextSecond = "Головной офис компании находится в USA, California, Irvine.",
            keySkillsHeaderText = "Ключевые навыки",
            questionsToEmployerText = "Задайте вопрос работодателю",
            whereIsTheOfficeQuestion = "Где располагается место работы?",
            reviewsAboutCompanyHeaderText = "Отзывы о компании",
            reviewsAboutCompanyEmptyText = "Здесь пока нет отзывов, но ваш может стать первым";


    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Названия вакансии, зарплата, опыт, формат работы, оформление")
    public void titleVacancyTest() {

        step("Название вакансии, З/П, опыт", () -> {
            vacancyPage.checkElementText(vacancyPage.vacancyTitle, vacancyTitleText);
            vacancyPage.checkElementText(vacancyPage.vacancySalary, vacancySalaryText);
            vacancyPage.checkElementText(vacancyPage.vacancyExperience, vacancyExperienceText);
            vacancyPage.checkElementText(vacancyPage.vacancyEmploymentMode, vacancyEmploymentModeText);
            vacancyPage.checkElementText(vacancyPage.vacancyAcceptTemporary, vacancyAcceptTemporaryText);
        });
    }

    @Test
    @Tag("regress")
    @DisplayName("Проверка блока о компании: название, лого, иконка проверки")
    public void blockCompanyDataTest() {

        step("Название компании и ссылка на профиль", () -> {
            vacancyPage.checkElementText(vacancyPage.companyNameText, companyNameText);
            vacancyPage.checkElementAttribute(vacancyPage.companyName, "href", companyLinkPage);
        });
        step("Наличие иконки проверки компании и ссылки на раздел", () -> {
            vacancyPage.checkElementAttribute(vacancyPage.verifiedCompanyIcon, "href", verifiedCompaniesArticleLink);
        });
        step("Отображение лого компании и ссылка на профиль", () -> {
            vacancyPage.checkElementAttribute(vacancyPage.companyLogo, "href", companyLinkPage);
        });
    }

    @Test
    @DisplayName("Проверка текста о компании в вакансии")
    public void textAboutCompanyTest() {

        step("Проверяем текст о компании в вакансии", () -> {
            vacancyPage.checkElementText(vacancyPage.vacancyDescription, vacancyDescriptionText);
            vacancyPage.checkElementText(vacancyPage.vacancyDescription, vacancyDescriptionTextSecond);
        });
    }

    @Test
    @DisplayName("Проверка ключевых навыков в вакансии")
    public void keySkillsTest() {

        step("Проверяем заголовок", () -> {
            vacancyPage.checkElementText(vacancyPage.keySkillsHeader, keySkillsHeaderText);
        });
        step("Текст первого элемента в списке", () -> {
            vacancyPage.checkElementText(vacancyPage.keySkillsBlockValues, "Postman");
        });
    }

    @Test
    @DisplayName("Блок с вопросами о компании")
    public void questionsAboutCompanyTest() {

        step("Проверяем заголовок", () -> {
            vacancyPage.checkElementText(vacancyPage.questionsToEmployerHeader, questionsToEmployerText);
        });
        step("Наличие вопроса в списке", () -> {
            vacancyPage.checkElementText(vacancyPage.questionsToEmployerBlock, whereIsTheOfficeQuestion);
        });
    }

    @Test
    @DisplayName("Блок с отзывами о компании")
    public void reviewsAboutCompanyTest() {
        step("Проверяем заголовок", () -> {
            vacancyPage.checkElementText(vacancyPage.reviewsAboutCompanyHeader, reviewsAboutCompanyHeaderText);
        });
        step("Текст пустого блока отзывов", () -> {
            vacancyPage.checkElementText(vacancyPage.reviewsAboutCompanyEmpty, reviewsAboutCompanyEmptyText);
        });
    }
}