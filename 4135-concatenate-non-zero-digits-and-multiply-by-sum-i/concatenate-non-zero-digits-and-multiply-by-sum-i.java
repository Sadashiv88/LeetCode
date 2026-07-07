class Solution {
    public long sumAndMultiply(int n) {

        String str = String.valueOf(n);
        String s = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                s += str.charAt(i);
            }
        }

        if (s.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        int num = Integer.parseInt(s);

        return (long) num * sum;
    }
}