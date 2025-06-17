package oreters;// Filename: oreters.CoreConceptsDemo.java

public class CoreConceptsDemo {

    public static void main(String[] args) {
        System.out.println("----- Primitive Type (Pass by Value) -----");
        int a = 10;
        modifyPrimitive(a);
        System.out.println("After modifyPrimitive, a = " + a); // 10

        System.out.println("\n----- Object Reference (Pass by Value of Reference) -----");
        Person person = new Person("Gopal");
        modifyObject(person);
        System.out.println("After modifyObject, person.name = " + person.name); // Changed to "Beerbal"

        System.out.println("\n----- Reassigning Object in Method -----");
        resetPerson(person);
        System.out.println("After resetPerson, person.name = " + person.name); // Still "Beerbal"

        System.out.println("\n----- Immutable String Behavior -----");
        String name = "Gopal";
        modifyString(name);
        System.out.println("After modifyString, name = " + name); // Gopal

        System.out.println("\n----- Scope Demo -----");
        scopeDemo();

        // Stack vs Heap explained via comments and structure
        System.out.println("\n----- Stack vs Heap Concept -----");
        explainMemory();
    }

    // Pass by value with primitive
    static void modifyPrimitive(int x) {
        x = 99;
        System.out.println("Inside modifyPrimitive, x = " + x);
    }

    // Pass by value of reference
    static void modifyObject(Person p) {
        p.name = "Beerbal"; // This changes the original object's field
        System.out.println("Inside modifyObject, p.name = " + p.name);
    }

    // Reassigning object inside method
    static void resetPerson(Person p) {
        p = new Person("New oreters.Person"); // Local change only
        System.out.println("Inside resetPerson, p.name = " + p.name);
    }

    // Immutable object example
    static void modifyString(String s) {
        s = "Beerbal"; // New object is created, original not affected
        System.out.println("Inside modifyString, s = " + s);
    }

    // Variable scope demo
    static void scopeDemo() {
        int outer = 10; // Outer scope
        System.out.println("Outer scope variable = " + outer);
        if (true) {
            int inner = 20; // Block scope
            System.out.println("Inner block variable = " + inner);
        }
        // System.out.println(inner); // ❌ Error: inner not visible here
    }

    // Memory explanation
    static void explainMemory() {
        int number = 5; // Stored in Stack
        String text = "Gopal"; // String pool (Heap)
        Person p = new Person("StackToHeap"); // p is in Stack; object is in Heap
        System.out.println("number (primitive in stack) = " + number);
        System.out.println("text (String, immutable in heap) = " + text);
        System.out.println("p.name (Object in heap, reference in stack) = " + p.name);
    }
}

// Simple class with one field
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
