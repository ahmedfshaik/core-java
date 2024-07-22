package edu.home.selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {7, 9, 3, 5, 1, 2};

        System.out.println(" Unsorted Array: " +Arrays.toString(array));

        int[] sortedArray = selectionSort(array);

        System.out.println(" Sorted Array: " +Arrays.toString(sortedArray));


        int[] array2 = {1, 3, 5, 7, 8, 9};

        System.out.println(" Unsorted Array: " +Arrays.toString(array2));

        int[] sortedArray2 = selectionSort(array2);

        System.out.println(" Sorted Array: " +Arrays.toString(sortedArray2));
    }

    private static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if(minIndex == 0){
                System.out.println("Sorted array came");
                return array;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;

    }
}
