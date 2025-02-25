public class Exerc24 {
    public static void main(String[] arg){
        int[] alt = {550, 570, 700, 200, 50, 55};
        System.out.println(function(alt));
    }

    public static int function(int[] altitudes) {
        int desnivel = 0;
        for(int i = 1; i<altitudes.length; i++){
            if(altitudes[i]-altitudes[i-1]>0){
                desnivel += altitudes[i]-altitudes[i-1];
            }
        }
        
        return desnivel; 
    }

}
