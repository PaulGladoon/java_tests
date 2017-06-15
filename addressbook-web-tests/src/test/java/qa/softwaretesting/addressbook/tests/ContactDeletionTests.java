package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().contactCreation(new ContactData("Paul", "Gladoon", "test1","Nickolayevich", "Reopen", "Gogo", "DoIT", "Dobrovolskogo", "Odessa", "063", "IT", "2211", "p@p", "www.w.com", "1989", "2017", "Grree", "1122", "test"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().selectAllContacts();
    app.getNavigationHelper().submitDeletion();
    app.getNavigationHelper().acceptInDeletionWindow();
    List<ContactData> contactListAfterDeletion = app.getContactHelper().getContactList();
    Assert.assertEquals(contactListAfterDeletion.size(), 0);
  }

}
