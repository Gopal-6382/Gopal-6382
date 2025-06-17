public class SumAverage {
    public static void main(String[] args) {
        int n = 5, sum = 0;
        int[] arr = {1, 2, 3, 4, 5};
        for (int num : arr) sum += num;
        double avg = (double) sum / arr.length;
        System.out.println("Sum = " + sum + ", Average = " + avg);
    }
}
