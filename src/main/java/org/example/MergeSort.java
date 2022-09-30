package org.example;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
int [] arr= {15,21,13,5,10,7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr) {
        int lengthArr=arr.length;

        if (lengthArr==1) {
            return;
        }
        int mid=lengthArr/2;
        int [] leftArr=new int[mid];
        int [] rightArr=new int [lengthArr-mid];


        // copy elements to left right arr
        for (int i=0; i<mid; i++) {
            leftArr[i]=arr[i];
        }

        for (int i=0; i<lengthArr-mid; i++) {
            rightArr[i]=arr[mid+i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        //делим до 1 го элемента 15 21 13 5 10 7
        merge(arr, leftArr, rightArr);

    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLength= leftArr.length;
        int rightArrLength= rightArr.length;

        //контролируем индексы основного масиваб левого и правого
        int arrIndex=0;
        int leftIndex=0;
        int rightIndex=0;


    while (leftIndex<leftArrLength && rightIndex<rightArrLength) {
        if (leftArr[leftIndex]<rightArr[rightIndex]) {
            arr[arrIndex]=leftArr[leftIndex];
            arrIndex++;
            leftIndex++;
        }
        else {
            arr[arrIndex]=rightArr[rightIndex];
            arrIndex++;
            rightIndex++;
        }
    }
    while (leftIndex<leftArrLength) {
        arr[arrIndex]=leftArr[leftIndex];
        leftIndex++;
        arrIndex++;
    }
    while (rightIndex<rightArrLength) {
        arr[arrIndex]=rightArr[rightIndex];
        rightIndex++;
        arrIndex++;
    }
    }


}
