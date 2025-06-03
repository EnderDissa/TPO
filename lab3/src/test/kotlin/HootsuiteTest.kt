import org.openqa.selenium.*
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

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
    fun myIvi() {
        driver.get("https://www.hootsuite.com/")
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        val menuItem = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='headerTop']/div/div/div/div/div[2]/nav/ul/li/a/div"))
        )
        menuItem.click()

        val modal = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-container']/div/div[2]/div/div/div/section/div/div/div"))
        )
        modal.click()
    }
}