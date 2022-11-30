import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AllTest extends BaseTest {

    Home home;
    ProductPage productPage;
    ProductCartPage productCartPage;
    LoginPage loginPage;

    @Test
    @Order(1)
    public void checkURL() {
        home = new Home(driver);
        Assertions.assertTrue(home.check(), "Home page failed.");
        Page.closeCookies();

    }

    @Test
    @Order(2)
    public void searchProduct() throws InterruptedException {
        home.search();


    }

    @Test
    @Order(3)
    public void scrollPage() throws InterruptedException {
        Thread.sleep(2000);
        productPage = new ProductPage(driver);
        productPage.scroll();


    }

    @Test
    @Order(4)
    public void secondURLCheck() throws InterruptedException {
        Thread.sleep(1000);
        productPage = new ProductPage(driver);
        Assertions.assertFalse(productPage.secondCheck(), "Second page failed.");
    }


    @Test
    @Order(5)
    public void selectAPoduct() throws InterruptedException {
        Thread.sleep(1000);
        WebElement product = driver.findElement(By.xpath("(.//div[@data-page='2']//*[@class='product__discountPercent'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        Thread.sleep(1000);
        productPage.selectProduct();
        Thread.sleep(1000);
        ProductPage.goToCart();
        Thread.sleep(1000);
        String beforePrice = productPage.priceDiscount();
        Assertions.assertEquals(beforePrice, productPage.verifyPriceCart());
        Thread.sleep(1000);
    }

    @Test
    @Order(6)
    public void checkPriceProduct() throws InterruptedException {
        productCartPage = new ProductCartPage(driver);
        Thread.sleep(1000);
        productCartPage.discountVerify();
    }

    @Test
    @Order(7)
    public void clickContinue() {
        productPage.clickContinue();

    }

    @Test
    @Order(8)
    public void loginUser() throws Exception {
        Thread.sleep(1000);
        loginPage = new LoginPage(driver);
        LoginPage.loginInformation();


    }

    @Test
    @Order(9)
    public void checkButton() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(loginPage.isLoginButton(), "Login button is checked.");

    }

    @Test
    @Order(10)
    public void clickNetworkLogo() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.clickNetwork();
    }

    @Test
    @Order(11)
    public void openCart() throws InterruptedException {
        Thread.sleep(1000);
        home.homeCart();
    }

    @Test
    @Order(12)
    public void deleteProduct() throws InterruptedException {
        Thread.sleep(1000);
        home.deleteProductCart();
    }

    @Test
    @Order(13)
    public void verifyDeleteCart() throws InterruptedException {
        home.checkDeleteProduct();


    }


}


