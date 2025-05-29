//I, V, X,  L,  C,   D,   M
//1, 5, 10, 50, 100, 500, 1,000

import java.util.*;

public class ERoman{
	public static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

	public static int romanToDecimal(String s) {
        int res = 0; 

        for (int i = 0; i < s.length(); i++) {
            
            // Get value of current symbol
            int s1 = value(s.charAt(i));

            // Compare with the next symbol if it exists
            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));

                // If current value is greater or equal, add it
                // to result
                if (s1 >= s2) {
                    res += s1;
                }
                else {
                    // Else, add the difference and skip next
                    // symbol
                    res += (s2 - s1);
                    i++;
                }
            }
            else {
                res += s1;
            }
        }

        return res;
    }

    public static String decimalToRoman(int x) {
        
        // array of values and symbols
        int[] base =   {  1,    4,   5,    9,  10,   40,  50,   90,100,   400, 500,  900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder res = new StringBuilder();

        // Loop from the right side to find
        // the largest smaller base value
        int i = base.length - 1;
        while (x > 0) {
            int div = x / base[i];
            
            while (div > 0) {
                res.append(sym[i]);
                div--;
            }
            
            // Repeat the process for remainder
            x = x % base[i];
            i--;
        }

        return res.toString();
    }

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number in roman: ");
		String roman = sc.nextLine();

		int decimal = romanToDecimal(roman);
		System.out.println(decimal);

		String romanFromDecimal = decimalToRoman(decimal);
		System.out.print(romanFromDecimal);

		return;
	}
}