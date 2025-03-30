import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v132.page.model.Screenshot;
import org.openqa.selenium.html5.WebStorage;

public class ScrnTest {

    public static void main(String[] args) {

        System.setProperty("WebDriver.chromedriver.driver", "src/main/resources/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement data =driver.findElement(By.xpath("//textarea[@title='Search']"));
        data.sendKeys("photon interactive pvt ltd");
        data.click();






    }
}
