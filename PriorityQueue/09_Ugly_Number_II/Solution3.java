// BRUTE FORCE

class Solution {
    public int nthUglyNumber(int n) {
        int count = 0; // To count ugly numbers
        int number = 1; // Start checking from 1
        
        // Continue until we find the nth ugly number
        while (count < n) {
            if (isUgly(number)) {
                count++;
            }
            number++;
        }   
        
        return number - 1; // Return the nth ugly number
    }

    // Helper function to check if a number is ugly
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        
        // Divide the number by 2, 3, and 5 as much as possible
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        
        // If the remaining number is 1, it's ugly
        return num == 1;
    }
}
