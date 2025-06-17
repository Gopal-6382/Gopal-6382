package learn;

import java.util.Arrays;
import java.util.Scanner;

class Method {
    public void add() {
        int a = 123;
        int b = 10;
        System.out.println("Addition: " + (a + b));
    }

    public void sub(int x, int y) {
        System.out.println("Subtraction: " + (x - y));
    }

    int mul() {
        return 10 * 20;
    }

    int div(int x, int y) {
        if (y == 0) return 0;
        return x / y;
    }

    int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }
}

public class Methods {
    public static int[] arr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            b[i] = in.nextInt();
        }
        Arrays.sort(b);
        return b;
    }

    public static void main(String[] args) {
        Method o = new Method();  // Create object

        // Call all methods
        o.add();                            // Add method
        o.sub(12, 5);                       // Subtract method
        System.out.println("Mul: " + o.mul());
        System.out.println("Div: " + o.div(900, 30));
        System.out.println("Fact: " + o.fact(5));

        int[] sortedArr = arr();           // Call arr method
        System.out.println("Sorted Array:");
        for (int num : sortedArr) {
            System.out.println(num);
        }
    }
}
