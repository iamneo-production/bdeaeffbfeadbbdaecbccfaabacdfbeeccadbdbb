package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class OpenGoogleDefinitions {
    private WebDriver driver;
    private int penDriveQty;

    @Given("User searches for HP Pen Drive")
    public void userSearchesForHPPenDrive() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.example.com");
    }

    @When("Add the first result on the page with quantity {int}")
    public void addFirstResultWithQuantity(int qty) {
        penDriveQty = qty;
        WebElement firstResult = driver.findElement(By.xpath("//div[@class='product'][1]"));
        WebElement addToCartButton = firstResult.findElement(By.className("add-to-cart"));
        addToCartButton.click();
    }

    @Then("Cart should display {int} pen drive")
    public void verifyCartPenDriveQuantity(int expectedQty) {
        WebElement cartQuantityElement = driver.findElement(By.id("cart-quantity"));
        int actualQty = Integer.parseInt(cartQuantityElement.getText());
        Assert.assertEquals(expectedQty, actualQty);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
