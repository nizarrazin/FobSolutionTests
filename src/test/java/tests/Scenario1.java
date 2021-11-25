package tests;


import org.testng.annotations.Test;
import pages.LocationRoutePage;

public class Scenario1 extends TestBase{
    LocationRoutePage locationObject;
    String firstLocation = "Tunisia";
    String secondLocation = "Djerba";

    @Test
    public void verifyLocation() throws InterruptedException {
        locationObject = new LocationRoutePage(driver);
        locationObject.setLocation(firstLocation, secondLocation);
        locationObject.calculeLocation();
        locationObject.resultRouteCalculated();
    }
}

