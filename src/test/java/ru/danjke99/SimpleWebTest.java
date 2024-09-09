package ru.danjke99;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SimpleWebTest {

    @BeforeEach
    void setup(){
        Selenide.open("http://ya.ru");
    }

    @ValueSource(strings={
"Selenide", "Allure"
    })
    @ParameterizedTest(name ="В поиcковой выдаче Яндекса должно отображаться 10 результатов по запросу {0}")

    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    }

    )
void searchResultsShouldBeGreaterThan10 (String testData){

        $("#text").setValue(testData);
        $("button[type='submit']" ).click();
        $$("li.serp-item").shouldHave(sizeGreaterThanOrEqual(10));
    }



@CsvSource(value = {
        "Selenide, лаконичные и стабильные UI тесты на Java",
        "Allure framework, Open-source HTML test automation report tool"
}

)
    @ParameterizedTest(name ="В первом результате выдачи для {0}, должен отображаться {1}")

    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })

    void firstResultsShouldContainExpectedText (String testData, String expectedText){

        $("#text").setValue(testData);
        $("button[type='submit']" ).click();
        $$("li.serp-item").first().shouldHave(Condition.text(expectedText));
    }







}
