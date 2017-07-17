package qa.softwaretesting.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.softwaretesting.mantis.model.UserData;

import java.util.List;
import java.util.Random;

public class ChangePasswordHelper extends HelperBase {

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Войти']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Войти']"));
  }

  public UserData changePassword() {
    click(By.className("fa-gears"));
    click(By.cssSelector("#main-container > div.main-content > div.page-content > div > ul > li:nth-child(2)"));
    List<WebElement> cells = wd.findElements(By.tagName("tr"));
    int size = cells.size();
    Random r = new Random();
    int result = r.nextInt(size - 2) + 2;
    cells.get(result).findElement(By.tagName("a")).click();
    String username = wd.findElement(By.id("edit-username")).getAttribute("value");
    String email = wd.findElement(By.id("email-field")).getAttribute("value");
    click(By.cssSelector("input[value='Сбросить пароль']"));

    return new UserData(username, email);
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.className("bigger-110"));
  }
}
