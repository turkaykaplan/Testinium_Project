import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCartPage extends Page{
    public ProductCartPage(WebDriver driver) {

        super(driver);
    }

    public void discountVerify(){

        String beforeCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]")).getText();
        String afterCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]")).getText();
        Assert.assertEquals(beforeCart, afterCart, "Discount Applied.");

    }



}
