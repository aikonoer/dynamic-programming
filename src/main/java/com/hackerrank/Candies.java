package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 27/05/16.
 */

/*
9
5
3
8
1
2
4
4
9
0
*
* */
public class Candies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer length = Integer.valueOf(scanner.nextLine());
        int[] ratings = new int[length];
        int[] candies = new int[length];

        for (int i = 0; i < length; i++) {
            final Integer rate = Integer.valueOf(scanner.nextLine());
            ratings[i] = rate;
            candies[i] = 1;
        }

        if (length < 2) System.out.println(1);
        else {
            candies = findHigherRatingForward(1, length, ratings, candies);
            candies = findHigherRatingReverse(length - 1, 0, ratings, candies);
        }

        System.out.println(findSumCandies(0, length, candies));
    }

    private static int findSumCandies(int start, int end, int[] candies) {
        if (start == end) return 0;
        return candies[start] + findSumCandies(++start, end, candies);
    }

    private static int[] findHigherRatingForward(int start, int end, int[] ratings, int[] candies) {
        if (start == end) return candies;
        candies[start] = ratings[start] > ratings[start - 1] ? candies[start - 1] + 1 : candies[start];
        return findHigherRatingForward(++start, end, ratings, candies);
    }

    private static int[] findHigherRatingReverse(int start, int end, int[] ratings, int[] candies) {
        if (start == end) return candies;
        candies[start - 1] = (ratings[start - 1] > ratings[start]) ? (candies[start - 1] > candies[start]) ?
                candies[start - 1]
                : candies[start] + 1
                : candies[start - 1];
        return findHigherRatingReverse(--start, end, ratings, candies);
    }
}
