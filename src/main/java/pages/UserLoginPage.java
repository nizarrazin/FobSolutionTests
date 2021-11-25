package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class UserLoginPage extends PageBase{
        public UserLoginPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = "button.menu_access_btn.icon_btn")
        WebElement menuBtn;

        @FindBy(css = "button.sign_in_out.sign_in_button")
        WebElement signinBtn;

        @FindBy(id = "here-account-sdk")
        public WebElement framePrompt;

        @FindBy(id = "sign-in-email")
        WebElement emailTxt;

        @FindBy(id = "sign-in-password-encrypted")
        WebElement passwordTxt;

        @FindBy(id = "signInBtn")
        WebElement submitSigninBtn;

        public void showMenu(){
            clickButton(menuBtn);
            clickButton(signinBtn);
        }

        public void UserCanLogin(String email, String password)  {
            setTextElementText(emailTxt, email);
            setTextElementText(passwordTxt, password);
            clickButton(submitSigninBtn);
        }

    }
