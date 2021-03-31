/*
 * Write a Java method public static int median(int a, int b, int c), that calculates the median of the three given numbers (it has to be one of those numbers!).
 */

import java.util.Arrays;

public class MedianOfThree {

  public static int median(int a, int b, int c) {
    int [] myArray = {a,b,c};
    Arrays.sort(myArray);
    return myArray[1];
  }

  public static int median2(int a, int b, int c) {
    int median = 0;
    if ((a <= b && b <= c) | (c <= b && b <=a)){
      median = b;
    }
    if ((b <= a && a <= c) | (c <= a && a <= b)){
      median = a;
    }
    if ((a <= c && c <= b) | (b <= c && c <= a )){
      median = c;
    }
    return median;
  }


  public static void main(String[] args) {
    System.out.println(median(25,11,33));
    System.out.println(median2(1,1,2));

  }

}