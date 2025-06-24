import org.openqa.selenium.*
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.*

class LoginTest {
    private lateinit var driver: WebDriver

    @BeforeTest
    fun setUp() {
        driver = FirefoxDriver()
        driver.manage().window().size = Dimension(1280, 720)
    }

    @AfterTest
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun enterSiteIncorrect() {
        driver.get("https://www.hootsuite.com/")

        val wait = WebDriverWait(driver, Duration.ofSeconds(15))
        try {
            val cookiesButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept All Cookies']"))
            )
            cookiesButton.click()
        } catch (e : Exception) {
            print("No cookies")
        }

        val menuItem = driver.findElement(By.xpath("//a[@id='header_nav_level1_login']"))
        val oldUrl = driver.currentUrl
        menuItem.click()
        WebDriverWait(driver, Duration.ofSeconds(10)).until {
            driver.currentUrl != oldUrl
        }

        val loginField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginEmailInput']"))
        )
        loginField.sendKeys("makshockey13@gmail.com")
        val passwordField = driver.findElement(By.xpath("//input[@id='loginPasswordInput']"))
        passwordField.sendKeys("12345")

        val submitButton = driver.findElement(By.xpath("//button[text()='Sign in' and @type='submit']"))

        submitButton.click()

        assertTrue(driver.pageSource?.contains("Sorry, we couldn't find that email and/or password")!!)
    }

    @Test
    fun enterButtonDisabled() {
        driver.get("https://hootsuite.com/signin")

        try {
            val wait = WebDriverWait(driver, Duration.ofSeconds(10))
            val cookiesButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept All Cookies']"))
            )
            cookiesButton.click()
        } catch (e : Exception) {
            print("No cookies")
        }

        assertTrue(driver.pageSource?.contains("Sign in")!!)

        val submitButton = driver.findElement(By.xpath("//button[text()='Sign in' and @type='submit']"))
        assertTrue(submitButton.getAttribute("area-disabled") != "true")
        val loginField = driver.findElement(By.xpath("//input[@id='loginEmailInput']"))
        loginField.sendKeys("makshockey13@gmail.com")
        val passwordField = driver.findElement(By.xpath("//input[@id='loginPasswordInput']"))
        passwordField.sendKeys("12345")
        assertTrue(submitButton.getAttribute("area-disabled") != "false")
    }
}