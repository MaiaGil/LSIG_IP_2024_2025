public class Main {
    public static void main(String[] args) {

        int n = 3;
        function(n);

    }

    public static void function(int n) {

        String tabu = "";

        for (int i = 1; i <= 10; i++) {
            tabu = (i + "x" + n + "=" + i * n);
            System.out.println(tabu);
        }
    }
}
