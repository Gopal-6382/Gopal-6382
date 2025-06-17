package OOPS;

class staticTest {
    static int x = 10;
    public int a;
    int b = 20;

    void show() {
        System.out.println("b variable " + b);
        System.out.println("Static variable " + x);

    }

    static void display() {
        System.out.println("Static variable " + x);
    }
}

public class stat_vari_methods {
    public static void main(String[] args) {
        staticTest obj = new staticTest();
        obj.show();
        staticTest.display();
        obj.x = 30;
        System.out.println("Non static variable " + obj.x );
        obj.x = 10;
        obj.show();

    }
}
