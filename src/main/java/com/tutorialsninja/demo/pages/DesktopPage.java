package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    By productsList = By.xpath("//h4/a");

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getDesktopsText() {
        Reporter.log("get Desktops Text  " + desktopsText.toString());
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        Reporter.log("get Products Name List ");
        List<WebElement> products = getListOfElements(productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("select Sort By Option  " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, option);
    }

}
