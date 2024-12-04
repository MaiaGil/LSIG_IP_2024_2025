public class Exerc13 {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int tam = 10;
        function(x, y, tam);
        
    

    }
    public static int[] function(int x, int y, int tam){

        if(tam<=0){
            return new int[]{}; 
        }
         
        int arr[] = new int[tam];
        arr[0]=x;
        
        for(int i = 0; i<tam-1; i++){
            arr[i+1]=arr[i]+y;
           
        }
       
        return arr;
    }
}
