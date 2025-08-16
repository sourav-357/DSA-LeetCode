package BinarySearch;

public class MinimumInRotatedSorted {
    
}
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        // If the numsay is not rotated
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the pivot (minimum)
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Decide which half to continue with
            if (nums[mid] >= nums[low]) {
                // Left half is sorted, pivot must be in right half
                low = mid + 1;
            } else {
                // Right half is sorted, pivot must be in left half
                high = mid - 1;
            }
        }
        
        return -1; // Should never reach here if input is valid
    }
}
