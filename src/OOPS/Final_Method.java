package OOPS;

class Super {
    final void method() {
        System.out.println("I am final Super class can't override");
    }

    void method1() {
        System.out.println("I am Super class");
    }
}

class Sub extends Super {
    public void method1() {
        System.out.println("I am Sub class");
    }
   // public void method() {   System.out.println("I am Sub class"); }

}

public class Final_Method {
    public static void main(String[] args) {
        Sub obj = new Sub();
        obj.method1();
        obj.method();
        Super obj1 = new Super();
        obj1.method1();
    }
}
