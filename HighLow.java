package ClassExercise;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
    public static int guess(int low, int high) {
        // TODO: implement High-Low
        int guess = (low + high) / 2;
        System.out.println("The guess number is: " + guess);
        return guess;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int imaginedNum = r.nextInt(50) + 1;
        System.out.println("The imaginedNum is: " + imaginedNum);
        System.out.println("Please enter your lower bound: ");
        int low = sc.nextInt();
        System.out.println("Please enter your upper bound");
        int high = sc.nextInt();
        int guess = guess(low, high);
        while (true) {
            if (guess != imaginedNum) {
                sc.nextLine();
                System.out.println("My answer is:");
                String str= sc.nextLine();
                System.out.println("The new lower bound is:");
                int newLow = sc.nextInt();
                System.out.println("The new upper bound is:");
                int newHigh = sc.nextInt();
                int guess1 = guess(newLow, newHigh);
                guess = guess1;
            } else {
                sc.nextLine();
                System.out.println("My answer is: ");
                sc.nextLine();
                break;
            }

        }


    }
}

