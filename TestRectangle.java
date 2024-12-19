class Rectangle {
  private int w,h;     //w:width, h: height
  
  public Rectangle(int w, int h){
    if(w < 0){
      System.out.println("Warning: input width is negative!");
      w =1;
    }
    if(h < 0){
      System.out.println("Warning: input height is negative!");
      h = 1;
    }

    this.w = w;
    this.h = h;
  }

  public int getWidth(){
    return w;
  }

  public int getHeight(){
    return h;
  }

  public void visualize(){
    for (int r = 0; r < h; r++){
      for ( int c = 0; c<w; c++){
        System.out.println("*");
      }
      System.out.println();
    }
  }
  }
  public class TestRectangle{
    public static void main(String[] args){
      Rectangle r1 = new Rectangle(6, 10);
      System.out.println("Visualization of r1: ");
      r1.visualize();
      Rectangle r2 = new Rectangle(5,4);
      System.out.println("Visualization of r2: ");
      r2.visualize();
      Rectangle r3 = new Rectangle(-4, -5);
      System.out.println("Visualization of r3: ");
      r3.visualize();
      Rectangle r4 = new Rectangle(2, -3);
      System.out.println("Visualization of r4: ");
      r4.visualize();
      Rectangle r5 = new Rectangle(-2, 3);
      System.out.println("Visualization of r5: ");
      r5.visualize();
    }
  }
