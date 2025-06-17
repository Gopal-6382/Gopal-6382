package OOPS;

class Shapes {
    float length, breadth, radius;
}

// Rectangle class
class Rectangle extends Shapes {
    Rectangle(float x, float y) {
        length = x;
        breadth = y;
    }

    public float area() {
        return length * breadth;
    }
}

// Circle class
class Circle extends Shapes {
    Circle(float r) {
        radius = r;
    }

    public float area() {
        return 3.14f * radius * radius;
    }
}

// Triangle class
class Triangle extends Shapes {
    Triangle(float b, float h) {
        breadth = b;
        length = h;
    }

    public float area() {
        return 0.5f * breadth * length;
    }
}

public class HiraricalInheritance {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Circle circle = new Circle(7);
        Triangle triangle = new Triangle(4, 6);

        System.out.println("Rectangle Area: " + rect.area());
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Triangle Area: " + triangle.area());
    }
}
