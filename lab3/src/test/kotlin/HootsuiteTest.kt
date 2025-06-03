import org.openqa.selenium.*
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class HootsuiteTest {
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
    fun myHootSuite() {
        driver.get("https://www.hootsuite.com/")
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))

        val menuItem = driver.findElement(By.xpath("//a[@data-ga-track-id='header_nav_pricing_new_plan_25']"))
        menuItem.click()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))
        assertTrue(driver.pageSource?.contains("Pick the plan that's right for you")!!)
    }

    @Test
    fun requestDemoFormValidation() {
        driver.get("https://www.hootsuite.com/request-demo")

        val firstNameField = driver.findElement(By.xpath("//*[@id='FirstName']"))
        val lastNameField = driver.findElement(By.xpath("//*[@id='LastName']"))
        val emailField = driver.findElement(By.xpath("//*[@id='Email']"))
        assertTrue(firstNameField.isDisplayed && firstNameField.isEnabled)
        assertTrue(lastNameField.isDisplayed && lastNameField.isEnabled)
        assertTrue(emailField.isDisplayed && emailField.isEnabled)

        val countrySelect = driver.findElement(By.xpath("//*[@id='Country']"))
        val helpSelect = driver.findElement(By.xpath("//*[@id='How_can_we_help_you_CP__c']"))
        assertTrue(countrySelect.isDisplayed && countrySelect.isEnabled)
        assertTrue(helpSelect.isDisplayed && helpSelect.isEnabled)

        val submitButton = driver.findElement(By.xpath("//*[@id='marketo-17158']/div[31]/span/button"))

        val isDisabled = !submitButton.isEnabled || submitButton.getAttribute("disabled") != null
        assertTrue(isDisabled)
    }
    @Test
    fun mobileMenuButtonTogglesDataTestId() {
        driver.get("https://www.hootsuite.com")

        val navElement = driver.findElement(By.xpath("//*[@id='site-header']/div[2]/nav"))

        val initialTestId = navElement.getAttribute("data-testid")
        assertEquals("mobileNav-close", initialTestId)

        val menuButton = driver.findElement(By.xpath("//button[@data-testid='mobileNav-toggle']"))
        menuButton.click()

        val toggledTestId = navElement.getAttribute("data-testid")

        assertEquals("mobileNav-open", toggledTestId)
    }
}