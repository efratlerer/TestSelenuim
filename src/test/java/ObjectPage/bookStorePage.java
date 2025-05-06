package ObjectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.ArrayList;
import java.util.List;
;

public class bookStorePage {
    private WebDriver driver;

    public bookStorePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(how= How.ID ,using="searchBox")
    public WebElement search;

    @FindBy(how= How.CLASS_NAME ,using="rt-tr-group")
    public List<WebElement> result;

    @FindBy(className = "rt-noData")
    private WebElement noData;

    @FindBy(how = How.CSS ,using = ".rt-tbody .rt-tr-group")
    private  List<WebElement> rows;



    public void  search(String text) {
        search.sendKeys(text);
    }
        public int getRowCount() {
            return result.size();
        }
        public boolean NoData() {
            return noData.isDisplayed();
        }


    public List<Books> getBooksFromSite() {
        List<Books> books = new ArrayList<>();

        for (WebElement row : rows) {
            String title = row.findElement(By.cssSelector(".rt-td:nth-child(2)")).getText();
            String author = row.findElement(By.cssSelector(".rt-td:nth-child(3)")).getText();
            String publisher = row.findElement(By.cssSelector(".rt-td:nth-child(4)")).getText();

            books.add(new Books(author, publisher, title));
        }

        return books;
    }
    }






