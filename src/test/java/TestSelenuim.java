import ObjectPage.Book;
import ObjectPage.bookStorePage;
import ObjectPage.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class TestSelenuim {
    WebDriver driver;
    loginPage login;
    bookStorePage bookStore;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        login = PageFactory.initElements(driver, loginPage.class);
        bookStore = PageFactory.initElements(driver, bookStorePage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        login.loginActions("efrat", "@Efrat1234");
    }

    @Test
    public void goToStore() throws InterruptedException {
        driver.findElement(By.id("gotoStore")).click();
    }

    @Test
    public void search1() throws InterruptedException {
        bookStore.search("git Pocket");
        assertEquals(bookStore.getRowCount(), 1);
    }

    @Test
    public void search2() throws InterruptedException {
        bookStore.search("VeriSoft");
        assertEquals(bookStore.getRowCount(), 0);
        assertTrue(bookStore.NoData());
    }

    @Test
    public void getBooksAndPrint() throws InterruptedException {
        List<Book> books = bookStore.getBooksFromSite();

        for (Book book : books) {
            book.printDetails();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
