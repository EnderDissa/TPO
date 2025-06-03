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
}