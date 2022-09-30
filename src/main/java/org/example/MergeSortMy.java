package org.example;


/**
 * First level: Удалить весь написанный код для сортировки слиянием - написать с нуля на Java или JavaScript
 */

public class MergeSortMy {

    public static void main(String[] args) {

        int[] arr = {13, 5, 7, 25, 12, 108, 33, 1, 14, 45, 14};
        createLogic(arr);
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] +" " );
        }

    }
    public static void createLogic(int []arr) {
        int center = arr.length / 2;
        if (arr.length==1) {
            return;
        }
        int[] left = new int[center];
        int[] right = new int[arr.length - center];



        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + center];
        }

        createLogic(left);
        createLogic(right);
        sort(arr, left, right);

    }

    private static void sort(int [] arr, int [] left, int [] right) {
        int arrIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex<left.length && rightIndex<right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex]=left[leftIndex];
                leftIndex++;
            }
            else {
                arr[arrIndex]=right[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }

        while (leftIndex<left.length) {
            arr[arrIndex]=left[leftIndex];
            leftIndex++;
            arrIndex++;
        }
        while (rightIndex<right.length) {
            arr[arrIndex]=right[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }


}
