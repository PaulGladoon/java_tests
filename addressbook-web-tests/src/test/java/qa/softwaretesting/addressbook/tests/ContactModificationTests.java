package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
//  @BeforeMethod
//  public void ensurePreconditions() {
//    if (app.contact().all().size() == 0) {
//      app.goTo().addNewContact();
//      app.contact().create(new ContactData()
//              .withFirstName("Alex")
//              .withMiddleName("Popovich"), true);
//    }
//  }
//
//  @Test(enabled = false)
//  public void testContactModification() {
//    app.goTo().homePage();
//    Contacts before = app.contact().all();
//    app.contact().selectContact(0);
//    ContactData contact = new ContactData(before.get(0).getId());
//    app.contact().fillContactForms(contact, false);
//    app.contact().updateContactCreation();
//    app.goTo().homePage();
//    List<ContactData> after = app.contact().getContactList();
//    Assert.assertEquals(after.size(), before.size());
//
//    before.remove(0);
//    before.add(contact);
//    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//    before.sort(byId);
//    after.sort(byId);
//    Assert.assertEquals(before, after);
//  }
}
