import org.openqa.selenium.*
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
import kotlin.test.*


class SideBarTest {
    private lateinit var driver: WebDriver

    @BeforeTest
    fun setUp() {
        driver = FirefoxDriver()
        driver.manage().window().size = Dimension(800, 911)
    }

    @AfterTest
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun enterSiteIncorrect() {
        driver.get("https://www.hootsuite.com/")
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))


        assertTrue(isElementPresent(driver, By.xpath("//a[@data-ga-track-id='header_nav_Industries_Government']")))
        val menuItem = driver.findElement(By.xpath("//button[@aria-haspopup='true']/span[text()='open navigation menu']/.."))
        menuItem.click()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))

        val industriesButton = driver.findElements(By.xpath("//button[@aria-haspopup='true' and text()='Industries']"))
        if (industriesButton.size > 1) {
            industriesButton[1].click()
        } else {
            throw NoSuchElementException("Не найдено достаточно элементов Industries button")
        }

        assertTrue(driver.pageSource?.contains("Financial services")!!)
    }

    private fun isElementPresent(driver: WebDriver, by: By): Boolean =
        try {
            driver.findElement(by)
            true
        } catch (e: NoSuchElementException) {
            false
        }

    @Test
    fun mobileMenuButtonTogglesDataTestId() {
        driver.get("https://www.hootsuite.com")

        val navElement = driver.findElement(By.xpath("//*[@id='site-header']/div[2]/nav"))

        val initialTestId = navElement.getAttribute("data-testid")
        assertEquals("mobileNav-close", initialTestId)

        val menuItem = driver.findElement(By.xpath("//button[@aria-haspopup='true']/span[text()='open navigation menu']/.."))
        menuItem.click()

        val toggledTestId = navElement.getAttribute("data-testid")

        assertEquals("mobileNav-open", toggledTestId)
    }
}