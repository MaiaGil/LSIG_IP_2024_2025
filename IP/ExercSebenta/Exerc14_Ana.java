public class Main {
    public static void main(String[] args) {

            String[] names = {"Maria", "Manuel", "Maria", "António"};
            double[] prices = {12.0, 3.5, 15.6, 0.90};
            String friendName = "Maria";

            System.out.println(function(names, prices, friendName));
    }

    public static double function(String[] names, double[] prices, String friendName) {

        double total = 0;

        for(int i = 0; i < prices.length; i++) {
            if(names[i] == friendName) {
                total += prices[i];
            }
        }
        return total;
    }
}
