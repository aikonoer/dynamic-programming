package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 25/05/16.
 * <p>
 * Find the maximum possible sum of a
 * <p>
 * 1. Contiguous subarray
 * 2. Non-contiguous (not necessarily contiguous) subarray.
 */

public class MaxSubArray {
    private static class MaxSub {
        int conMax;
        int nonConMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer cases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < cases; i++) {
            final Integer len = Integer.valueOf(scanner.nextLine());
            final String[] arr = scanner.nextLine().split(" ");
            final MaxSub maxSub = new MaxSub();
            final Integer firstMax = Integer.valueOf(arr[0]);
            maxSub.conMax = firstMax;
            maxSub.nonConMax = firstMax;
            final MaxSub result = findMaxSub(firstMax, maxSub, 1, len, arr);
            System.out.println(result.conMax + " " + result.nonConMax);
        }
    }

    private static MaxSub findMaxSub(int max, MaxSub maxSub, int current, int len, String[] arr) {
        if (current >= len) return maxSub;
        final Integer curNum = Integer.valueOf(arr[current]);
        final int curMax = Math.max(max + curNum, curNum);
        maxSub.conMax = Math.max(curMax, maxSub.conMax);
        if (maxSub.nonConMax < 0) maxSub.nonConMax = Math.max(maxSub.nonConMax, curNum);
        else maxSub.nonConMax = Math.max(maxSub.nonConMax, maxSub.nonConMax + curNum);
        return findMaxSub(curMax, maxSub, ++current, len, arr);
    }
}
