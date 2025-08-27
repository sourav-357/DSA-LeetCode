/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
Return any answer array that satisfies this condition.
*/

package Sorting;

class SortArrayByParity {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1; 

        while (i < n && j < n) {
            if (nums[i] % 2 == 0) {
                i += 2; 
            } else if (nums[j] % 2 == 1) {
                j += 2; 
            } else {                
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
