package vildanova.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CsvSourceTests {

    @CsvSource({
            "ivanovao, 123",
            "simanovaa, 123",
            "efremovaa, 123",
    })
    @ParameterizedTest
    void negativeAuthForGitHubWithCsvSource(String login, String password) {
        open("https://github.com/login");
        $("#login_field").setValue(login);
        $("#password").setValue(password);
        $("[value='Sign in']").click();
        $("#js-flash-container").shouldHave(Condition.text("Incorrect username or password."));
    }
}
