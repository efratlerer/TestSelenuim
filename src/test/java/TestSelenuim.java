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

    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(5000);
        login.loginActions("efrat", "@Efrat1234");
    }

    @Test
    public void goToStore() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("gotoStore")).click();
    }

    @Test
    public void search1() throws InterruptedException {
        Thread.sleep(5000);
        bookStore.search("git Pocket");
        assertEquals(bookStore.getRowCount(),1);
    }

    @Test
    public void search2() throws InterruptedException {
        Thread.sleep(5000);
        bookStore.search("VeriSoft");
        assertEquals(bookStore.getRowCount(),0);
        assertTrue(bookStore.NoData());
    }

    @Test
    public void getBooksAndPrint() throws InterruptedException {
        Thread.sleep(5000);
        List<Books> books= bookStore.getBooksFromSite();
        Thread.sleep(5000);

        for (Books book : books) {
            book.printBook();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
