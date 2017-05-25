package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().selectAllContacts();
    app.getNavigationHelper().submitDeletion();
    app.getNavigationHelper().acceptInDeletionWindow();
  }

}
