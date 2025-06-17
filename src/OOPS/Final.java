package OOPS;

class fina {
    final int a = 10;
    final int b;
    final int c;

    fina(int c) {
        this.c = c;
        b = 20;
    }

    void display() {
        System.out.println("This is final a = " + a + " b = " + b + " c = " + c + "");
    }
}

public class Final {
    public static void main(String[] args) {
        fina obj = new fina(30);
        obj.display();
    }
}
