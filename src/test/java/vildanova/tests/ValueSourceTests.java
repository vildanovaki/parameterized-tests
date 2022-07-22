package vildanova.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValueSourceTests {

    @ValueSource(strings = {
            "Анна Каренина",
            "Война и мир",
            "Отцы и дети"
    })
    @ParameterizedTest(name = "Check search results")
    void checkSearchResult(String search) {
        open("https://www.litres.ru/");
        $(".Search-module__input").setValue(search);
        $(".Search-module__button").click();
        $(".result_container").shouldHave(Condition.text(search));
        System.out.println(search);
    }
}
