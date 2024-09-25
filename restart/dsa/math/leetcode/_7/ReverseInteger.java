package restart.dsa.math.leetcode._7;

public class ReverseInteger {
    public int reverseIntegerInRange(int val) {
        boolean sign = val < 0;
        if (sign) val = -val;
        int reverseVal = 0, prevVal = 0;
        while (val != 0) {
            prevVal = reverseVal;
            reverseVal *= 10;
            reverseVal += val % 10;
            val /= 10;
            if (reverseVal / 10 != prevVal) return 0;
        }
        if (reverseVal < 0) return 0;
        else return sign ? -reverseVal : reverseVal;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverseIntegerInRange(1534236469));
    }
}
