/*
* Perfect Shuffling of a deck of cards with an even number of cards works as follows:

* The deck is split into two equal halves and those stacks are shuffled together by alternately taking one card from each stack and putting it into a new stack.

* Write a Java method public static int[] interleave(int[] a1, int[] a2) which as input takes two arrays of equal lengths (you do not need to check for that!) and yields a new array with the arrays shuffled as in the above example.

* Write another Java mathod public static int[] perfectShuffle(int[] a) that achieves perfect shuffling for an array with an even number of elements. For this you need to split the arrays into two halves and then call the interleave method from above on those two halves.

* If the array has an odd number of elements do nothing but only return the unaltered array.

* If you perfectly shuffle a deck often enough it should return to its original order.

* Write a Java method public static int shuffleNumber(int n) that takes an even number n > 0 and returns how often you need to perfectly shuffle a deck of n cards until it returns to its original order.

* Each array has to be shuffled at least once! If n is an odd number, your method should return -1

*/




package ClassExercise;

import java.util.Arrays;

public class PerfectShuffle {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 8, 11};
        int[] a2 = {4, 5, 6, 9, 13};
        int[] a3 = {10, 11, 12, 13, 14, 15};
//        printArray(a1);
//        printArray(a2);
        interleave(a1, a2);
        perfectShuffle(a3);

        shuffleNumber(84);


    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));//object-oriented


    }


    public static int[] interleave(int[] a1, int[] a2) {
        int[] newArray = new int[(a1.length) + (a2.length)];
        newArray[0] = a1[0];
        for (int i = 1; i < newArray.length; i++) {
            if (i % 2 == 1)
                newArray[i] = a2[i / 2];
            else
                newArray[i] = a1[i / 2];
        }
//        System.out.print("[");
//
//        for (int i = 0; i < newArray.length; i++) {
//            if (i == newArray.length - 1)
//                System.out.println(newArray[i] + "]");
//            else System.out.print(newArray[i] + ",");
//            System.out.println(newArray[i]);

//        }
//        printArray(newArray);
        return newArray;
    }

    public static int[] perfectShuffle(int[] a) {
        int len = a.length;
        if (len % 2 == 1) {
            printArray(a);
            return a;
        } else {
            int[] b1 = new int[a.length / 2];
            int[] b2 = new int[a.length / 2];
            for (int i = 0; i < a.length / 2; i++) {
                b1[i] = a[i];
                for (int j = a.length / 2; j < a.length; j++) {
                    b2[j - (a.length / 2)] = a[j];
                }

            }
//            printArray(b1);
//            printArray(b2);
            int[] c = interleave(b1, b2);
            return c;
        }

//        printArray(b1);
//        printArray(b2);
//        int[] c = interleave(b1, b2);

//        return c;
    }

    public static int shuffleNumber(int n) {
        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = i;
        }
        if (n % 2 == 1) {
            return -1;
        }
        int[] change = perfectShuffle(originalArray);
        int time = 0;
        for (int j = 1; j < n; j++) {
            if ((originalArray[1] != change[1])&&(originalArray[2]!=change[2])) {
                change = perfectShuffle(change);
                time = j + 1;
            }
        }
        System.out.println(time);
        return time;


    }


}
