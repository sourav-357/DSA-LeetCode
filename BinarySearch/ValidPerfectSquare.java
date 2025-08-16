package BinarySearch;

public class ValidPerfectSquare {
    
}
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        int mid = 0;
        long msq = 1;

        while (low <= high) {
            mid = (low + high)/2;
            msq = (long) mid * mid;
            if (msq == num) {
                return true;
            } else if (msq < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}