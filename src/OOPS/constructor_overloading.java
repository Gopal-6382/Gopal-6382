package OOPS;

class cons {
    float length, breadth;

    cons() {
        length = 10;
        breadth = 20;
    }

    cons(float x, float y) {
        {
            length = x;
            breadth = y;
        }
    }

    cons(int x) {
        {
            length = breadth = x;
        }
    }

    float area() {
        return length * breadth;
    }
}

public class constructor_overloading {
    public static void main(String[] args) {
        cons c1 = new cons();
        cons c2 = new cons(10, 202);
        cons c3 = new cons(100);
        System.out.println("Defalut constructor called");
        System.out.println(c1.area());
        System.out.println("Parameterized constructor called");
        System.out.println(c2.area());
        System.out.println("Constructor Overloading called");
        System.out.println(c3.area());
    }
}