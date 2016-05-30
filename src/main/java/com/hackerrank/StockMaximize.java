package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 30/05/16.
 * <p>
 * Your algorithms have become so good at predicting the market that you
 * now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next N days.
 * <p>
 * Each day, you can either buy one share of WOT, sell any number of shares
 * of WOT that you own, or not make any transaction at all. What is the maximum
 * profit you can obtain with an optimum trading strategy?
 */

public class StockMaximize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer cases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < cases; i++) {
            final Integer length = Integer.valueOf(scanner.nextLine());
            final String[] prices = scanner.nextLine().split(" ");

            System.out.println(findMaxProfit(0, Integer.valueOf(prices[length - 1]), length - 2, prices));
        }
    }

    private static long findMaxProfit(long sum, long max, int runningIndex, String[] prices) {
        if (runningIndex < 0) return sum;
        final int current = Integer.valueOf(prices[runningIndex]);
        if (max > current) sum += max - current;
        else max = current;
        return findMaxProfit(sum, max, --runningIndex, prices);
    }

}
