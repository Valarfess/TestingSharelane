import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZipCodeTest {
    @Test
    public void enterValidZipCode() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).click();
        driver.findElement(By.name("zip_code")).clear();
        driver.findElementByName("zip_code").sendKeys("5664566");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        boolean isOpened = driver.findElementByName("first_name").isDisplayed();
        Assert.assertTrue(isOpened, "Wasn't open");
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).click();
        driver.findElement(By.name("zip_code")).clear();
        driver.findElementByName("zip_code").sendKeys("5664");
        String error = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error! ZIP code should have 5 digits");
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAcceptEmptyField() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("");
        String error = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error! Zip Code field is empty");
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAcceptLetters() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("Gdsdнет");
        String error = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error! You entered letters in Zip Code field");
        driver.quit();
    }

    @Test
    public void fillValidMandatoryFields() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver2 = new ChromeDriver();
        driver2.get("https://www.sharelane.com/cgi-bin/register.py");
        driver2.findElement(By.name("zip_code")).click();
        driver2.findElement(By.name("zip_code")).clear();
        driver2.findElementByName("zip_code").sendKeys("5664566");
        driver2.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver2.findElementByName("first_name").click();
        driver2.findElementByName("first_name").clear();
        driver2.findElementByName("first_name").sendKeys("Anton");
        driver2.findElementByName("email").click();
        driver2.findElementByName("email").clear();
        driver2.findElementByName("email").sendKeys("sfdsfkgjlj@gmail.com");
        driver2.findElementByName("password1").click();
        driver2.findElementByName("password1").clear();
        driver2.findElementByName("password1").sendKeys("6547");
        driver2.findElementByName("password2").click();
        driver2.findElementByName("password2").clear();
        driver2.findElementByName("password2").sendKeys("6547");
        driver2.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        boolean isSighedUp = driver2.findElementByCssSelector("[class = confirmation_message]").isDisplayed();
        Assert.assertTrue(isSighedUp, "SignUp is failed");
        driver2.quit();
    }

    @Test
    public void leaveFirstNameEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("");
        driver.findElementByName("email").sendKeys("sfdsfkgjlj@gmail.com");
        driver.findElementByName("password1").sendKeys("6547");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "First Name field is Empty");
        driver.quit();
    }

    @Test
    public void enterInFirstNameFiledOnlyDigits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("43654");
        driver.findElementByName("email").sendKeys("sfdsfkgjlj@gmail.com");
        driver.findElementByName("password1").sendKeys("6547");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "First Name field should have only Letters");
        driver.quit();
    }

    @Test
    public void leaveEmailEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("");
        driver.findElementByName("password1").sendKeys("6547");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "E-mail field is Empty");
        driver.quit();
    }

    @Test
    public void enterWrongStructureOfEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("faf_+m@mail.ru");
        driver.findElementByName("password1").sendKeys("6547");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "E-mail has wrong structure");
        driver.quit();
    }
    @Test
    public void enterNonFullStrctureEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("example54674@mail.");
        driver.findElementByName("password1").sendKeys("6547");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "E-mail has non full structure");
        driver.quit();
    }
    @Test
    public void leavePasswordEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("645657");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("example54674@mail.");
        driver.findElementByName("password1").sendKeys("");
        driver.findElementByName("password2").sendKeys("6547");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input").click();
        String errorSighUpEmptyName = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSighUpEmptyName, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "Password field is empty");
        driver.quit();
    }
    @Test
    public void enterInPasswordFiled3Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("654765");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("fdtyy767@gmail.com");
        driver.findElementByName("password1").sendKeys("321");
        driver.findElementByName("password2").sendKeys("321");
        driver.findElementByXPath("\"/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input\"").click();
        String errorSignUpPassword = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSignUpPassword,"Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "Password should consist of 4 or more Digits or Letters");
        driver.quit();
    }
    @Test
    public void enterNonEqualPasswords(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("654765");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("fdtyy767@gmail.com");
        driver.findElementByName("password1").sendKeys("321");
        driver.findElementByName("password2").sendKeys("32154");
        driver.findElementByXPath("\"/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input\"").click();
        String errorSignUpPassword = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(errorSignUpPassword,"Oops, error on page. Some of your fields have invalid data or email was previously used", "Error!" +
                "You enter different passwords");
        driver.quit();
    }
    @Test
    public void enterValidLoginAndPasswordForSingIn(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElementByName("zip_code").sendKeys("654765");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input").click();
        driver.findElementByName("first_name").sendKeys("Anton");
        driver.findElementByName("email").sendKeys("fdtyy767@gmail.com");
        driver.findElementByName("password1").sendKeys("321");
        driver.findElementByName("password2").sendKeys("32154");
        driver.findElementByXPath("\"/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input\"").click();
        String email = driver.findElementByXPath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b").getText();
        String password = driver.findElementByXPath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]").getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElementByName("email").sendKeys(email);
        driver.findElementByName("password").sendKeys(password);
        driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[3]/input").click();
        boolean isLoggedIn = driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/a").isDisplayed();
        Assert.assertTrue(isLoggedIn, "Log in has failed");
        driver.quit();
    }
    @Test
    public void enterUnregisteredEmailForSingIn(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElementByName("email").sendKeys("mail@gmail.com");
        driver.findElementByName("password").sendKeys("1111");
        driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[3]/input").click();
        String error = driver.findElementByXPath("/html/body/center/table/tbody/tr[4]/td/span").getText();
        Assert.assertEquals(error,"Oops, error. Email and/or password don't match our records","Error!" +
                "You inter unregistered E-mail");
        driver.quit();
    }
}
