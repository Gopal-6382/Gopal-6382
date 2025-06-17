package learn;

import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=0;
        int p=in.nextInt();
        for(int i=1;i<=p;i++) {
            if (p%i==0){
                k++;
            }}
            if(k==2){
                System.out.println("this is prime number "+p);
            }
            else{
                System.out.println("not a prime"+p);
            }
            k=0;

    }
}
