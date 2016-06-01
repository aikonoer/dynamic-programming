package com.hackerrank;

import java.util.Scanner;

/**
 * Created by brianmomongan on 1/06/16.
 */
/*
*  Primality test using --
*  http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
*  Computes the number of primes less than or equal to N using
*  the Sieve of Eratosthenes.
*
*  no copyright infringement intended
*
* */

public class RedJohnIsBack {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer cases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < cases; i++) {
            final Integer bricks = Integer.valueOf(scanner.nextLine());
            final int[] storage = new int[bricks + 1];
            final int numberOfWays = findNumberOfWays(0, bricks, storage);
            System.out.println(findNumberOfPrimes(numberOfWays));
        }
    }

    private static int findNumberOfWays(int index, int bricks, int[] storage) {
        if (index > bricks) return storage[bricks];
        if (index > 3) storage[index] = storage[index - 1] + storage[index - 4];
        else storage[index] = 1;
        return findNumberOfWays(++index, bricks, storage);
    }

    private static int findNumberOfPrimes(int numbers) {
        boolean[] isPrime = new boolean[numbers + 1];
        for (int i = 2; i <= numbers; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= numbers; i++) {

            if (isPrime[i]) {
                for (int j = i; i * j <= numbers; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i <= numbers; i++) {
            if (isPrime[i]) primes++;
        }

        return primes;
    }

}
