import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends Page {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void loginInformation() throws Exception {

        String path = "/Users/asus/Desktop/userCsv.csv";
        String line = "";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        driver.findElement(By.id("n-input-email")).sendKeys(records.get(0).get(0));
        driver.findElement(By.id("n-input-password")).sendKeys(records.get(0).get(1));

        WebElement clickLogin = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div[1]/form/button"));
        clickLogin.click();
    }

    public boolean isLoginButton() {
        return driver.findElement(By.xpath("//*[@id=\"login\"]/button")).isDisplayed();
    }

    public void clickNetwork() {
        WebElement networkClick = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/header/div/div/div[2]"));
        networkClick.click();

    }

}

