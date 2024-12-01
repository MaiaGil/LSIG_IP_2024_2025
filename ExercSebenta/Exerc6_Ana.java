public class Main {
    public static void main(String[] args) {

        int n = 5;
        long res = function(n);
        System.out.println("Resultado: " + res);


    }

    public static long function(int n) {

        long res = 1;

        if (n < 0) {
            return -1;
        }
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
