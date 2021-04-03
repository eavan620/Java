/*
* Write a recursive Java method public static BigInteger fib1(int n) to calculate the nth Fibonacci number. Use the main method to print out the first 15 Fibonacci numbers.

* Show how the number of function calls increases using the example fib1(5). Explain what tree recursion is. Provide your solution using the comment block at the top of the template file.

* Now, rewrite your method fib1 into an iterative solution (using a loop instead of recursion) and name it public static BigInteger fib2(int n)1!

* Show using the same example as above that fib2 is more efficient than fib1.

* Hint: Store the values for fib(n-2) and fib(n-1) in two seperate variables.

* Use the main method to calculate the 23rd Fibonacci number using both methods and count the number of method calls (using a static variable for fib1) and the number of loop iterations for fib2.


*/


package work1;
import java.math.*;

public class BigIntegerFibonacci {
    public static int count_fib1=0;
    public static int count_fib2=0;
    public static BigInteger fib1(int n){
        count_fib1++;
        if (n == 0 || n == 1){
            return BigInteger.ONE;
        }
        else if(n>1){
            return  fib1(n-2).add(fib1(n-1));
        }
        return fib1(n);
    }
    public static BigInteger fib2(int n){
        BigInteger b1=BigInteger.ONE;
        BigInteger b2=BigInteger.ONE;
        BigInteger b3=BigInteger.ZERO;
        if (n == 0 || n == 1){
            return BigInteger.ONE;
        }
        else if(n>1){
            for(int i = 2; i <= n; i++){
                b3 = b2.add(b1);
                b1 = b2;
                b2 = b3;
                count_fib2++;
            }
        }
        return b3;
    }

    public static void main(String[] args) {
        System.out.println("BigInteger result ="+fib1(23));
        System.out.println("BigInteger result ="+fib2(23));
        System.out.println("fib(1) calls ="+count_fib1);
        System.out.println("fib(2) loops ="+count_fib2);
    }
}