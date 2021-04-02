/*
* Write a class RandomIntArray with 4 different methods:

* The method public static int[] createRandom(int n) takes a single integer argument specifying the size of the array. Each element of the array should be a random integer number from the range
  [5,99]

* Hint: To generate random numbers you can use the function Math.random(). This generates a random number between
  [0.0,1.0) which you have to transform properly to the correct range.

* The method public static String toString(int[] a) takes an array reference as its only argument and should return a proper String representation of the array (containing all elements from the array).

* Use the main method to test your implementation and check how your result compares to the built-in function Arrays.toString(...)!

* The method public static int posMin(int[] a) takes an array reference and returns the index (position) of the smallest value in a. If that element occurs more than once in the array, return only the first index.

* The method public static void swap(int[] a) takes a single array reference as its argument. The method should return nothing, but the first and last element of the array a should be swapped.


*/




package ClassExercise;

import java.util.Arrays;

public class RandomIntArray {
    public static int[] createRandom(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * ((99 - 5) + 1) + 5);
        }

        return array;
    }

    public static String toString(int[] a) {
        String num="";
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1)
            num=num+a[i]+"]";
            else num=num+a[i]+",";
        }
        String last="[";
        num=last+num;
        return num;

    }

    public static int posMin(int[] a) {
        int minIndex = 0;
        int[] arrnew = new int[2];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[minIndex] > a[i + 1]) {
                minIndex = i + 1;
            }
        }
        arrnew[0] = a[minIndex];
        arrnew[1] = minIndex;
        return arrnew[1];
    }

    public static void swap(int[] a) {

        int n = a.length;
        int x = a[0];
        a[0] = a[n - 1];
        a[n - 1] = x;
    }

    public static void main(String[] args) {
        int[] array = createRandom(5);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "]");
            }
            else {
                System.out.print(array[i] + ",");
//                System.out.print(array[i]);
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(toString(array));
        System.out.println(posMin(array));


    }
}
