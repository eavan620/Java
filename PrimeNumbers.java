/*
 * A number n ∈ N, n > 1 is called prime if it has exactly two factors: 1 and itself.
 * Write a function isPrime(int n) that takes an integer n and return true if and only if n is prime.
 * Write a function nextPrime(int n) that returns the next prime number p that is larger than or equal to n, i.e. if n is prime, return n, otherwise return the next larger prime number.
 * Within the main function give suitable test cases for your functions.
 */

public class PrimeNumbers {

    public static boolean isPrime(int n) {
        if (n < 3){
            if (n == 2){
                return true;
            } else {
                return false;
            }
        }
        for (int i = 2; i < n;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int n) {
        boolean state = isPrime(n);
        while (!state){
            state = isPrime(++n);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(5));
        System.out.println(nextPrime(10));
    }

}
