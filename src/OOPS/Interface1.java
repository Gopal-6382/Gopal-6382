package OOPS;

import java.lang.Override;

interface intf{
   // public abstract void sound() no need to metion that already abstract and andp public
   void sound();
    void sleep();

}
class Dog implements intf {

    @Override
    public void sound() {
        System.out.println("Dog Sounds like : wooof ");
    }

    @Override
    public void sleep() {
        System.out.println("Dog Sleeping ");
    }
}
public class Interface1 {
    public static void main(String[] args) {
        Dog d=new Dog();
        d.sleep();
        d.sound();
        String  n= new intf() {
            @Override
            public void sound() {

            }

            @Override
            public void sleep() {

            }
        }.toString();
    }
}
