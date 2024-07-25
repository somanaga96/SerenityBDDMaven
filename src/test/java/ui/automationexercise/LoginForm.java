package ui.automationexercise;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {
    public static final Target LOGIN_SIGNUP = Target.the("Login/Signup").located(By.xpath("//*[contains(text(),'Signup / Login')]"));
    public static final Target EMAIL = Target.the("Email").located(By.xpath("//input[@type='email']"));
    public static final Target PASSWORD = Target.the("Password").located(By.xpath("//input[@type='password']"));
    public static final Target ERROR_MSG = Target.the("Error Message").located(By.xpath("//*[@name='password']//following-sibling::p"));
    public static final Target LOGIN = Target.the("Login Button").located(By.xpath("//button[contains(text(),'Login')]"));
    public static final Target LOGOUT = Target.the("Logout Button").located(By.xpath("//button[contains(text(),'Logout')]"));

}
