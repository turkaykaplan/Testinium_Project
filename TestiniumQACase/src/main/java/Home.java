import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Home extends Page {

    public Home(WebDriver driver) {
        super(driver);
    }


    public boolean check(){
        return driver.getCurrentUrl().equals("https://www.network.com.tr/");
    }


    public void search() throws InterruptedException {
        Thread.sleep(1000);
        WebElement searchElement = driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/div/form/input"));
        searchElement.sendKeys("ceket");
        searchElement.sendKeys(Keys.ENTER);
    }


    public void homeCart() {
        WebElement homeCartButton = driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[3]/div[2]"));
        homeCartButton.click();

    }


    public void deleteProductCart() {
        WebElement deleteButton = driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[3]/div[2]/div/div/div[2]/div/div[3]"));
        deleteButton.click();
        WebElement deleteProductCartButton = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/button[2]"));
        deleteProductCartButton.click();
    }

    public void checkDeleteProduct(){
        if (driver.findElements(By.xpath("//a[@class='header__emptyBasketFavorite button -primary']")).size() == 0){
            System.out.println("Cart is empty");

        }else {
            System.out.println("Cart is not empty");
        }
    }


}


