package qa.softwaretesting.addressbook.tests;


import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.ContactData;
import qa.softwaretesting.addressbook.model.Groups;

import java.io.File;

public class ContactCreationWithPhotoTests extends TestBase {

  @Test
  public void testContactCreationWithPhotoTests() {
    Groups groups = app.db().groups();
    app.goTo().addNewContact();
    File photo = new File("src/test/resources/doiticon.png");
    ContactData contact = new ContactData()
            .withFirstName("Alex")
//            .withGroup("test1")
            .withPhoto(photo)
            .inGroup(groups.iterator().next());

    app.contact().create(contact, true);
    app.goTo().homePage();

  }
}


