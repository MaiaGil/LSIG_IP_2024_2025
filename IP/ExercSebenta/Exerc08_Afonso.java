public class Exerc8 {
    public static void main(String[] arg){
        int n = 3;
        function(n);
    }

    public static void function(int n) {
        // Students will implement this method.
        String res = "";
        int tabu = 0;
        for(int i = 1; i<=10; i++){
            tabu = i*n;
            res += "\n"+i+"x"+n+"="+tabu;
        }

        System.out.println(res);
    }
}
