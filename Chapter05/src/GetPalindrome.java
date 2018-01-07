public class GetPalindrome {

    public static void main(String[] args) {
        String str = "AB1CD2EFG3H43IJK2L1MN";
        System.out.println(palindrome(str));
    }

    public static String palindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chs = str.toCharArray();

        int[][] dp = getDp(chs);

        char[] res = new char[chs.length + dp[0][dp[0].length - 1]];

        int i = 0;
        int j = chs.length - 1;

        int left = 0;
        int right = res.length - 1;

        while (i <= j) {
            if (chs[i] == chs[j]) {
                res[left++] = chs[i++];
                res[right--] = chs[j--];
            }else {
                if (dp[i][j-1] < dp[i+1][j]){
                    res[left++] = chs[j];
                    res[right--] = chs[j--];
                }else {
                    res[left++] = chs[i];
                    res[right--] = chs[i++];
                }
            }
        }

        return String.valueOf(res);
    }

    public static int[][] getDp(char[] chs) {
        int len = chs.length;

        int[][] dp = new int[len][len];

        for (int j = 1; j < len; j++) {
            dp[j - 1][j] = (chs[j - 1] == chs[j] ? 0 : 1);

            for (int i = j - 2; i > -1; i--) {
                if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }

            }
        }
        return dp;
    }
}
