public class FindHalfMajor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 1, 2, 2, 2,2};
        printHalfMajor(arr);
    }

    public static void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;

        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
            } else if (cand == arr[i]) {
                times++;
            } else {
                times--;
            }
        }

        times = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                times++;
            }
        }

        if (times > arr.length / 2) {
            System.out.println("数组中出现超过一半的数是: " + cand);
        } else {
            System.out.println("数组中没有超过一半的数！");
        }


    }

}
