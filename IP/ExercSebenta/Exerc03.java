public class Exerc3 {
    public static void main(String[] args) {
        int [] arr = {10, 20, 30};
        double [] peso = {0.2, 0.3, 0.5};
        System.out.println(function(arr,peso));
    }

    public static double function(int[] values, double[] weights) {
        // Students will implement this method.
        if (values.length != weights.length)
            return -1;

        for(int i = 0; i<values.length; i++){
            if (values[i]<0)
                return -1;
        }

        double conta = weights[0];
        for(int i = 1; i<weights.length; i++){
            conta += weights[i];
        }
        if (conta != 1.0)
            return -1;

        double media = values[0]*weights[0];
        for(int i = 1; i<weights.length; i++)
            media += values[i]*weights[i];

        return media; // Placeholder return
    }

}
