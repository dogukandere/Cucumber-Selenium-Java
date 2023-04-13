package Steps;

import Pages.CartPage;
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

public class TestSteps {
    protected WebDriver driver;
    SearchPage searchPage;
    CartPage cartPage;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I navigate to hepsiburada page")
    public void navigate_to_hepsiburada_page() {
        searchPage = new SearchPage(driver);
        searchPage.navigateToPage("https://www.hepsiburada.com");
    }

    @And("I close popup")
    public void ClosePopup() {
        searchPage.acceptPopup();
    }

    @And("I type {string} in search area")
    public void TypeInSearchArea(String arg0) {
        searchPage.searchProduct(arg0);
    }

    @When("I click search button")
    public void click_search_button() {
        searchPage.searchClick();
    }

    @Then("Verify s23 is displayed")
    public void verifyIsDisplayed() {
        searchPage.productControl();
    }

    @When("I click s23")
    public void Clicks23() {
        cartPage = new CartPage(driver);
        cartPage.productClick();
    }

    @Then("I add product to the cart")
    public void AddProductToTheCart() {
        cartPage.addToCart();
    }

    @And("Verify product is in the cart")
    public void verifyProductIsInTheCart() {
        cartPage.productInCartCheck();
    }

    @And("I navigate purchase page")
    public void NavigatePurchasePage() {
        cartPage.goToBuyPage();
    }

    @And("Verify shopping button")
    public void verifyShoppingButton() {
        cartPage.shoppingButtonCheck();
    }

    @After
    public void after(){
        driver.quit();
    }
}
