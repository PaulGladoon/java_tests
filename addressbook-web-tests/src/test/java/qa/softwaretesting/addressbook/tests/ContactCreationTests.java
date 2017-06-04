package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().contactCreation(new ContactData("Paul", "Gladoon", "test1","Nickolayevich", "Reopen", "Gogo", "DoIT", "Dobrovolskogo", "Odessa", "063", "IT", "2211", "p@p", "www.w.com", "1989", "2017", "Grree", "1122", "test"), true);
  }
}
