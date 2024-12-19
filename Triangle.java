 import java.util.Scanner;
 public class Triangle {
    private int a,b,c;
public Triangle(int x, int y, int z){
  a=x;
  b=y;
  c=z;
}
public int geta(){
  return a;
}
public int getb(){
  return b;
}
public int getc(){
  return c;
}
public String verify(){
  if(a==b && b==c){
    return " Equilateral Triangle";
  }
  else if((a==b && b!=c)||(a==c && a!=c)||(b==c && a!=c)){
    return " Isosceles Triangle";
  }
  else if ((a>=(b+c))||(b>=(a+c))||(c>=(b+a))){
    return "Not Triangle";
  }
  else if ( a!=b && b!=c && c!=a){
    return "Scalene Triangle";
  }
  else{
    return "Not Triangle";
  }
}
public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);

  System.out.println("Enter 3 numvers for the side of a triangle: ");
  int a= scanner.nextInt();
  int b= scanner.nextInt();
  int c= scanner.nextInt();
  Triangle triangle = new Triangle(a,b,c);
  String triangleType = triangle.verify();
  System.out.println("Triangle type: " + triangleType);

  scanner.close();
}
}