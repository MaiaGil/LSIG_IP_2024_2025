public class Exerc1 {
    public static void main(String[] args) {
        int arr[] = {1,2,1,4,56,7,8,8,15};
        int target = 1;
        function(arr,target);
    }
    
    public static int function(int arr[], int target) {
        int conta = 0;
        
        for(int i = 0; i<arr.length; i++){
            if (arr[i]==target)
                conta++;
        }

        /*int i = 0;
        while(i<arr.length){
            if (arr[i]==target)
                conta += 1;
            i += 1;
        }*/

        System.out.print("O numero " + target + " aparece " + conta + " vezes.");
        return conta; 
    }

    
    
}


