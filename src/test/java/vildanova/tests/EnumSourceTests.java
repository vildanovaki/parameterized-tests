package vildanova.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.*;

public class EnumSourceTests {

    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Check recommendation in menu")
    void checkResultForMenuItems(MenuItem menuItem) {
        open("https://www.litres.ru/");
        $$(".LowerMenu-module__item").find(Condition.text(menuItem.getDesc())).click();
        if (menuItem.getDesc().equals("Новинки")) {
            $(".book_ratings").shouldHave(Condition.text("Новинки книг"));
        }
        if (menuItem.getDesc().equals("Популярное")) {
            $(".book_ratings").shouldHave(Condition.text("Книжные бестселлеры"));
        }
        if (menuItem.getDesc().equals("Аудикниги")) {
            $(".new-container").shouldHave(Condition.text("Что послушать?"));
        } else {
            System.out.println("По данному enum - " + menuItem.getDesc() + "нужно добавить проверку");
        }
    }
}
