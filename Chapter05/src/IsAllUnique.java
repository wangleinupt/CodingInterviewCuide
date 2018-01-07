public class IsAllUnique {
    public static void main(String[] args) {
    char[] chs = {'a','b','c','d'};

        System.out.println(isUnique(chs));
    }

    public static boolean isUnique(char[] chs){
        boolean[] map = new boolean[256];

        for (int i = 0; i < chs.length; i++) {
            int index = chs[i];

            if (map[index]){
                return false;
            }else {
                map[index] = true;
            }
        }
        return true;
    }
}
