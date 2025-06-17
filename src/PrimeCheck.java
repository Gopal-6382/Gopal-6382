public class PrimeCheck {
    public static void main(String[] args) {
        int n = 29;
        boolean prime = true;
        for (int i = 2; i <= 29 / 2; i++)
            if (n % i == 0) {
                prime = false;
                break;
            }
        System.out.println(prime ? "Prime" : "Not Prime");
    }
}
