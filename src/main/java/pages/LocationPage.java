package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocationPage extends PageBase {
    public LocationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "here-account-sdk")
    public WebElement framePrompt;

    // Scearch Text Input
    @FindBy(css = "button.menu_access_btn.icon_btn")
    WebElement menuBtn;

    @FindBy(css = "button.sign_in_out.sign_in_button")
    WebElement signinBtn;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div/div[1]/div[3]/a")
    WebElement collectionsBtn;

    @FindBy(xpath = "//*[@id=\"searchbar\"]/div/div[1]/input")
    WebElement searchTxt;

    // Dropdown List Shearch
    @FindBy(xpath = "//*[@id=\"searchbar\"]/div/div[2]/div[1]")
    WebElement dropdownSearchTxt;

    // Collect Location Button
    @FindBy(xpath = "/html/body/div[1]/div[6]/div[1]/div/div[1]/div[3]/div/div[3]/button")
    WebElement addCollectBtn;

    // Button Start new collect
    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div/div/div[2]/button")
    WebElement startNewCollectionBtn;

    // Name Collect Input
    @FindBy(id = "collection_name")
    WebElement nameCollectTxt;

    // create collect
    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div/div/div[2]/form/fieldset[2]/button[2]")
    WebElement createBtn;

    // Done
    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div/div/div[2]/button[2]")
    WebElement doneBtn;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[1]/div/div[2]/div/div/h4/a")
    public WebElement listC;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[1]/div/div[2]/div/section/section/div/a/div[2]/h4")
    public WebElement listP;

    public void showMenuLogin() {
        clickButton(menuBtn);
        clickButton(signinBtn);
    }

    public void showMenuCollections() throws InterruptedException {
        clickButton(menuBtn);
        Thread.sleep(2000);
        clickButton(collectionsBtn);
    }

    public void UserCanSearchPlaceToAddaCollection(String countryName) throws InterruptedException {
        clickButton(searchTxt);
        setTextElementText(searchTxt, countryName);
        Thread.sleep(2000);
        clickButton(dropdownSearchTxt);
        clickButton(addCollectBtn);
        Thread.sleep(1000);
    }

    public  void UserCreatCollection(String collectName) throws InterruptedException {
            clickButton(startNewCollectionBtn);
            Thread.sleep(1000);
            setTextElementText(nameCollectTxt, collectName);
            Thread.sleep(1000);
            clickButton(createBtn);
            Thread.sleep(1000);
            clickButton(doneBtn);
    }


}