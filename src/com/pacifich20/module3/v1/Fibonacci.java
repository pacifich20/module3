package com.pacifich20.module3.v1;

public class Fibonacci {

    /**
     * generates nth fibonacci number using recursion
     * @param n index of fibonacci number to generate
     * @return nth fibonacci number
     */
    public static int generateNumber(int n) {
        return (n <= 1) ? n : generateNumber(n - 1) + generateNumber(n - 2);
    }

    /**
     * generates sum of fibonacci numbers up to nth index
     * @param n index the sum is calculated up to
     * @return sum of fibonacci numbers up to nth index
     */
    public static int generateSum(int n) {
        return (n <= 0) ? 0 : generateNumber(n + 2) - 1;
    }

    /**
     * prints fibonacci sums for different given numbers
     */
    public static void main(String[] args) {
        printFibonacciSum(9);
        printFibonacciSum(3);
        printFibonacciSum(16);
        printFibonacciSum(-5);
    }

    /**
     * prints fibonacci sum for given number
     * @param n number fibonacci sum is calculated and printed for
     */
    private static void printFibonacciSum(int n) {
        int sum = generateSum(n);
        System.out.println("Fibonacci Sum for " + n + ": " + sum);
    }
}