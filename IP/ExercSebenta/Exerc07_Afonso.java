public class Exerc7 {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(function(n));
    }

    public static boolean function(int n) {
        if(n<=1)
            return false;
            
        if(n==2)
            System.out.println("O numero e primo");

        for(int i = 2; i<n; i++){
            if (n%i!=0)
                System.out.println("O numero e primo");
            else
                return false;
        }
        
        return true;
    }
}
