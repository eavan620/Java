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