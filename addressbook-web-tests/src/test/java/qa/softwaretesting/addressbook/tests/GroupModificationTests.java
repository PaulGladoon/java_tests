package qa.softwaretesting.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.addressbook.model.GroupData;
import qa.softwaretesting.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("test1")
            .withHeader("test2")
            .withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();

    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }
}
