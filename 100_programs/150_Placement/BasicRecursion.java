public class BasicRecursion{

    // 1. Factorial of a Number
    int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 2. Fibonacci Number
    int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 3. Sum of First N Natural Numbers
    int sumN(int n) {
        if (n == 0) return 0;
        return n + sumN(n - 1);
    }

    // 4. Check if a String is Palindrome
    boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }

    // 5. Print Numbers from 1 to N
    void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    // 5. Print Numbers from N to 1
    void printNTo1(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNTo1(n - 1);
    }

    // 6. Power of a Number (a^b) - Basic
    int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }

    // 6. Power of a Number (a^b) - Optimized
    int fastPower(int a, int b) {
        if (b == 0) return 1;
        int half = fastPower(a, b / 2);
        if (b % 2 == 0) return half * half;
        else return a * half * half;
    }

    // 7. Reverse a String
    String reverseString(String str) {
        if (str.isEmpty()) return "";
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // 8. Count Digits of a Number
    int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    // 9. Check if Array is Sorted
    boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    // Main method to test all functions
    public static void main(String[] args) {
        BasicRecursion obj = new BasicRecursion();

        System.out.println("1. Factorial of 5: " + obj.factorial(5));
        System.out.println("2. Fibonacci of 6: " + obj.fibonacci(6));
        System.out.println("3. Sum of first 5 numbers: " + obj.sumN(5));
        System.out.println("4. Is 'madam' a palindrome? " + obj.isPalindrome("madam", 0, 4));
        System.out.print("5. Print 1 to 5: "); obj.print1ToN(5); System.out.println();
        System.out.print("5. Print 5 to 1: "); obj.printNTo1(5); System.out.println();
        System.out.println("6. Power (2^5) basic: " + obj.power(2, 5));
        System.out.println("6. Power (2^5) fast: " + obj.fastPower(2, 5));
        System.out.println("7. Reverse of 'hello': " + obj.reverseString("hello"));
        System.out.println("8. Count digits in 12345: " + obj.countDigits(12345));
        System.out.println("9. Is array sorted? [1, 2, 3, 4, 5] -> " +
                obj.isSorted(new int[]{1, 2, 3, 4, 5}, 0));
    }
}
