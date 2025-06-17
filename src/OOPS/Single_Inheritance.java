package OOPS;
class Parent {
    public void house(){
        System.out.println("This is Father's house");
    }
}
class Child extends Parent{
    public void car(){
        System.out.println("This is son's car");
    }
}
public class Single_Inheritance {
    public static void main(String[] args) {
        //Parent c=new Parent();
        Child c=new Child();
        c.house();
        c.car();
    }
}
