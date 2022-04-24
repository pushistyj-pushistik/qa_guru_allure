package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    public static final String REPOSITORY = "pushistyj-pushistik/LittleRockStar";
    public static final String ISSUE_NAME = "Some ssues";
    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу ", () -> {
                    open("https://github.com");
                });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на Issues ", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует с номером " + ISSUE_NAME, () -> {
            $(withText(ISSUE_NAME)).should(Condition.visible);
        });
    }

}

