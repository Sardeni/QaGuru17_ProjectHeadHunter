package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacancyPage {

    public SelenideElement
            vacancyTitle = $("[data-qa=vacancy-title]"),
            vacancySalary = $("[data-qa=vacancy-salary]"),
            vacancyExperience = $("[data-qa=vacancy-experience]"),
            vacancyEmploymentMode = $("[data-qa=vacancy-view-employment-mode]"),
            vacancyAcceptTemporary = $("[data-qa=vacancy-view-accept-temporary]"),
            companyNameText = $$("span[data-qa=bloko-header-2] span").last(),
            companyName = $$("[data-qa=vacancy-company-name]").last(),
            verifiedCompanyIcon = $(".vacancy-company-icon a"),
            companyLogo = $("[data-qa=vacancy-company]").$("a"),
            vacancyDescription = $("[data-qa=vacancy-description]"),
            keySkillsHeader = $$("h2[data-qa=bloko-header-2]").first(),
            keySkillsBlockValues = $("div.bloko-tag-list"),
            questionsToEmployerHeader = $$("h2[data-qa=bloko-header-1]").first(),
            questionsToEmployerBlock = $("p.bloko-chips-multiline-container"),
            reviewsAboutCompanyHeader = $("h1[data-qa=bloko-header-1]"),
            reviewsAboutCompanyEmpty = $("div.chgqU1p___summary-no-reviews");

    public VacancyPage checkElementText(SelenideElement element, String text) {
        element.shouldHave(text(text));
        return this;
    }

    public VacancyPage checkElementAttribute(SelenideElement element, String attirbuteType, String attirbuteValue) {
        element.shouldHave(attribute(attirbuteType, attirbuteValue));
        return this;
    }
}