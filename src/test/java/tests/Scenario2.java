package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocationPage;
import pages.UserLoginPage;

    public class Scenario2 extends TestBase{

        LocationPage locationObject;
        UserLoginPage loginObject;

        String email ="test@tmpbox.net";
        String password = "Azerty.a";
        String searchCountry = "Tunisia";
        String nameCollect = "myNewCollection";

        @Test(priority = 1)
        public void UserCanLogin() throws InterruptedException {
            loginObject = new UserLoginPage(driver);
            locationObject = new LocationPage(driver);
            locationObject.showMenuLogin();
            driver.switchTo().frame(locationObject.framePrompt);
            loginObject.UserCanLogin(email, password);
            driver.switchTo().defaultContent();
        }

        @Test(priority = 2)
        public void SearchLocationAndAddToCollection() throws InterruptedException {
            locationObject = new LocationPage(driver);
            Thread.sleep(2000);
            locationObject.UserCanSearchPlaceToAddaCollection(searchCountry);
            locationObject.UserCreatCollection(nameCollect);
            Thread.sleep(4000);
        }

        @Test(priority = 3)
        public void VerifyCollection() throws InterruptedException{
            locationObject = new LocationPage(driver);
            locationObject.showMenuCollections();
            Thread.sleep(3000);
            Assert.assertTrue(locationObject.listC.getText().contains(nameCollect));
            Thread.sleep(1000);
            System.out.println("New Collection is added: "+ locationObject.listC.getText());
            Thread.sleep(1000);
            locationObject.listC.click();
            Thread.sleep(1000);
            Assert.assertTrue(locationObject.listP.getText().contains(searchCountry));
            System.out.println("New Place is added: "+ locationObject.listP.getText());
        }

    }
