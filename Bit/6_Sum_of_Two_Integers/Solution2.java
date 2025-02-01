class Solution2 {
    public int getSum(int a, int b) {
        int carry = a&b;
        int sumWithoutCarry = a^b;
        int actualCarry = carry<<1;

        while(carry != 0){
            carry = sumWithoutCarry & actualCarry;
            sumWithoutCarry = sumWithoutCarry ^ actualCarry;
            actualCarry = carry << 1;
        }

        return sumWithoutCarry;
    }
}
