package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("zhanna_senchenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Мой тест")
    @Feature("Repository Issue")
    @Story("Should see issue in repository")
    @Link(value = "Тest", url = "https://github.com")
    public void testAnnotated(){

    }
}
