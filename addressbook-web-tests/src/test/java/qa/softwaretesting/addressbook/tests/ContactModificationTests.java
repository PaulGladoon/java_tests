package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().editContact();
    app.getContactHelper().fillContactForms(new ContactData("Vasya", "Pupkin", "Nickolayevich", "Reopen", "Gogo", "DoIT", "Dobrovolskogo", "Odessa", "063", "IT", "2211", "p@p", "www.w.com", "1989", "2017", "Grree", "1122", "test"));
    app.getContactHelper().updateContactCreation();
  }
}
