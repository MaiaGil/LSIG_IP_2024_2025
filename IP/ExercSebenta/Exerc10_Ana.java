public class Main {
    public static void main(String[] args) {


        int[] arr = {1, 3, 7, 9, 15, 20, 25};
        int x = 1;
        int y = 5;

        System.out.println(function(arr, x, y));
    }

    public static int function(int[] arr, int x, int y) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x && arr[i] <= y) {
                count++;

            } else {
                if (arr[i] <= x && arr[i] >= y) {
                    count++;
                }
            }
        }
        return count;
    }
}
