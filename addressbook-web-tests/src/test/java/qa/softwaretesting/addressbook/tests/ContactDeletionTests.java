package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;
import qa.softwaretesting.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().addNewContact();
      app.contact().create(new ContactData()
              .withFirstName("Alex")
//              .withGroup("test1")
              .inGroup(groups.iterator().next())
              .withMiddleName("Popovich"), true);
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.goTo().homePage();
    app.goTo().selectAllContacts();
    app.goTo().submitDeletion();
    app.goTo().acceptInDeletionWindow();
    Thread.sleep(1000); // Добавил из-за того что удаление из БД происходит с 1 секундной задержкой
    Contacts contactListAfterDeletion = app.db().contacts();

    assertThat(contactListAfterDeletion.size(), equalTo(0));
  }

}
