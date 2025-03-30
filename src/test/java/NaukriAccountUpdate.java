import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class NaukriAccountUpdate {

    @Test
    public static void NaukriCVUpdate() throws InterruptedException {

        System.setProperty("WebDriver.chromedriver.driver", "src/main/resources/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");  // Headless mode (No GUI)
        options.addArguments("--disable-gpu"); // Recommended for headless
        //options.addArguments("--remote-debugging-port=9222");
        options.addArguments("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.129 Safari/537.36");



        WebDriver driver = new ChromeDriver(options);

      //  WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        driver.manage().window().setSize(new Dimension(1440,900));
        driver.get("https://www.naukri.com/");

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_Layer")));
     loginButton.click();


        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".naukri-drawer.right.open")));

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));
       // username.click();
        username.sendKeys("archanadefine@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("sachdefine");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        WebElement element2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-details-inner.fixed")));
        driver.findElement(By.xpath("//a[@href='/mnjuser/profile']")).click();

        WebElement element3 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.quickLink ")));
        File file = new File("src/main/resources/ArchanaChauhanCV.docx");
        String absolutePath = file.getAbsolutePath();

        // Locate file input field
        WebElement fileInput = driver.findElement(By.id("attachCV"));
        fileInput.sendKeys(absolutePath);

        WebElement editButton = driver.findElement(By.xpath("//span[text()='Resume headline']/following-sibling::span[@class='edit icon']"));
        editButton.click();

        WebElement element4= wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("resumeHeadlineTxt")));

        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']"));
        textArea.clear();
        textArea.sendKeys("An Automation passionate, ISTBQ Certified Software QA(with B. Tech degree) with a demonstrated history of working in the internet industry. Skilled in Test Automation(UI/API), API Testing, IVR testing, Java, Backend workflows components.");

        WebElement element5= wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
        element5.click();
       Thread.sleep(2000);
        WebElement editButton2 = driver.findElement(By.xpath("//span[text()='Key skills']/following-sibling::span[@class='edit icon']"));
        editButton2.click();
        Thread.sleep(2000);
       // List<WebElement> li= driver.findElements(By.xpath("//div[@class='waves-effect chip']"));
        //li.getLast().clear();

//        WebElement element6= wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
//        element5.click();




        driver.quit();


















}}
