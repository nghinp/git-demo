import java.lang.Math;
import java.util.Scanner;

class Point {
  private double x,y; 

  public Point( double x, double y){
    this.x = x;
    this.y = y;
  }
  public double dis(Point target){    // dis: distance
    double delX = this.x -target.getx();
    double delY = this.y -target.gety();
    return Math.sqrt(delX*delX + delY*delY);
  }
  public double getx(){
    return x;
  }
  public double gety(){
    return y;
  }
}

public class TestPoint{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter first point x and y: ");
    double xa = scanner.nextDouble();
    double ya = scanner.nextDouble();
    Point X = new Point(xa, ya);
    System.out.println("Enter second point x and y: ");
    double xb = scanner.nextDouble();
    double yb = scanner.nextDouble();
    Point Y = new Point(xb, yb);
    double disXY = X.dis(Y);
    System.out.println("Distance between X and Y: " + disXY);

    scanner.close();
  }
}