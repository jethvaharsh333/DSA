class Solution3 {
    public int trailingZeroes(int n) {
        int count = 0, temp = 1;
        while(Math.pow(5, temp) <= n){
            count += n/Math.pow(5, temp++);
        }
        return count;
    }
}

/*
To find the number of trailing zeroes in the factorial of 130, we count the number of factors of 5 in all the numbers from 1 to 130, since each factor of 5 (combined with a 
factor of 2) produces a trailing zero.
  
Steps:
  Divide by 5: 
    130÷5=26
    There are 26 multiples of 5 (5, 10, 15, ..., 130).
  Divide by 25: 
    130÷25=5
    There are 5 multiples of 25 (25, 50, 75, 100, 125), each contributing an extra factor of 5.
  Divide by 125: 
    130÷125=1
    There's 1 multiple of 125, which contributes another factor of 5.
  Total trailing zeroes:
    26+5+1=32
*/
