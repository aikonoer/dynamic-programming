package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 26/05/16.
 */

/*

4 3
1 2 3

10 4
2 5 3 6

245 26
16 30 9 17 40 13 42 5 25 49 7 23 1 44 4 11 33 12 27 2 38 24 28 32 14 50

**/
public class CoinChanging {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] details = scanner.nextLine().split(" ");
        final Integer sum = Integer.valueOf(details[0]);
        final Integer coins = Integer.valueOf(details[1]);
        final String[] arr = scanner.nextLine().split(" ");
        final long[][] result = new long[coins + 1][sum + 1];
        System.out.println(findChangeWays(1, sum, coins, arr, result));
    }

    private static long findChangeWays(int y, int sum, int coins, String[] arr, long[][] result) {
        if (y > coins) return result[coins][sum];
        result = traverseX(0, y, sum, arr, result);
        return findChangeWays(++y, sum, coins, arr, result);
    }

    private static long[][] traverseX(int x, int y, int sum, String[] arr, long[][] result) {
        if (x > sum) return result;
        if (x == 0) result[y][x] = 1;
        else if (x < Integer.valueOf(arr[y - 1])) result[y][x] = result[y - 1][x];
        else result[y][x] = result[y - 1][x] + result[y][x - Integer.valueOf(arr[y - 1])];
        return traverseX(++x, y, sum, arr, result);
    }
}
