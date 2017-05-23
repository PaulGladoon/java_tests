package qa.softwaretesting.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NaviationHelper extends HelperBase{

  public NaviationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {

    click(By.linkText("groups"));
  }
}
