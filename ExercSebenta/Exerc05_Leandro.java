public class Ex5 {
    public static void main(String[] args) {
        double arr[] = new double[] {2, 4, 2.2, 3.1, 3, 4.1};
        double x = 2.0;
        System.out.println("The value of the polynomial at x = " + x + " is: " + calcpolin(arr, x));
    }
    public static double calcpolin(double[] arr, double x) {
        double calc = 0;
        for(int i = 0; i < arr.length; i++){
            calc += arr[i] * Math.pow(x,i);
        }
        return calc;
    }
}
