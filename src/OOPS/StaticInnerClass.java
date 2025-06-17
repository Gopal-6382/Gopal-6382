package OOPS;

class OuterClass {
    static int x = 20;
    int y = 22;

    static class InnerClass {
        void display() {
            System.out.println("Inner class" + x);
        }
    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        OuterClass.InnerClass obj = new OuterClass.InnerClass();
        obj.display();
    }
}
