package ClassExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

    public static <T extends Comparable<T>> List<T> removeDuplicates(T[] input) {
        // TODO: your implementation goes here
//        T[] arrays = input;
        ArrayList<T> list = new ArrayList<>(Arrays.asList(input));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i).compareTo(list.get(j)) == 0) {
                    list.remove(j);
                }
            }

        }
        System.out.println(list);
        return list;

    }

    public static void main(String[] args) {
        // TODO: insert some test cases to show that your method works
        Integer[] array = {1, 2, 3, 2, 1, 3, 4, 7, 6, 7, 8};
        removeDuplicates(array);
    }
}
