package OOPS;

import java.lang.Override;
//also is possible change interface
abstract class testDemo {
    abstract void test();
}

class outerDemo {
    public void test() {
        testDemo obj = new testDemo() {
            @Override
            public void test() {
                System.out.println("Anonymous Inner Class");
            }
        };
        obj.test();
    }
}

public class anonymousInner {
    public static void main(String[] args) {
        outerDemo obj = new outerDemo();
        obj.test();
    }
}
