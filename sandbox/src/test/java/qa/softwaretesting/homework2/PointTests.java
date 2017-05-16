package qa.softwaretesting.homework2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by paulgladoon on 16.05.17.
 */
public class PointTests {

  @Test
  public void testDistance() {

    // prepare
    Point test1 = new Point(10, 15);
    Point test2 = new Point(15, 10);

    // assert
    Assert.assertEquals(test1.distance(test2), 7.0710678118654755);
    Assert.assertNotEquals(test1.distance(test2), 10);
    Assert.assertNotNull(test1.distance(test2));
  }
}
