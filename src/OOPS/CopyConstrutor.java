package OOPS;

class Complex {
    int real, img;

    Complex() {
        real = 1;
        img = 1;
    }

    Complex(int a, int b) {
        {
            this.real = a;
            this.img = b;
        }
    }


    public String toString() {
        return "(" + real + "+" + img + "i)";
    }

    public Complex(Complex c2) {
        //c3.real = this.real + this.real;
        //c3.img = this.img + this.img;
        this.real += c2.real;
        this.img += c2.img;
        //return c3;
    }
}

public class CopyConstrutor {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        System.out.println(c1);
        Complex c2 = new Complex(10, 20);
        System.out.println(c2);
        Complex c3 = new Complex(c2);
        System.out.println("Copy Constructor called");
        System.out.println(c3);
    }
}
