public class Exerc5 {
    public static void main(String[] arg){

        double x = 3;
        double [] valores = {1.3, 2.1, 2.3};
        System.out.println("\n"+function(valores,x));
        


    }
    public static double function(double[] coefficients, double x) 
    {
        double res = 0;    
        for (int i = 0; i < coefficients.length; i++) {        
            res += coefficients[i] * Math.pow(x, i);    
            
        }   
        return res;
        //return 0; // Placeholder return
    }
}
