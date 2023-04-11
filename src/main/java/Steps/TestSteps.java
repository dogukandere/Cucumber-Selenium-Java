package Steps;

import Pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
    protected WebDriver driver;
    SearchPage searchPage;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I navigate to hepsiburada page")
    public void ı_navigate_to_hepsiburada_page() {
        searchPage = new SearchPage(driver);
        searchPage.navigateToPage("https://www.hepsiburada.com");
    }

    @And("I close popup")
    public void ı_ClosePopup() {
        searchPage.acceptPopup();
    }

    @And("I type {string} in search area")
    public void ıTypeInSearchArea(String arg0) {
        searchPage.searchProduct("s23");
    }

    @When("I click search button")
    public void ı_click_search_button() {
        searchPage.searchClick();
    }

    @Then("Verify {string} is displayed")
    public void verifyIsDisplayed(String arg0) {
        searchPage.productControl();
    }



}
