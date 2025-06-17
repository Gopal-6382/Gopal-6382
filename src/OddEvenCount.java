public class OddEvenCount {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8};
        int odd = 0, even = 0;
        for (int i : arr) {
            if (i % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Odd: " + odd + ", Even: " + even);
    }
}
