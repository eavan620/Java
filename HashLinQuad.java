//-----------------------------------------------------------------//
/*
* Compare Linear and Quadratic Probing
* Write a simple class HashLinQuad with the following attributes and methods:
* 1 private int[] table_;           // array of buckets or slots
* 2 private int   size_;           // current number of elements
* 3 private int   capacity_;
* 4 public int addLin(int obj);     // for linear probing
* 5 public int addQuad(int obj);    // for quadratic probing
* 6 addLin(int obj) and addQuad(int obj) are used to insert new elements into the hash table table_. For the sake of simplicity assume that capacity_ is large enough so that all items will fit into table_.

* In your main() method create a 1000 random numbers (all >0). Create two hash tables with capacity_ = 1249. As hash function we use h(x)=x.
* 1. Insert these number into the first hash table using linear probing for collission handling. Count the number of collisions.
* 2. Insert the same numbers into the second hash table using quadratic probing for collission handling. Count the number of collisions.
*/

import static java.lang.Math.abs;

/**
 * simple Hashtable with linear/quadratic probing
 * capacity is big enough
 */

public class HashLinQuad {
    //---------------------------------------------------------------//
    private int[] table_;    // array of buckets or slots
    private int size_;       // current number of elements
    private int capacity_;

    int availableTableSize;
    // set counter datafields to 0
    int linearCollisions = 0;

    int linearNoCollisions = 0;

    int quadraticCollisions = 0;

    int quadraticNoCollisions = 0;
    boolean noCollisions = true;

    // TODO: Constructor
    HashLinQuad(int capacity_) {

        this.capacity_ = capacity_;

        // assign the available table size to be the next greatest prime of the
        // target table size
        availableTableSize = nextPrime(capacity_);

        // create arrays for the keys of size TOTAL_ARRAY_SIZE
        table_ = new int[capacity_];

    //    quadraticKeys = new String[capacity_];
    }

    // method to calculate the next greatest prime number
    private int nextPrime(int num) {

        // iterate through the for loop starting with the int passed in
        for (int j = num; ; j++) {

            // set the count equal to 0
            int count = 0;

            // iterate through, checking if numbers are not prime
            for (int i = 2; i <= j / 2; i++) {

                // if NOT prime, increment count
                if (j % i == 0) {

                    count++;
                }
            }

            // if count == 0, return the next prime number
            if (count == 0) {

                return j;
            }
        }
    }

    //---------------------------------------------------------------//
    int index = 0;
    String[] linearKeys;

    public int addLin(int obj) {
        // linear probing
        // return number of collisions
        // set a counter to 0
        int counter = 0;

        // calculate the word's index
        int indexL = calculateLinearIndex(obj, counter);

        // set the noCollisions bool to true
        noCollisions = true;

        // execute while indexL in the table is not empty
        while (table_[indexL] != -1) {

            // increment counter
            counter++;

            // recalculate the index
            indexL = calculateLinearIndex(obj, counter);

            // increment the linear collisions counter
            linearCollisions++;

            // change noCollisions boolean to false
            noCollisions = false;
        }

        // insert item at linearKeys[indexL]
        table_[indexL] = obj;

        // if there were no collisions, increment counter
        if (noCollisions) {

            linearNoCollisions++;
        }

        return linearCollisions;
    }

    //---------------------------------------------------------------//
    public int addQuad(int obj) {
        // set counter to 0
        int j = 0;

        // calculate the word's index
        int indexQ = calculateQuadraticIndex(obj, j);

        // set the no collisions bool to true
        noCollisions = true;

        // execute while indexQ in the table is not empty
        while (table_[indexQ] != -1) {

            // increment the counter j
            j++;

            // recalculate index
            indexQ = calculateQuadraticIndex(obj, j);

            // increment the quadratic collision counter
            quadraticCollisions++;

            // change noCollisions boolean to false
            noCollisions = false;
        }

        // insert item at quadraticKays[indexQ]
        table_[indexQ] = obj;

        // if there were no collisions, increment counter
        if (noCollisions) {

            quadraticNoCollisions++;
        }
        return quadraticCollisions;
    }
    // method to calculate the next index for quadratic probing
    public int calculateQuadraticIndex(int num, int counter) {

        // calculate new index
        index = (int) (abs(num + Math.pow(counter, 2)) % availableTableSize);

        // return the index
        return index;
    }
    //---------------------------------------------------------------//
    public String toString() {
        // TODO: implementation

        return "";
    }

    //---------------------------------------------------------------//

    // method to calculate the next index for linear probing
    public int calculateLinearIndex(int word, int count) {

        // calculate new index
        index = count % capacity_;

        // return the index
        return index;
    }

    public static void main(String[] args) {
        // TODO: test with hashtable-capacity of 1249 and 1000 random values

        int r[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            r[i] = (int) (Math.random() * 1000 + 1);

        }

        HashLinQuad hashLinQuad = new HashLinQuad(1249);

        for(int i =0 ; i< 1249; i++) {
            hashLinQuad.table_[i] = -1;
        }

        int linearCollisions = 0;

        for(int i =0; i < r.length; i++) {
            linearCollisions += hashLinQuad.addQuad( r[i]);
        }

        System.out.println(linearCollisions);
    }
}
