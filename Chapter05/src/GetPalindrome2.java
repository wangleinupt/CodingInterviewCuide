public class GetPalindrome2 {

    public static void main(String[] args) {
        String str = "AB1CD2EFG3H43IJK2L1MN";

        String strlps = "1234321";
        System.out.println(palindrome2(str, strlps));
    }

    public static String palindrome2(String str, String strpls) {
        char[] chs = str.toCharArray();
        char[] pls = strpls.toCharArray();
        char[] res = new char[chs.length * 2 - pls.length];

        int plsl = 0;
        int plsr = pls.length - 1;

        int chsl = 0;
        int chsr = chs.length - 1;

        int resl = 0;
        int resr = res.length - 1;

        int tmpl = 0;
        int tmpr = 0;

        while (plsl <= plsr) {
            tmpl = chsl;
            tmpr = chsr;

            while (chs[chsl] != pls[plsl]) {
                chsl++;
            }

            while (chs[chsr] != pls[plsr]) {
                chsr--;
            }

            insert(res, resl, resr, chs, tmpl, chsl, chsr, tmpr);

            resl += (chsl - tmpl) + (tmpr - chsr);
            resr -= (chsl - tmpl) + (tmpr - chsr);
            res[resl++] = chs[chsl++];
            res[resr--] = chs[chsr--];
            plsl++;
            plsr--;
        }

        return String.valueOf(res);
    }

    public static void insert(char[] res, int resl, int resr, char[] chs, int ls, int le, int rs, int re) {
        for (int i = ls; i < le; i++) {
            res[resl++] = chs[i];
            res[resr--] = chs[i];
        }

        for (int i = re; i > rs; i--) {
            res[resl++] = chs[i];
            res[resr--] = chs[i];
        }
    }
}
