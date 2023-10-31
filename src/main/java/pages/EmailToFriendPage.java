package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailToFriendPage extends BasePage {
    public EmailToFriendPage(WebDriver driver) {super(driver);}
    private final By friendEmailField = By.name("FriendEmail");
    private final By personalMessageField = By.id("PersonalMessage");
    private final By sendEmailBtn = By.name("send-email");
    private final By successMsgSend = By.className("result");
    public EmailToFriendPage fillInfoEmailFriendAndMsgToFriend(String emailFriend, String personalMessage) {
        SetText(friendEmailField, emailFriend);
        SetText(personalMessageField, personalMessage);
        return this;
    }
    public void ClickOnSendEmailBtn() {
        driver.findElement(sendEmailBtn).click();
    }
    public String messageSend() {
        WaitTime(successMsgSend);
        return driver.findElement(successMsgSend).getText();
    }
}
