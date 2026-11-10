public class Primitive{
  public static void main(String args[]){
    int a = 38;

    Integer obj = a;

    int b = obj;

    System.out.println("Primitive value:" + a);
    System.out.println("wrapper value:" + obj);
    System.out.println("unboxing value:" + b);
  } 
}