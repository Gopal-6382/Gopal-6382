public class InsertElement {
    public static void main(String[] args) {
        int[] arr = new int[6];
        int[] data = {1, 2, 4, 5, 6};
        System.arraycopy(data, 0, arr, 0, 5);
        int pos = 2, value = 3;
        for (int i = 5; i > pos; i--) arr[i] = arr[i - 1];
        arr[pos] = value;
        for (int i : arr) System.out.print(i + " ");
    }
}
