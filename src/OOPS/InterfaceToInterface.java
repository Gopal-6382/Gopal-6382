/*
        package OOPS;

import java.lang.Override;

interface funk {
    // default in this every methods are public abstract
    final static int A = 25;

    public abstract void fun1();

    public abstract void fun2();

    private int fun6() {
        return A;
    }

    default int fun() {
        System.out.println("also you can use defualt also ");
        System.out.println("This method is access from private method");
        return fun6();
    }

    public static void fun3() {
        System.out.println("You can declare the  method in interface static void fun3");
    }

}

interface music extends funk {
    void fun4();
}

class Tester implements funk, music {

    @Override
    public void fun1() {
        System.out.println("This is defalut metion in that interface public abstract that defalut can't chaange");
    }


    @Override
    public void fun2() {
        System.out.println("This is defalut metion in that interface public abstract that defalut can't chaange");
    }

    @Override
    public int fun() {
        System.out.println("default method is possible run the method cant't mention method without default");
        return A;
    }

    @Override
    public void fun4() {
        System.out.println("This method from tester implement from music");
    }
}

public class interfaceTOinterface {
    public static void main(String[] args) {
        System.out.println("The value of interface value is " + funk.A);
        Tester t1 = new Tester();
        t1.fun();
        t1.fun1();
        t1.fun2();
        t1.fun4();

    }
}


 */

package OOPS;
import java.lang.Override;

/**
 * Demonstrates interface-to-interface inheritance and method types in Java (Java 9+).
 */

interface Funk {
    // Constant (implicitly public, static, and final)
    int A = 25;

    // Abstract methods (implicitly public and abstract)
    void fun1();
    void fun2();

    // Private method (Java 9+): can only be used inside default/static methods
    private int internalValue() {
        return A;
    }

    // Default method (Java 8+): provides implementation, can be overridden
    default int fun() {
        System.out.println("Default method in interface Funk.");
        System.out.println("Accessing private method from default method.");
        return internalValue();
    }

    // Static method (Java 8+): can be called via interface name
    static void fun3() {
        System.out.println("Static method in interface Funk.");
    }
}

// Interface inheritance
interface Music extends Funk {
    void fun4();
}

// Class implementing both interfaces (directly and indirectly)
class Tester implements Music {

    @Override
    public void fun1() {
        System.out.println("Overridden fun1() from Funk.");
    }

    @Override
    public void fun2() {
        System.out.println("Overridden fun2() from Funk.");
    }

    // Overriding default method
    @Override
    public int fun() {
        System.out.println("Overridden default fun() from Funk.");
        return A;
    }

    @Override
    public void fun4() {
        System.out.println("Implemented fun4() from Music.");
    }
}

public class InterfaceToInterface {
    public static void main(String[] args) {
        System.out.println("Interface constant value: " + Funk.A);

        Tester tester = new Tester();
        tester.fun();     // Calls overridden default method
        tester.fun1();    // Calls implemented abstract method
        tester.fun2();    // Calls implemented abstract method
        tester.fun4();    // Calls method from extended interface

        // Calling static method directly from interface
        Funk.fun3();
    }
}

