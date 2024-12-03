public class Exerc10 {
    public static void main(String[] arg){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int x = 0;
        int y = 12;
        System.out.println("\n"+function(arr, x, y));
    }
    public static int function(int[] arr, int x, int y) {
        int conta = 0;

        if (x==y)
            conta = 1;

        for(int i=0; i<arr.length;i++){
            if(x<y){
                if(arr[i]<=y && arr[i]>=x)
                conta++;
            }
            if(x>y){
                if(arr[i]<=x && arr[i]>=y)
                conta++;
            }
        }    
        

        return conta;
    }
}
