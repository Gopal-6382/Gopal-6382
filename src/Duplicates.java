public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 3, 2, 5, 5, 6, 6, 2, 4, 1};
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) System.out.println("Duplicate: " + arr[i]);
        char ch = 'A';
        System.out.println("ASCII of " + ch + " = " + (int) ch);
    }
}
