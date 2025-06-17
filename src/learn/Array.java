package learn;

import java.util.Arrays;

public class
Array {

    public static void main(String[] args) {

        // 1. Print even numbers
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Even numbers:");
        for (int r : arr1) {
            if (r % 2 == 0) {
                System.out.println(r);
            }
        }

        // 2. Sort array using bubble sort (ascending)
        int[] arr2 = {8, 9, 7, 3, 5, 3, 7, 3, 27, 7, 10, 20, 40, 30, 2, 5, 7, 1, 3, 6, 1, 50};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i] > arr2[j]) {
                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr2));

        // 3. Insert element at a specific index
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = 2;
        int value = 2;
        for (int o = arr3.length - 1; o > index; o--) {
            arr3[o] = arr3[o - 1];
        }
        arr3[index] = value;
        System.out.println("After inserting at index " + index + ":");
        System.out.println(Arrays.toString(arr3));

        // 4. Find duplicates in array
        int[] arr4 = {1, 2, 5, 5, 6, 6, 7, 2};
        System.out.println("Duplicate elements:");
        for (int i = 0; i < arr4.length - 1; i++) {
            for (int j = i + 1; j < arr4.length; j++) {
                if (arr4[i] == arr4[j] && i != j) {
                    System.out.println(arr4[j]);
                }
            }
        }

        // 5. Sort and print array using Arrays.toString
        int[] arr5 = {8, 2, 9, 7, 33, 3, 87};
        Arrays.sort(arr5);
        System.out.println("Before sort: [8, 2, 9, 7, 33, 3, 87]");
        System.out.println("After sort: " + Arrays.toString(arr5));
    }
}
