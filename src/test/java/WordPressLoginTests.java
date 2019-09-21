import org.junit.Assert;
import org.junit.Test;

public class WordPressLoginTests extends AppiumTestBase{


    @Test
    public void testIncorrectEmail() throws Exception {
        System.out.println("Start application");
        WordpressApp app = getMobileApp();

        System.out.println("Click Login button");
        app.welcomeScreen().clickLoginButton();

        System.out.println("Enter email");
        app.loginScreen().enterEmail("kolesniknikolai92@gmail.com");

        System.out.println("Click Next");
        app.loginScreen().clickNextButton();

        app.loginScreen().clickSubmitButton();

        System.out.println("Check error message");

        Assert.assertTrue(app.loginScreen().getErrorMessage().contains("client_id"));
    }



}