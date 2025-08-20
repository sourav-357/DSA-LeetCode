package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        // Convert int[] to Integer[] for sorting with comparator
        Integer[] temp = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Sort using a custom comparator: evens before odds
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Sort by parity: even numbers come first
                return Integer.compare(a % 2, b % 2);
            }
        });

        // Convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }
}
