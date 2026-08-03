class Solution {

    public int reverse1(int n) {
        int sum = 0;

        while (n > 0) {
            int t = n % 10;
            n /= 10;

            if (sum > Integer.MAX_VALUE / 10 ||
               (sum == Integer.MAX_VALUE / 10 && t > 7))
                return 0;

            sum = sum * 10 + t;
        }

        return sum;
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;

        if (x >= 0)
            return reverse1(x);
        else
            return -reverse1(-x);
    }
}