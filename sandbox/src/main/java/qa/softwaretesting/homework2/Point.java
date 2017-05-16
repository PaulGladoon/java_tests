package qa.softwaretesting.homework2;

/**
 * Created by paulgladoon on 15.05.17.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

//  2.2 TASK
//  public static double distance(Point point1, Point point2) {
//    return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
//  }

//  2.4 TASK
  public double distance(Point point) {
    return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
  }
}

