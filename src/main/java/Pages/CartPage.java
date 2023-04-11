package Pages;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends ReusableMethods {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']")
    private WebElement product;

    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//span[@class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")
    private WebElement productCheckElement;

    @FindBy(xpath = "//button[normalize-space()='Sepete git']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//button[@id='continue_step_btn']")
    private WebElement shoppingButton;

    public void productClick(){
        click(product);
        switchToTab();
    }

    public void addToCart(){
        click(addCartButton);
    }

    public void productInCartCheck(){
        waitUntilElementIsVisible(productCheckElement,10);
        Assert.assertEquals(productCheckElement.getText(),"Ürün sepetinizde");
    }

    public void goToBuyPage(){
        click(goToCartButton);
    }

    public void shoppingButtonCheck(){
        isDisplayed(shoppingButton);
        isClickable(shoppingButton);
    }
}
