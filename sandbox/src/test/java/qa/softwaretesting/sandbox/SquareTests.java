package qa.softwaretesting.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by paulgladoon on 16.05.17.
 */
public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }
}
