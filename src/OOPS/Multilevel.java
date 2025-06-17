package OOPS;
class GrandFather{
  public   Void Land(){
        System.out.println("GrandFather Land");
        return null;
    }
}
class Father extends GrandFather{
    public Void House(){
        System.out.println("Father House");
        return null;
    }
}
class Son extends Father{
    public Void Car(){
        System.out.println("Son Car");
        return null;
    }
}
public class Multilevel {
    public static void main(String[] args) {
        Son s=new Son();
        s.Land();
        s.House();
        s.Car();
    }
}
