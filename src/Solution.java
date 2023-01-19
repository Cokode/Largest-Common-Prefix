public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        int count = 0;
        int indexOfS = 0;
        String smallWord = strs[0];
        String prefix = "";

        if (strs.length == 1) {
            prefix = strs[0];
            return prefix;
        }

        for (int a = 0; a < strs.length; a++) {
            if (strs[a].isEmpty()) {
                return "";
            }
            if (strs[a].length() < len) {
                smallWord = strs[a];
                indexOfS = a;
            }
        }

        for (int i = 0, j = 0; i < strs.length; i++) {
            char temp = strs[indexOfS].charAt(j);
            int len2 = strs.length-1;

            if ((strs[len2].charAt(j) != temp && i == 0
                    && prefix.isEmpty())|| strs[len2].isEmpty()) {
                return "";
            }

            if (strs[i].charAt(j) == temp) {
                count ++;

                if (count == strs.length && i == strs.length-1) {
                    prefix += temp;
                    count = 0;

                    if (i == strs.length - 1 && j == smallWord.length()-1) {
                        return prefix;
                    }
                    i = -1;
                    j++;
                }

            } else {

                if (prefix.length() >= 1) {
                    return prefix;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String [] str = {"flower","flowere33","fl","flower"};
        String [] str2 = {"fl"};

       System.out.println(solution.longestCommonPrefix(str));
        //solution.show(str2);
    }
}
