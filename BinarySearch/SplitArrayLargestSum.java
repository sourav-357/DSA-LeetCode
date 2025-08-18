// Given an integer array nums and an integer k, 
// split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

package BinarySearch;

public class SplitArrayLargestSum {
    
}
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0, ans = -1; // Declaring Constraints
        for (int i = 0; i < nums.length; i++) {
            high += nums[i]; // Setting up High as the Sum of all the elements 
            if (low < nums[i])
                low = nums[i]; // Maximum elements among nums
        }
        // Starting the Binary Search 
        while (low <= high) {
            int mid = (low + high)/2; // calculating the Mid value
            // Check for the Value of mid
            if (check(nums, mid, k)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    // Checking if nums could be devided into K parts with max sum as mid 
    boolean check (int[] nums, int mid, int k) {
        int sum = 0; // Declaring Constraints
        int count = 1; // Starting from the first Value
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                sum = nums[i];
                count++;
            } else {
                sum += nums[i];
            }
        }
        // Check if it could be devided into K parts or not 
        return (count <= k);
    }
}
