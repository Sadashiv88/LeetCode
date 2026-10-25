class Solution {
    public int compress(char[] chars) {
        int i = 0, write = 0;

        while (i < chars.length) {
            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }

            chars[write++] = ch;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                   //String stt=count+"";
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
