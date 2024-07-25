package automationexercise;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import ui.automationexercise.LoginForm;
import utils.Message;


public class Login {
    private Actor actor;
    @Managed
    WebDriver driver;


    @Given("{string} launch the Automation Exercise UI")
    public void launchTheAutomationExerciseUI(String actorName) {
        actor = Actor.named(actorName);
        actor.can(BrowseTheWeb.with(driver));
        driver.manage().window().maximize();
        actor.attemptsTo(Open.url("https://www.automationexercise.com/"), Click.on(LoginForm.LOGIN_SIGNUP));
    }

    @SneakyThrows
    @When("user logged using {string} and {string}")
    public void userLoggedUsingAnd(String email, String password) {
        WebElement passPath = driver.findElement(By.xpath("//input[@type='password']"));
        actor.attemptsTo(Enter.theValue(email).into(RelativeLocator.with(By.xpath("//input[@type='email']")).above(passPath)),
                Enter.theValue(password).into(LoginForm.PASSWORD), Click.on(LoginForm.LOGIN));
    }


    @Then("user able to see the {string}")
    public void userAbleToSeeThe(String msg) {
        if (msg.equals("Logout")) {
            String text = Serenity.getDriver().findElement(By.xpath("//a[contains(text(),'Logout')]")).getText();
//            actor.attemptsTo(Ensure.that(Message.logout()).isEqualTo(msg));
            actor.attemptsTo(Ensure.that(text).isEqualTo(msg));
        } else {
            actor.attemptsTo(Ensure.that(Text.of(LoginForm.ERROR_MSG).asString()).isEqualTo(msg));
        }
    }


}
