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
