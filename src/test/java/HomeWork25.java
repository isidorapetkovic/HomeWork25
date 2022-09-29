import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork25 {
    //Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html.
    // Testirati rad svih operacija posebno.
    //
    //Za njega napisati edge case-eve na koje naletite, ili ispunite neka matematicka pravila
    // (deljenje sa nulom, jedinicom, veliki/mali brojevi itd).
    // Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum), zanemarujuci Concatenate.
    private WebDriver driver;
    @BeforeClass
    public void beforeClass () {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver=new ChromeDriver();

    }

    @AfterClass
    public void afterClass () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @BeforeMethod
    public void beforeMethod () {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }
    @Test
    public void add () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("5");
        String expectedResult= "10";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Add");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void addZero () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("0");
        String expectedResult= "5";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Add");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public void addNegativeNumber () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("-5");
        String expectedResult= "0";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Add");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public void addLetter () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("B");
        WebElement message=driver.findElement(By.xpath("//*[@id=\"errorMsgField\"]"));
        String expectedResult= message.getText();
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Add");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void subtract () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("5");
        String expectedResult= "0";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Subtract");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public void subtractZero () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("0");
        String expectedResult= "5";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Subtract");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void subtractNegativenumber () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("-9");
        String expectedResult= "14";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Subtract");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public void subratctLetter () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("B");
        WebElement message=driver.findElement(By.xpath("//*[@id=\"errorMsgField\"]"));
        String expectedResult= message.getText();
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Add");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }


    @Test
    public void multiply () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("5");
        String expectedResult= "25";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Multiply");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void multiplyWithZero () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("0");
        String expectedResult= "0";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Multiply");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void multiplyWithOne () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("1");
        String expectedResult= "5";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Multiply");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void multiplyNegativeNumber () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("-5");
        String expectedResult= "-25";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Multiply");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }




    @Test
    public void divide () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("5");
        String expectedResult= "1";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Divide");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void divideWithOne () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("1");
        String expectedResult= "5";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Divide");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void divideNegativeNumber () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("-5");
        String expectedResult= "-1";
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Divide");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }


    @Test
    public void divideWithZero () throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,900)", "");
        WebElement number1= driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        number1.sendKeys("5");
        WebElement number2= driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        number2.sendKeys("0");
        WebElement message=driver.findElement(By.xpath("//*[@id=\"errorForm\"]/h3"));
        String expectedResult= message.getText();
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select input=new Select(dropDownMenu);
        input.selectByVisibleText("Divide");
        WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answer=driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult= answer.getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);

    }


}
