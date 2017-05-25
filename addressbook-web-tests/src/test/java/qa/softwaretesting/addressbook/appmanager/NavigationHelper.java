package qa.softwaretesting.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {

    click(By.linkText("groups"));
  }

  public void gotoAddNewContactPage() {

    click(By.linkText("add new"));
  }

  public void selectAllContacts() {
    click(By.id("MassCB"));
  }

  public void submitDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptInDeletionWindow() {
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }
}
