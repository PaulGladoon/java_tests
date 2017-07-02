package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData()
              .withFirstName("Alex")
              .withGroup("test1")
              .withMiddleName("Popovich"), true);
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("Paul")
            .withLastName("Evro")
            .withHome("333")
            .withMobile("444")
            .withWork("555");

    app.contact().modify(contact, false);
    app.goTo().homePage();
    Contacts after = app.db().contacts();

    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }
}
