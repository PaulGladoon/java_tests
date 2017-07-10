package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;
import qa.softwaretesting.addressbook.model.GroupData;
import qa.softwaretesting.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contactsInGroups() > 0) {
      app.goTo().homePage();
      app.goTo().selectAllContacts();
      app.goTo().submitDeletion();
      app.goTo().acceptInDeletionWindow();
    }

    Thread.sleep(1000);

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().addNewContact();
      app.contact().create(new ContactData()
              .withFirstName("Alex")
              .withHome("111")
              .withMobile("222")
              .withWork("333")
              .withLastName("Popovich"), true);
    }
  }

  @Test
  public void testAddContactToGroup() throws InterruptedException {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    int beforeTable = app.db().contactsInGroups();
    Groups groupBefore = app.db().conGroup();
    ContactData randomId = before.iterator().next();
    ContactData contact = new ContactData().withId(randomId.getId());
    app.contact().selectContactByCheckbox(contact.getId());
    app.contact().addContactToGroup();

    Thread.sleep(1000);

    int afterTable = app.db().contactsInGroups();
    Contacts after = app.db().contacts();
    Groups groupAfter = app.db().conGroup();

    assertThat(after.size(), equalTo(before.size()));

    if (beforeTable == 0) {
      Assert.assertEquals(afterTable, beforeTable + 1);
      Assert.assertNotEquals(groupBefore, groupAfter);
    } else {
      Assert.assertEquals(beforeTable, afterTable);
    }
  }
}
