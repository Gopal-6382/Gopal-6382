package OOPS;

import java.util.Arrays;

class Outer1 {
    int outer = 20;

    class Inner {
        int inner = 10;

        void innerdisplay() {
            System.out.println("This is outer variable: " + outer);
            System.out.println("This is inner variable: " + inner);
            System.out.println("This is inner class method.");
        }
    }

    void outerdisplay() {
        System.out.println("This is outer class method.");
        Inner i = new Inner();
        i.innerdisplay();
        System.out.println("The inner variable from outer method "+ i.inner);
    }
}

public class Nested_Inner_Class {
    public static void main(String[] args) {
        Outer1 o = new Outer1();
        o.outerdisplay();
        Outer1.Inner i = o.new Inner();
        System.out.println("-----------------------------------------------------------------------------------------------");
        i.innerdisplay();
    }
}
