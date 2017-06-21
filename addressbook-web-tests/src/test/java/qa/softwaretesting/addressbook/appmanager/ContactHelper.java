package qa.softwaretesting.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForms(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
    type(By.name("homepage"), contactData.getHomepage());
    click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    type(By.name("byear"), contactData.getYear());
    click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
    click(By.xpath("//div[@id='content']/form/select[4]//option[2]"));
    if(creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("ayear"), contactData.getYear2());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void updateContactCreation() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForms(contact, creation);
    submitContactCreation();
  }

  public void modify(ContactData contact, boolean creation) {
    selectContactById(contact.getId());
    fillContactForms(contact, creation);
    click(By.name("update"));
  }

  public void selectContactById(int id) {
    WebElement checkBox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement row = checkBox.findElement(By.xpath("../.."));
    row.findElements(By.tagName("td")).get(7).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("entry"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.cssSelector("td > input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName));
    }
    return contacts;
  }

  public Contacts allData() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.cssSelector("td > input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAllPhones(allPhones)
              .withAllEmails(allEmails)
              .withAddress(address));
    }
    return contacts;
  }

  public ContactData infoFromEditFrom(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstName)
            .withLastName(lastName)
            .withHome(home)
            .withMobile(mobile)
            .withWork(work)
            .withEmail(email1)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
