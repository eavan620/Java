/*
* Prime Twins are pairs of natural numbers (p,q) such that q = p + 2 and both p and q are prime numbers. For a prime triplet
 (p,q,r) holds that p, q, and r are all prime numbers and either (p,q,r)=(p,p+2,p+6)or(p,q,r)=(p,p+4,p+6).

* Write a Java method public static int[][] primeTwins(int n) that returns the first n prime twins. The result should be a matrix1 with two columns – one each for p and q.

* Write a second Method public static int[][] primeTriplets(int n) that returns the first n prime triplets. The result should be a matrix with three columns – one each for
  p and q and r.

*/




public class PrimeTwins {
    public static boolean isPrime(int n)
    {
        if (n<=1)
        {
            return false;
        }
        else if (n==2)
        {
            return true;
        }
        else
        {
            for (int i=2; i<n; i++)
            {
                if (n % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
    public static int[][] primeTwins(int number)
    {
        int[][] a = new int[number][2];
        int n = 2;
        int count = 0;
        while(count<number)
        {
            if(isPrime(n)&&isPrime(n+2))
            {
                a[count][0] = n;
                a[count][1] = n+2;
                count++;
            }
            n++;
        }
        return a;
    }

    public static int[][] primeTriplets(int number)
    {
        int[][] a = new int[number][3];
        int n = 2;
        int count = 0;
        while(count<number)
        {
            if((isPrime(n)&&isPrime(n+2)&&isPrime(n+6)))
            {
                a[count][0] = n;
                a[count][1] = n+2;
                a[count][2] = n+6;
                count++;
            }
            if((isPrime(n)&&isPrime(n+4)&&isPrime(n+6)))
            {
                a[count][0] = n;
                a[count][1] = n+4;
                a[count][2] = n+6;
                count++;
            }
            n++;
        }
        return a;

    }

    public static void main(String[] args)
    {
        int[][] a = new int[5][2];
        int n = 5;
        a = primeTwins(n);
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<2; j++)
            {
                System.out.println(a[i][j]);
            }
        }

    }
}
