import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindKMajor {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int K = 4;
        printKMajor(arr, K);
    }

    public static void printKMajor(int[] arr, int k) {
        if (k < 2) {
            System.out.println("k小于2是无效参数!");
            return;
        }

        HashMap<Integer, Integer> cands = new HashMap<Integer, Integer>();

        //获取k-1个数
        for (int i = 0; i < arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                int times = cands.get(arr[i]);
                cands.put(arr[i], times + 1);
            } else {
                if (cands.size() == k) {
                    allCandMinusOne(cands);
                } else {
                    cands.put(arr[i], 1);
                }
            }
        }

        HashMap<Integer, Integer> reals = getReals(arr, cands);

        boolean isOk = false;

        for (Map.Entry<Integer, Integer> entry :
                reals.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();


            if (value > arr.length / k) {
                System.out.println("符合要求的数: " + key);

                isOk = true;
            }
        }

        System.out.println(isOk ? "" : "没有符合要求的数!");


    }

    public static HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                Integer times = reals.get(arr[i]);

                if (times == null) {
                    reals.put(arr[i], 1);
                } else {
                    reals.put(arr[i], times + 1);
                }
            }
        }
        return reals;
    }

    public static void allCandMinusOne(HashMap<Integer, Integer> cands) {
        LinkedList<Integer> removeList = new LinkedList<Integer>();

        for (Map.Entry<Integer, Integer> entry : cands.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value == 1) {
                removeList.add(key);
            } else {
                cands.put(key, value - 1);
            }
        }

        for (Integer i : removeList) {
            cands.remove(i);
        }
    }

}
