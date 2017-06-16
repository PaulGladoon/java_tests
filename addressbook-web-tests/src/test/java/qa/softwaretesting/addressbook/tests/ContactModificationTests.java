package qa.softwaretesting.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.goTo().gotoAddNewContactPage();
      app.getContactHelper().contactCreation(new ContactData("Paul", "Gladoon", "test1","Nickolayevich", "Reopen", "Gogo", "DoIT", "Dobrovolskogo", "Odessa", "063", "IT", "2211", "p@p", "www.w.com", "1989", "2017", "Grree", "1122", "test"), true);
    }
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    ContactData contact = new ContactData(
            before.get(0).getId(),
            "Lex",
            "Gladoon",
            null,
            "Nickolayevich",
            "Reopen",
            "Gogo",
            "DoIT",
            "Dobrovolskogo",
            "Odessa",
            "063",
            "IT",
            "2211",
            "p@p",
            "www.w.com",
            "1989",
            "2017",
            "Grree",
            "1122",
            "test"
    );
    app.getContactHelper().fillContactForms(contact, false);
    app.getContactHelper().updateContactCreation();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
