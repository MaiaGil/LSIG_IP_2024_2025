public class Main {
    public static void main(String[] args) {

        int n = 5;
        boolean res = function(n);
        System.out.println("Resultado: " + res);
    }

    public static boolean function(int n) {
        if (n < 0) {
            return false;
        }

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i < n; i++) {
            if (n % i == 0  && n % n == 0) {
                return false;
            }
        }
        return true;
    }
}
