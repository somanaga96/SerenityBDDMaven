package utils;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.automationexercise.LoginForm;

public class Message {
    public static Question<String> logout() {
        return Text.of(LoginForm.LOGOUT).asString();
    }
}
