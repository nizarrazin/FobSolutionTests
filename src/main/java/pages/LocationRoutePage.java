package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocationRoutePage extends PageBase{
    public LocationRoutePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a.icon_btn.btn_directions")
    WebElement itineraireBtn;

    @FindBy(id = "itinerary_item_input_0")
    WebElement firstPositionTxt;

    @FindBy(css = "div.dropdown_list.flying_style")
    List<WebElement> clickItemFirstPosition;

    @FindBy(id = "itinerary_item_input_1")
    WebElement secondPositionTxt;

    @FindBy(css = "div.dropdown_list.flying_style")
    List<WebElement> clickItemSecondPosition;

    @FindBy(css = "div.routes_list_label")
    WebElement routesListLabel;

    @FindBy(css = "button.mode_mix.transport_mode_tab")
    WebElement recommendedBtn;

    @FindBy(xpath = "//*[@id=\"destination_pdc\"]/div/div/div[1]/div[2]/div[3]/div/div/time")
    WebElement distanceApproximativeLabel;

    @FindBy(xpath = "//*[@id=\"routes_list\"]/div/ul")
    List<WebElement> ListResult;

    @FindBy(xpath = "//*[@id=\"routes_list\"]/div/ul/li[1]/div/div[2]/div[1]")
    WebElement timeCar;

    @FindBy(xpath = "//*[@id=\"routes_list\"]/div/ul/li[3]/div/div[2]/div[1]")
    WebElement timeBicycle;

    @FindBy(xpath = "//*[@id=\"routes_list\"]/div/ul/li[3]/div/div[2]/div[1]")
    WebElement timePedestrian;

    @FindBy(xpath = "//*[@id=\"routes_list\"]/div/ul/li[2]/div/div[2]/div[1]")
    WebElement timePublicTrspt;


    public void setLocation(String firstLocate, String secondLocate) throws InterruptedException {
        clickButton(itineraireBtn);

        setTextElementText(firstPositionTxt, firstLocate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickItemFirstPosition.get(0).click();

        setTextElementText(secondPositionTxt, secondLocate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickItemSecondPosition.get(0).click();

    }

    public void calculeLocation(){

        if (routesListLabel.isDisplayed()) {
            System.out.println(routesListLabel.getText());
        }
        else {
            if (distanceApproximativeLabel.isEnabled()){
                clickButton(distanceApproximativeLabel);
            }
            clickButton(recommendedBtn);
        }
    }


    public void resultRouteCalculated(){

        for (int i=0; i < ListResult.size(); i++)
        {
            int j =+ i+1;
            String path ="//*[@id=\"routes_list\"]/div/ul/li["+j+"]/div";
            WebElement col3Element = ListResult.get(i).findElement(By.xpath(path));
            String className =  col3Element.getAttribute("class");

            if (className.contains("car"))
                System.out.println("Route Car Calculated: " + timeCar.getText() );

            else if (className.contains("bicycle"))
                System.out.println("Route Bicycle Calculated: " + timeBicycle.getText() );

            else if (className.contains("pedestrian"))
                System.out.println("Route Pedestrian Calculated: " + timePedestrian.getText() );

            else System.out.println("Route Public Transport Calculated: " + timePublicTrspt.getText());

        }
    }

}
