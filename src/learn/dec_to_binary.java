package learn;

import java.util.Scanner;

public class dec_to_binary {

    public static void Dectobin(int n){
        int[] bin = new int[1000];
        int i;

        for (i = 0; n > 0; i++) {
            bin[i] = n % 2;
            n = n / 2;
        }

        System.out.print("Binary: ");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(bin[j]);
        }
        System.out.println(); // For new line
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter The Decimal No: ");
        int n = in.nextInt();
        System.out.println("Decimal Number: " + n);
        Dectobin(n);
    }
}
