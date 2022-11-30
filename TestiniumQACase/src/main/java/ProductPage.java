import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class ProductPage extends Page{

    By productPrice = By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[2]");
    By afterCartPrice = By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[1]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String priceDiscount(){
        return driver.findElement(productPrice).getText();
    }
    public String verifyPriceCart(){
        return driver.findElement(afterCartPrice).getText();
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement moreButton = driver.findElement(By.xpath("//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button"));
        moreButton.sendKeys(Keys.ENTER);
        js.executeScript("arguments[0].scrollIntoView();", moreButton);

    }


    public boolean secondCheck(){
        return driver.getCurrentUrl().equals("https://www.network.com.tr/search?searchKey=Ceket&page=2/");
    }


    public void selectProduct() throws InterruptedException {
        // Random selection of in-stock sizes of the first discounted item.
        List<WebElement> allProductSize = driver.findElements(By.xpath("(.//div[@data-page='2']//*[@class='product__discountPercent'])[1]//..//..//..//div[@class='product__header']//div[@class='product__sizeItem']//div[@class='product__size -productCart radio-box']//*[@class='radio-box__label']"));
        Random randomSizeSelect = new Random();
        int randomSizeProduct = randomSizeSelect.nextInt(allProductSize.size());
        allProductSize.get(randomSizeProduct).click();

    }




    public static void goToCart() {
        WebElement goCart = driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[3]/div[2]/div/div/div[3]/a"));
        goCart.click();
    }

    public void clickContinue(){
        WebElement continueClick = driver.findElement(By.xpath("//*[@class='continueButton n-button large block text-center -primary']"));
        continueClick.click();
    }



}
