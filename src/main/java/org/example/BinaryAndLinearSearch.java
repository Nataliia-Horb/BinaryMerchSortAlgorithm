package org.example;

import java.util.Arrays;
import java.util.Random;

public class BinaryAndLinearSearch {
    public static void main(String[] args) {
        int[] arr1 = assemblyArray(100, 100);
        int[] arr2 = assemblyArray(10, 10);
        int[] arr3 = assemblyArray(1000, 500);
        int[] arr4 = assemblyArray(10000, 555);
        calcEfficiency(arr1, 65);
        calcEfficiency(arr2, 5);
        calcEfficiency(arr3, 50);
        calcEfficiency(arr4, 220);

    }

    private static int linearSearch(int[] arr, int leftIdx, int rightIdx, int key) {
        for (int i = leftIdx; i <= rightIdx; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        System.out.println("Number not found");
        return -1;
    }

    private static int binarySearch(int[] arr, int leftIdx, int rightIdx, int key) {
        if (rightIdx >= leftIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (arr[midIdx] == key) {
                return midIdx;
            }
            if (key > arr[midIdx]) {
                return binarySearch(arr, midIdx + 1, rightIdx, key);
            }
            return binarySearch(arr, leftIdx, midIdx - 1, key);
        }
        System.out.println("Number not found");
        return -1;
    }

    public static void calcEfficiency(int[] arr, int key) {
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Find a number: " + key);

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        long startTime1 = System.nanoTime();
        System.out.println("Linear search result: " + linearSearch(arr, leftIdx, rightIdx, key));
        System.out.println("Linear algorithm execution time Nano Seconds: " + (System.nanoTime() - startTime1));

        long startTime2 = System.nanoTime();
        System.out.println("Binary search result: " + binarySearch(arr, leftIdx, rightIdx, key));
        System.out.println("Binary algorithm execution time Nano Seconds: " + (System.nanoTime() - startTime2));
        System.out.println();
    }

    private static int[] assemblyArray(int length, int max) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

}

