package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailToFriendPage;
import pages.LoginPage;
import pages.RegisterPage;
import Utils.JsonReader;
import java.io.IOException;

public class EmailPageTest extends BaseTest {
    RegisterPage registerPage;
    LoginPage loginPage;
    EmailToFriendPage emailFriend;
    String currentTime = String.valueOf(System.currentTimeMillis());
    String registerJsonPath = "src/test/resources/registerData.json";
    String EmailDataPath = "src/test/resources/emailData.json.json";
    @Test()
    public void RegisterNewUser() throws IOException, ParseException {
        registerPage = homePage.NavigateToRegisterPage()
                .FillMaleFields(JsonReader.TestJson.getJson(registerJsonPath, "FirstName"),
                        JsonReader.TestJson.getJson(registerJsonPath, "LastName"),
                        "10", "7", "1990",
                        JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(registerJsonPath, "Company"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"));
        registerPage.ClickOnRegisterBtn();
        Assert.assertTrue(registerPage.CompleteMessage().contains("complete"), " Register faild");
        registerPage.ClickOnContinue();
    }
    @Test()
    public void NavigateToLoginPage() throws IOException, ParseException {
        loginPage = homePage.NavigateToLoginPage()
                .fillLoginInfo(JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com"
                        , JsonReader.TestJson.getJson(registerJsonPath, "Password"))
                .ClickOnLoginBtn();
    }

    @Test()
    public void NavigateToEmailFriend() throws IOException, ParseException {
        emailFriend = homePage
                .SearchProduct("mac")
                .NavigateToSearchPage()
                .NavigateToProductLink()
                .NavigateToEmailPage()
                .fillInfoEmailFriendAndMsgToFriend(JsonReader.TestJson.getJson(EmailDataPath, "EmailFriend"),
                        JsonReader.TestJson.getJson(EmailDataPath, "Message"));
        emailFriend.ClickOnSendEmailBtn();
        Assert.assertTrue(emailFriend.messageSend().contains("Your message has been sent."), "Email not sent");}
}