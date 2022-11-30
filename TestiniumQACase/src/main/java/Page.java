import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Page {

    static By allowAllCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");


    static WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page() {
    }


    public static void closeCookies(){
        driver.findElement(allowAllCookies).click();
    }



}
