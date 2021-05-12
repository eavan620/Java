//1.  with the array int[] a ={5,3,4,7,1,2}
//    The recursive divide-and-conquer algorithm will devide the into 2 subarray
//    { 5,3,4}                                 and {7,1,2}
//    to {5}, {3,4},                          to {7}, {1, 2}
//    then {5}, {3}, {4}                      {7}, {1}, {2}

//Then they merge and sort from downward to upward, we have:
//    then {5}, {3}, {4}                      {7}, {1}, {2}
// to        {5}, {3,4}                           {7}, {1,2}
// to         {3,4,5}                              {1,2,7}
// and                      {1,2,3,4,5,7}

//2. a/ A divide-and-conquer algorithm works by recursively breaking down a problem
// into two or more sub-problem of the same or related type, until these become simple enough to solved directly.
//The solution to the sub-problems are then combined to give a solution to the original problem.
//b/        algorithm	       best case	average case	worst case	stable
//        selection sort	     n^2			n^2           n^2       unstable
//        insertion sort		n			    n^2           n^2       stable
//        bubble sort		n/n^2			    n^2           n^2       stable
//        quicksort				n.log2(n)      n.log2(n)      n^2       unstable
//        mergesort				n.log2(n)      n.log2(n)      n.log2(n) stable

//   from the table above, it is clear that mergesort require less amunt of memory compared to other sorting algorithm
// 3. Merge sort is a stable sort which means that the same element in an array maintain their original positions with
//respect to each other




import java.util.Arrays;
import java.util.Comparator;

public class MergeSort  {

    private static <T> void reverse(T[] arr, int i, int j) {
        while(i < j)
        {
            T temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    private static <T> void swapAdjacentBlocks(T[] arr, int bias, int oneSize, int anotherSize) {
        reverse(arr, bias, bias + oneSize - 1);
        reverse(arr, bias + oneSize, bias + oneSize + anotherSize - 1);
        reverse(arr, bias, bias + oneSize + anotherSize - 1);
    }

    private static <T> void Merge(T[] array, int l, int mid, int r,Comparator<T> c)
    {
        int i = l;
        int j = mid + 1;
        while(i < j && j <= r)
        {
            while(i < j && c.compare(array[i], array[j]) <= 0)
            {
                i++;
            }
            int index = j;
            while(j <= r &&c.compare(array[j], array[i]) <= 0)
            {
                j++;
            }
            swapAdjacentBlocks(array, i, index-i, j-index);
            i += (j-index);
        }
    }

    public static <T> void _mergeSort(T[] array,int l, int r, Comparator<T> c) {
        if(l < r)
        {
            int mid = (l + r) / 2;
            _mergeSort(array, l, mid,c);
            _mergeSort(array, mid + 1, r,c);
            Merge(array, l, mid, r,c);
        }
    }


    public static <T> void  mergeSort(T[] array, Comparator<T> c) {

        _mergeSort(array, 0, array.length-1,c);
    }



    public static void main(String[] args) {

        Integer[] a = new Integer[10];
        for(int i=1;i<a.length;i++)
        {
            a[i] = (int)(24*Math.random());
        }
        System.out.println(Arrays.toString(a));

        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer d1, Integer d2) {
                return d1.compareTo(d2);
            }
        };
        mergeSort(a,c);
        System.out.println(Arrays.toString(a));
    }
}

