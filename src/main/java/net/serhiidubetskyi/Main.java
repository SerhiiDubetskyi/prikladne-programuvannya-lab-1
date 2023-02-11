package net.serhiidubetskyi;

import java.util.Scanner;

/**
 * This class {@code FibonacciSequence} contains methods to calculate and process the Fibonacci sequence.
 * @author Serhii Dubetskiy
 * @version 1.0
 */
class FibonacciSequence {
    /**
     * The array of {@link FibonacciNum} elements.
     */
    FibonacciNum[] sequence;

    /**
     * Constructs a new {@code FibonacciSequence} object.
     * @param fibonacciSequenceLength the number of elements in the sequence
     */
    FibonacciSequence(int fibonacciSequenceLength) {
        System.out.println("Calculating first " + fibonacciSequenceLength + " fibonacci numbers...");
        sequence = new FibonacciNum[fibonacciSequenceLength];

        sequence[0] = new FibonacciNum(0, 0);
        sequence[1] = new FibonacciNum(1, 1);
        for (int i = 2; i < fibonacciSequenceLength; i++) {
            sequence[i] = new FibonacciNum(sequence[i - 1].get() + sequence[i - 2].get(), i);
        }
        System.out.println("Done!");
    }

    /**
     * Prints the number of elements in the sequence that match condition.
     */
    public void printIfMatch() {
        System.out.println("Printing fibonacci numbers that match condition(w^2 + 1)...");
        System.out.println("index\tvalue\tw");
        for (FibonacciNum num : sequence) {
            double condition = Math.sqrt(num.get() - 1);
            if (condition - Math.floor(condition) == .0) {
                System.out.println(num.index() + "\t\t" + num.get() + "\t\t" + condition);
            }
        }
        System.out.println("Done!");
    }
}

/**
 * This class {@code FibonacciNum} contains methods to store Fibonacci value and index.
 * @author Serhii Dubetskiy
 * @version 1.0
 */
class FibonacciNum {
    /**
     * The value of the Fibonacci number.
     */
    int fibonacciNum;
    /**
     * The index of the Fibonacci number.
     */
    int fibonacciNumIndex;

    /**
     * Constructs a new {@code FibonacciNum} object.
     * @param fibonacciNum the value of the Fibonacci number
     * @param fibonacciNumIndex the index of the Fibonacci number
     */
    FibonacciNum(int fibonacciNum, int fibonacciNumIndex) {
        this.fibonacciNum = fibonacciNum;
        this.fibonacciNumIndex = fibonacciNumIndex;
    }

    /**
     * Returns the value of the Fibonacci number.
     * @return the value of the Fibonacci number
     */
    public int get() {
        return fibonacciNum;
    }

    /**
     * Returns the index of the Fibonacci number.
     * @return the index of the Fibonacci number
     */
    public int index() {
        return fibonacciNumIndex;
    }
}

/**
 * This class {@code Main} contains the main method for the program.
 * @author Serhii Dubetskiy
 * @version 1.0
 */
public class Main {
    /**
     * The main method for the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many first fibonacci numbers to calculate?: ");
        int fibonacciSequenceLength;

        while (true) {
            try {
                fibonacciSequenceLength = Integer.parseInt(in.nextLine());

                if (fibonacciSequenceLength <= 0) {
                    throw new Exception("Fibonacci sequence length must be greater than 0.");
                } else {
                    System.out.println("Fibonacci sequence length greater than 0 and is an integer.");
                    break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input! Please enter an integer.");
            }
            catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
            }
        }

        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacciSequenceLength);
        fibonacciSequence.printIfMatch();
    }
}