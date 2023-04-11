package Pages;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends ReusableMethods {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement popup;

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']")
    private WebElement product;

    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public void acceptPopup(){
        click(popup);
    }

    public void searchProduct(String productname){
        sendKeys(searchBox,productname);
    }

    public void searchClick(){
        click(searchButton);
    }

    public void productControl(){
        isDisplayed(product);
    }

}
