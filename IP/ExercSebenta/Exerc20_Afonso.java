public class Exerc20 {
    public static void main(String[]arg){
        int matriz[][] = new int[][]{{4,5,6},{1,2,3},{7,8,9}};
        System.out.println("\n"+function(matriz));

    }
    public static int function(int[][] matrix) {
        // a contasup e a containf vão ter o [0][+oo] e [+oo][0] e todos que cruzem essa linha
        int contasup = 0;
        int containf = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                if(j<matrix.length-1-i){
                    contasup += matrix[i][j];  
                }
                if(j>matrix.length-1-i){
                    containf += matrix[i][j];
                }
            }
        }
        
        if (contasup<containf){
            return -1;
        }
        if (contasup>containf){
            return 1;
        }
        if (contasup==containf){
            return 0;
        }   
        return 1;
    }
}
