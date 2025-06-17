package learn;

import java.lang.*;

public class Operator {
    public static void main(String args[]){
           int a=100;
           int b=50;
        System.out.println("Addtion ="+(a+b));
        System.out.println("Subtraction =" + (a-b));
        System.out.println("Multiplication ="+ (a*b));
        System.out.println("Divisino ="+ (a/b));
        System.out.println("Modules ="+ (a%b));

        System.out.println("Sorthand assingnment operator =");
        System.out.println("Sorthand assingnment operator ="+ (a+=b));
        System.out.println("Sorthand assingnment operator ="+ (a-=b));
        System.out.println("Sorthand assingnment operator = "+ (a%=b));
        System.out.println("Sorthand assingnment operator ="+ (a*=b));
        System.out.println("Sorthand assingnment operator= "+ (a/=b));


        System.out.println("Relational  operator ");
        System.out.println("Relational  operator ="+ (a<b));
        System.out.println("Relational  operator ="+ (a>b));
        System.out.println("Relational operator  ="+ (a==b));
        System.out.println("Relational operator ="+ (a!=b));
        System.out.println("Relational  operator= "+ (a>=b));

        System.out.println("Logical   operator ");
        int m1=40,m2=35;
        System.out.println("Logical   operator " + (m1>35 && m2>35));
        System.out.println("Logical   operator " + (m1>35 || m2>35));

        System.out.println("Ternary    operator ");
        int g=10,l=20;
        String t=a>b?"g is great ":"l is great ";
         System.out.println("Logical   operator "+t);

        System.out.println("Unary   operator ");
        int i=0;
        System.out.println("Unary  operator =  " + i);
        System.out.println("Unary  operator =  " + ++i);
        System.out.println("Unary  operator =  " + ++i);
        System.out.println("Unary  operator =  " + i--);
        System.out.println("Unary  operator =  " + --i);


        System.out.println("Bitwise  operator ");
        int bit=29,shit=90;
        /*   0001 1101   (29)
&            0101 1010   (90)
           -------------
             0001 1000   = 24
*/
        System.out.println("Bitwise operator =  " + (bit&shit));
        /*   0001 1101   (29)
|            0101 1010   (90)
            -------------
             0101 1111   = 95
*/
        System.out.println("Bitwise operator =  " + (bit|shit));
        /*   0001 1101   (29)
^            0101 1010   (90)
             -------------
             0100 0111   = 71
*/
        System.out.println("Bitwise operator =  " + (bit^shit));
        /*~0000 0000 0000 0000 0000 0000 0001 1101
        =  1111 1111 1111 1111 1111 1111 1110 0010
*/
        System.out.println("Bitwise operator =  " + (~bit));



    }
}
