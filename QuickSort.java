/*********************************************************
 1.The Recursive QuickSort function can be represented by this Pseudo Code:
 quicksort(a[],l,h)
 {
 //a[] is the given array
 //l is the starting index = 5
 //h is the ending index = 2

 if(l>=h)
 return;//array already sorted
 }
 Else{
 //p is the partitioning index, arr[p] is now at the right place
 P = partition(arr,low,high);
 Quicksort(arr,l,p-1); // sort values before index p
 Quicksort(arr, p+1,h);// sort values after index p
 }
 }
 We could pick the pivot for partitioning as either the first, last, random or median element.

 {5,3,4,8,7,1,2}
 Partition(arr,l,h){
 P = a[h];// pivot to last element
 I = l – 1; initialize I = -1
 For j from 1 up to h-1{ // j loops form{5 down to 1}
 If a[j] < p{ //if holds value less than pivot
 I++;// increment i
 Swap a[i] and a[j] // swap positions with a[j]
 Swap a[i+1] and a[h] // swap the next value after i with the pivot
 Return i + 1 // index of pivot
 }
 }
 }
 We get {5,3,4,8,7,1,2} //After the first iteration loop with 2 as the pivot
 We get {5,3,4,8,7,1,2} // After the second iteration with 2 as the pivot
 We get {5,3,4,8,7,1,2} // After the third iteration with 2 as the pivot
 We get {5,3,4,8,7,1,2} // After the fourth iteration with 2 as the pivot
 We get {5,3,4,8,7,1,2} // After the fifth iteration with 2 as the pivot
 We get {1,3,4,8,7,5,2} // After the sixth iteration with 2 as the pivot
 We get {1,2,4,8,7,5,3} //After pivot swap

 This iteration continues so we end up with {4,8,7,5,3} // since the p-1 is already sorted choosing 3 as the pivot

 // values on pivot on the left brackets
 {1,2}, {3,8,7,5,4}
 {1,2,3}, {4,7,5,8}
 {1,2,3,4}, {7,5,8}
 {1,2,3,4,5,7,8}

 2. Worst case will be when a given array is already sorted or we have an array with a lot of duplicate values and time complexity will be O(n^2).
 Best case will be when we choose our pivot to be the median or closest to the median of the given array and time complexity will be O(nlogn).
 Average case will be when we assume there are no duplicates and the ordering is random. Time complexity will be O(nlogn).

 Choosing a random pivot minimizes the chance that we encounter worst case O(n2) performance(always choosing first or last would cause worst case performance for nearly-sorted or nearly-reverse-sorted data). Choosing the middle element would also be acceptable in the majority of cases.

 Worst Case Scenario
 Array = [2,2,2,2,2,2,2,2,2]
 The pivot is last index 2.


 **********************************************************/
import java.util.Arrays;

public class QuickSort {

    static int swap;

    public static <T extends Comparable<T>> void quickSort(T[] a) {
        // TODO: quicksort-algorithm for generics
        quickSort(a, 0, a.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[]a, int left, int right) {
        if (right > left) {
            int pivot = partition(a,left,right);
            quickSort(a,left,pivot-1);
            quickSort(a,pivot+1,right);
        }
    }

    private static <T extends Comparable <T>> int partition(T[]a, int left,int right) {
        T pivot = a[right];
        int mid = left;
        for(int i=mid; i<right;i++) {
            if(a[i].compareTo(pivot)<=0) {
                swap(a,i,mid++);
            }
        }
        swap(a,right,mid);
        return mid;
    }

    private static <T extends Comparable <T>> void swap(T[] a,int b,int c) {
        if(b!=c) {
            T temp = a[b];
            a[b] = a[c];
            a[c] = temp;
        }
    }
    public static void main(String[] args) {

        Clock[] a = new Clock[20];
        a[0] = new Clock(0,0);
        for(int i=1;i<a.length;i++)
            a[i] = new Clock((int)(24*Math.random()),(int)(60*Math.random()));
        quickSort(a);
        System.out.println(Arrays.toString(a));


    }

}


