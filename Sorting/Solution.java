/*
You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

package Sorting;

// Base class that provides the isBadVersion API
class VersionControl {
    private int firstBad; // The version number where it starts being bad

    // Constructor to initialize the first bad version
    public VersionControl(int firstBad) {
        this.firstBad = firstBad;
    }

    // API method: returns true if the given version is bad
    protected boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}

// Solution class extending VersionControl
public class Solution extends VersionControl {

    public Solution(int firstBad) {
        super(firstBad);
    }

    // Function to find the first bad version
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // Prevent overflow
            if (isBadVersion(mid)) {
                right = mid; // Bad version found, move left
            } else {
                left = mid + 1; // Still good, move right
            }
        }

        return left; // Left == Right == First Bad Version
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 10;           // total versions
        int firstBad = 4;     // Suppose version 4 is the first bad version

        Solution solution = new Solution(firstBad);
        int result = solution.firstBadVersion(n);

        System.out.println("First bad version is: " + result);
    }
}
