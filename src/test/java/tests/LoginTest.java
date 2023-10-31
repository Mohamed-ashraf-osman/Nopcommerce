package tests;

import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Utils.JsonReader;

import java.io.IOException;
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    String registerJsonPath = "src/test/resources/registerData.json";

    @Test()
    public void TestRegisterMale() throws IOException, ParseException {
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
    public void TestLoginPage() throws IOException, ParseException {
        System.out.println("MethodName: " + "TestLoginPage" +currentTime );
        loginPage = homePage.NavigateToLoginPage();
        loginPage.fillLoginInfo(JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"))
                .ClickOnLoginBtn();
        Assert.assertTrue(loginPage.SuccessLoginMessage().contains("Welcome"), "Result Message incorrect");
        loginPage.ClickOnLogOut();}
}