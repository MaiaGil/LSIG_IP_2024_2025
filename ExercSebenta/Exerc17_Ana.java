import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        char[] arr2 = function(arr);

        System.out.println("Array: " + Arrays.toString(arr2));

    }

    public static char[] function(char[] arr) {

        char[] arr2 = new char[arr.length];

        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - i - 1];
        }
        return arr2;
    }
}
