package OOPS;
final class classdemo{
    void display(){
        System.out.println("final class can't exntend inherits only used for main class i mean  call in main clas");
    }
}
public class FinalCls {
    public static void main(String[] args) {
        classdemo obj=new classdemo();
        obj.display();
    }
}
