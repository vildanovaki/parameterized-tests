package vildanova.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MethodSourceTests {

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void negativeAuthForGitHubWithMethodSource(String login, int password) {
        {
            open("https://github.com/login");
            $("#login_field").setValue(login);
            $("#password").setValue(String.valueOf(password));
            $("[value='Sign in']").click();
            $("#js-flash-container").shouldHave(Condition.text("Incorrect username or password."));
        }
    }

    static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of(
                        "ivanovao", 123
                ),
                Arguments.of(
                        "simanovaa", 123
                )
        );
    }
}


