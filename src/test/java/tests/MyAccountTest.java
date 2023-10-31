package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import Utils.JsonReader;
import java.io.IOException;
public class MyAccountTest extends BaseTest  {
    HomePage loginPage;
    MyAccountPage myAccountPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    String registerJsonPath = "Utils/registerData.json";
    String changePassPath = "Utils/changePasswordData.json";

    @Test ()
    public void TestChangePassword() throws IOException, ParseException {
        myAccountPage = homePage.NavigateToRegisterPage()
                .FillMaleFields(JsonReader.TestJson.getJson(registerJsonPath, "FirstName"),
                        JsonReader.TestJson.getJson(registerJsonPath, "LastName"),
                        "10", "7", "1990",
                        JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(registerJsonPath, "Company"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"))
                .ClickOnRegisterBtn()
                .NavigateToLoginPage()
                .fillLoginInfo( JsonReader.TestJson.getJson(registerJsonPath,"Email")+ currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(registerJsonPath,"Password"))
                .ClickOnLoginBtn()
                .ClickOnMyAccount();
        myAccountPage.ClickOnChangePassword();
        myAccountPage.fillPassword(JsonReader.TestJson.getJson(registerJsonPath,"Password"),
                JsonReader.TestJson.getJson(changePassPath,"newPassword"),
                JsonReader.TestJson.getJson(changePassPath,"confirmPassword"));
        myAccountPage.ClickOnChangePasswordbtn();

        Assert.assertEquals(myAccountPage.AlertMessage(),"Password was changed" , "Password Not change" );
        myAccountPage.ClickOnClose();
        myAccountPage.ClickOnLogout();}
    @Test ()
    public void CHeckLoginAfterChangePassword() throws IOException, ParseException {
        loginPage = homePage.NavigateToLoginPage()
                .fillLoginInfo(JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(changePassPath, "newPassword"))
                .ClickOnLoginBtn()
                .ClickOnLogOut();}
}