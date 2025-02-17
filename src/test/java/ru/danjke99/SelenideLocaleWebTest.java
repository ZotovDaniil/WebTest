package ru.danjke99;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.danjke99.data.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideLocaleWebTest {

    static Stream<Arguments> siteShouldContainsAllOfGivenButtonsForGivenLocale(){
        return Stream.of(
                Arguments.of(ru.danjke99.data.Locale.Ru, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of(ru.danjke99.data.Locale.En, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
        );
    }
    @MethodSource



    @ParameterizedTest(name ="Для локали {0} на сайте https://selenide.org/ должен отображаться список кнопок {1}")

    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })

    void siteShouldContainsAllOfGivenButtonsForGivenLocale (Locale locale, List <String> expectedButtons){
Selenide.open("https://selenide.org/");
$$("#languages a").find(text(locale.name())).click();
$$(".main-menu-pages a").filter(visible).shouldHave(texts(expectedButtons));


    }







}
