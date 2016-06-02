package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 2/06/16.
 * <p>
 * https://www.hackerrank.com/challenges/unbounded-knapsack
 */

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer cases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < cases; i++) {
            final String[] details = scanner.nextLine().split(" ");
            final Integer length = Integer.valueOf(details[0]);
            final Integer sum = Integer.valueOf(details[1]);
            final String[] arr = scanner.nextLine().split(" ");
            final int result = findMaxSum(0, length, sum, arr, new int[length][sum + 1]);
            System.out.println(result);
        }
    }

    private static int findMaxSum(int element, int length, int sum, String[] arr, int[][] storage) {
        if (element == length) return findMaxSum(length, sum, storage);
        storage = isSum(element, 1, sum, arr, storage);
        return findMaxSum(++element, length, sum, arr, storage);
    }

    private static int[][] isSum(int element, int sum, int sumLen, String[] arr, int[][] storage) {
        if (sum > sumLen) return storage;
        storage[element][sum] = (element == 0) ? 0 : storage[element - 1][sum];

        final Integer elValue = Integer.valueOf(arr[element]);
        if (sum < elValue || storage[element][sum] == 1)
            return isSum(element, ++sum, sumLen, arr, storage);
        else {
            final int index = sum - elValue;
            if (index == 0 || storage[element][index] == 1) storage[element][sum] = 1;
            return isSum(element, ++sum, sumLen, arr, storage);
        }
    }

    private static int findMaxSum(int length, int sum, int[][] storage) {
        if (sum == 0) return 0;
        if (storage[length - 1][sum] == 1) return sum;
        return findMaxSum(length, --sum, storage);
    }
}
