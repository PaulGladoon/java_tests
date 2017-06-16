package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().addNewContact();
    ContactData contact = new ContactData()
            .withFirstName("Alex")
            .withMiddleName("Popov")
            .withGroup("test1")
            .withLastName("Niclolaev")
            .withNickname("Goblin")
            .withTitle("Tool")
            .withCompany("DoIt")
            .withAddress("Propov")
            .withHome("Odessa")
            .withMobile("3355533")
            .withWork("QA")
            .withFax("44556677")
            .withEmail("a@a.com")
            .withHomepage("www.aaa.aa")
            .withYear("1989")
            .withYear2("33333")
            .withAddress2("Dobr")
            .withPhone2("3334455")
            .withNotes("asdasd");

    app.contact().create(contact, true);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
