public class Exerc2 {
    public static void main(String[] args) {
        int arr[] = {1,2,1,4,56,7,8,8,15};
        int target = 0;
        int ultima = function(arr,target);
        System.out.println("\nO numero " + target + " aparece na posição "+ ultima );
    }

    public static int function(int[] arr, int target) {
        // Students will implement this method.
       
        /*
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i]==target)
                return i;
        }
        */

        ///*
        int i = arr.length-1;

        while(i>=0)
            if(arr[i]==target)
                return i;
            i--;
        //*/
       
        return -1;
    }
}
