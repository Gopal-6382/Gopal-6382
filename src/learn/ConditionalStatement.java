package learn;

import java.util.Scanner;

public class ConditionalStatement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*

        int a = in.nextInt();
        if (a >= 18) {
            System.out.println("You are eligible for vote");
        }
        int year = in.nextInt();
        if (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0)) System.out.println("leap year ");
        else System.out.println("Not leap year");

        int m1, m2, m3, m4, m5;
        m1 = in.nextInt();
        m2 = in.nextInt();
        m3 = in.nextInt();
        m4 = in.nextInt();
        m5 = in.nextInt();

        float tot = (m1 + m2 + m3 + m4 + m5 / 5);
        int avg = (int) tot;
        if (avg > 95) System.out.println("A grade");
        else if (avg > 85) System.out.println("B grade");
        else if (avg > 75) System.out.println("B grade");
        else if (avg > 40) System.out.println("C grade");
        else System.out.println("You failed");
        System.out.print("Enter the Marital Status (M/U): ");
        char status = in.next().charAt(0);

        if (status == 'U' || status == 'u') {

            System.out.print("Enter the Gender (M/F): ");
            char gender = in.next().charAt(0);

            System.out.print("Enter the Age: ");
            int age = in.nextInt();

            if (((gender == 'M' || gender == 'm') && (age >= 30)) || ((gender == 'F' || gender == 'f') && (age >= 25))) {
                System.out.println("You are eligible to marry");
            } else {
                System.out.println("You are not eligible to married");
            }
        } else if (status == 'M' || status == 'm') {
            System.out.println("You are already  married");
        } else {
            System.out.println("Invalid married status ");
        }

        in.close();

        int days = 7;
        days = in.nextInt();
        switch (days) {
            case 6:
                System.out.println("The days is you choose Monday  day .");
                break;
            case 7:
                System.out.println("The days is you choose Monday  day .");
                break;
            case 1:
                System.out.println("The days is you choose Monday  day .");
                break;
            case 2:
                System.out.println("The days is you choose Tuesday  day .");
                break;
            case 3:
                System.out.println("The days is you choose Wednesday  day .");
                break;
            case 4:
                System.out.println("The days is you choose Thursday  day .");
                break;
            case 5:
                System.out.println("The days is you choose Friday  day .");
                break;
            default:
                System.out.println("The days is you choose invaild  day .");
                break;
        }

        char ch = in.next().charAt(0);
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("IS a VOEWEL");
                break;
            default:
                System.out.println("IS NO A VOEWEL");
                break;
        }

        int[] num = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int n : num) {
            System.out.println("The number is " + n);
        }
        System.out.println("----------------------------------------------");
        int[][] num1 = {{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}};

        for (int[] row : num1) {
            for (int val : row) {
                System.out.println("The number is " + val);
            }
        }


        int n = in.nextInt();
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println("the Fact is" + f);

        int h = in.nextInt();
        int s = 0;
        for (int i = 1; i <= h; i++) {
            int k = in.nextInt();
            s += k;
        }
        System.out.println("The Sum is = " + s);
        System.out.println("The Sum is = " + s / h);


        int n = 10; // Number of terms
        long a = 0, b = 1;

        System.out.print("Fibonacci Series: " + a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            long c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

        int num = 123456789;
        int rev = 0, lastnum = 0;
        while (num != 0) {
            lastnum = num % 10;
            rev = (rev * 10) + lastnum;
            num = num / 10;
        }
        System.out.println(rev);

        int number = 153;
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;

        // Find number of digits
        int digits = String.valueOf(num).length();

        while (num != 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == originalNum;


        int num = 153, sum = 0, og = num, digits = 0;
        digits = String.valueOf(num).length();
        int dig = 0;
        while (num > 0) {
            dig = num % 10;
            sum += Math.pow(dig, digits);
            num /= 10;
        }
        if (og == sum) {
            System.out.println("the number is amstrong");
        } else {
            System.out.println("the number is not amstrong");
        }
        int k1 = 1000;
        int f = 0;
        for (int i = 0; i < k1; i++) {
            for (int j = 1; j < i; j++) {
                if (j % k1 == 0) {
                    f++;
                    k1++;
                }
            }
        }
        if (k1 == 2) {
            System.out.println(k1);
        }
        int n = 1, f = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                f++;
            }
        }

        if (f == 2) {
            System.out.println("The number is prime");
        } else {
            System.out.println("The number is not prime");
        }
        for (int n = 1; n <= 999; n++) {
            if (isPrime(n)) {
                System.out.println(n + " ");
            }
        }
    }

    // learn.Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;

    }

    int f = 0;
        for(
    int n = 1;
    n <=999;n++)

    {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                f++;
            }
        }
        if (f == 2) {
            System.out.println("prime is" + n);
        }
        f = 0;
    }

        for(
    long u = 1;
    u<1000000000;u++)

    {
        long sum = 0;
        for (long i = 1; i < u; i++) {
            if (u % i == 0) {
                sum += i;
            }
        }
        if (sum == u) {
            System.out.println("Perfect number are= " + sum);
        }
    }
        for(
    long u = 1;
    u <=34000000;u++)

    {
        long sum = 0;
        for (long i = 1; i <= u / 2; i++) {
            if (u % i == 0) {
                sum += i;
            }
        }
        if (sum == u) {
            System.out.println("Perfect number are= " + u);
        }
    }

    long[] perfectNumbers = {6, 28, 496, 8128, 33550336}; // Known perfect numbers < 1B
                for(
    long num :perfectNumbers)

    {
        System.out.println("Perfect number are= " + num);
    }


    int num = 145;
    int og = num;
    int sum = 0;

        while(num >0)

    {
        int rem = num % 10;
        int fact = 1;
        for (int i = 1; i <= rem; i++) {
            fact *= i;
        }

        sum += fact;
        num /= 10;
    }

        if(sum ==og)

    {
        System.out.println(og + " is a Strong Number");
    } else

    {
        System.out.println(og + " is NOT a Strong Number");
    }


                int num,originalNum,rem,fact,i,sum=0;
                System.out.println("Enter a number : ");
                num=in.nextInt();
                originalNum=num;
                while (num>0)//145>0  14>0 1>0
                {
                    rem=num%10;
                    System.out.println("Reminder : "+rem);
                    fact=1;
                    for(i=1;i<=rem;i++){
                        fact*=i;//fact=fact*i
                    }
                    System.out.println("fact : "+fact);
                    sum+=fact;
                    num=num/10;
                    System.out.println("fact : "+fact);
                }
        System.out.println("sum : "+sum);

                if (sum == originalNum) {
                    System.out.println(originalNum + " is STRONG NUMBER");
                } else {
                    System.out.println(originalNum + " is not a STRONG NUMBER");
                }


        int n[] = new int[10];// default values will be 0
        int a;
        for (int i = 0; i < n.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                n[j] = j;
            }
            System.out.println(n[j]); // ✅ print each element
        }

         */
            }
        }

