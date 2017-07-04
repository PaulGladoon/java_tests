package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;
import qa.softwaretesting.addressbook.model.GroupData;

public class DeleteContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData()
              .withFirstName("Alex")
              .withHome("111")
              .withMobile("222")
              .withWork("333")
              .withLastName("Popovich"), true);
    }

    if (app.db().contactsInGroups() == 0) {
      app.goTo().homePage();
      Contacts contactInfo = app.db().contacts();
      ContactData randomId = contactInfo.iterator().next();
      ContactData contact = new ContactData().withId(randomId.getId());
      app.contact().selectContactByCheckbox(contact.getId());
      app.contact().addContactToGroup();
    }
  }

  @Test
  public void testDeleteContactFromGroup() throws InterruptedException {
    int beforeTable = app.db().contactsInGroups();
    app.goTo().homePage();
    String groupName = app.db().nameOfGroup();
    app.contact().selectGroupFromGroupsList(groupName);
    Contacts contactInfo = app.db().contacts();
    ContactData randomId = contactInfo.iterator().next();
    ContactData contact = new ContactData().withId(randomId.getId());
    app.contact().selectContactByCheckbox(contact.getId());
    app.contact().deleteContactFromGroup();
    int afterTable = app.db().contactsInGroups();

    Thread.sleep(1000);

    Assert.assertEquals(afterTable, beforeTable - 1);

  }
}
