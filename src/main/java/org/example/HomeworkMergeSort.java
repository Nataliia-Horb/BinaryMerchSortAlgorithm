package org.example;


import java.util.Arrays;

/**
 * Second level: Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
 * который будет находиться на k-й позиции в конечном отсортированном массиве.
 * Массив 1 - 100 112 256 349 770
 * Массив 2 - 72 86 113 119 265 445 892
 * к = 7
 * Вывод : 256
 * Окончательный отсортированный массив -
 * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 * 7-й элемент этого массива равен 256.
 */


public class HomeworkMergeSort {

    public static void main(String[] args) {
        int[] arr1 = new int[]{100, 112, 256, 349, 770};
        int[] arr2 = new int[]{72, 86, 113, 119, 265, 445, 892};
        int element = 892;

        int[] arrRes = join(arr1, arr2);
        sort(arrRes);
        System.out.println(Arrays.toString(arrRes));

        findElement(arrRes, element);
    }

    public static int[] join(int[] arr1, int[] arr2) {
        int[] arrRes = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arrRes, 0, arr1.length);
        System.arraycopy(arr2, 0, arrRes, arr1.length, arr2.length);
        return arrRes;

    }

    public static void sort(int[] arr) {
        int center = arr.length / 2;
        if (arr.length == 1) {
            return;
        }
        int[] left = createArr(arr, 0, center);
        int[] right = createArr(arr, center, arr.length);

        sort(left);
        sort(right);
        logic(arr, left, right);

    }

    private static int[] createArr(int[] arr, int arrStartInd, int arrEndInd) {
        int[] subArr = new int[arrEndInd - arrStartInd];
        for (int i = 0; i < subArr.length; i++) {
            subArr[i] = arr[arrStartInd];
            arrStartInd++;
        }
        return subArr;
    }

    private static void logic(int[] arr, int[] left, int[] right) {
        int leftInd = 0;
        int rightInd = 0;
        int resInd = 0;
        while (leftInd < left.length && rightInd < right.length) {
            if (left[leftInd] < right[rightInd]) {
                arr[resInd] = left[leftInd];
                leftInd++;
            } else {
                arr[resInd] = right[rightInd];
                rightInd++;
            }
            resInd++;
        }
        while (leftInd < left.length) {
            arr[resInd] = left[leftInd];
            leftInd++;
            resInd++;

        }
        while (rightInd < right.length) {
            arr[resInd] = right[rightInd];
            rightInd++;
            resInd++;
        }
    }

    private static int binarySearch(int[] arr, int leftInd, int rightInd, int element) {
        int midInd;
        if (rightInd >= leftInd) {
            midInd = leftInd + (rightInd - leftInd) / 2;
            if (arr[midInd] == element) {
                return midInd;
            }
            if (element > arr[midInd]) {
                return binarySearch(arr, midInd + 1, rightInd, element);
            } else {
                return binarySearch(arr, leftInd, midInd - 1, element);
            }
        }
        return -1;
    }

    public static int findElement(int[] arr, int element) {
        int position = binarySearch(arr, 0, arr.length - 1, element) + 1;
        if (position > 0) {
            System.out.println("Element " + element + " is " + position + " in order");
            return position;
        }

        System.out.println("Number not found");
        return -1;
    }

}
