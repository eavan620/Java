//-----------------------------------------------------------------//

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
        // quadratic probing
        // return number of collisions

        return 0;
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
            linearCollisions += hashLinQuad.addLin( r[i]);
        }

        System.out.println(linearCollisions);
    }
}
