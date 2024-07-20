package edu.home.bubblesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {7, 9, 3, 5, 1, 2};

        int[] sortedArray = bubbleSort(array);

        System.out.println(Arrays.toString(sortedArray));

        int[] array2 = {1, 3, 5, 7, 8, 9};

        int[] sortedArray2 = bubbleSort(array2);

        System.out.println(Arrays.toString(sortedArray2));
    }

    private static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            boolean isSortedAlready = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isSortedAlready = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (isSortedAlready) {
                return array;
            }
        }

        return array;
    }
}
