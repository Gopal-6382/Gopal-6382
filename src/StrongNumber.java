public class StrongNumber {
    public static void main(String[] args) {
        int n = 145, temp = n, sum = 0;
        while (n != 0) {
            int digit, fact = 1;
            digit = n % 10;
            for (int i = 1; i <= digit; i++) fact *= i;
            sum += fact;
            n /= 10;
        }
        System.out.println(temp == sum ? "Strong" : "Not Strong");
    }
}
