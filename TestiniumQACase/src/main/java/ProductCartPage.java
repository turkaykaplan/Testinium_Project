import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCartPage extends Page{
    public ProductCartPage(WebDriver driver) {

        super(driver);
    }

    public void discountVerify() {
        String beforeCart = driver.findElement(By.xpath("//div[@class='cartItem__prices']//*[@class='cartItem__price -old -labelPrice']")).getText();
        int beforeCartInt = Integer.parseInt(beforeCart);

        String afterCart = driver.findElement(By.xpath("//div[@class='cartItem__prices']//*[@class='cartItem__price -sale']")).getText();
        int afterCartInt = Integer.parseInt(afterCart);

        if (beforeCartInt > afterCartInt) {
            Assert.assertEquals(beforeCart, afterCart);
            System.out.println("Discount is Successful");
        } else System.out.println("Discount is Fail");

    }




}
