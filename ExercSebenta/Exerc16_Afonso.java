public class Exerc16 {
    public static void main(String[] args) {
        int n1[] = {4,4,6};
        int n2[] = {1,2,3};
        
        function(n1, n2);
    }
    public static void function(int[] arr1, int[] arr2){
        
        int[] arr = new int[arr1.length+arr2.length];

        for(int i = 0; i<arr1.length;i++){
            arr[i] = arr1[i];
        }
        for(int i = 0; i<arr2.length;i++){
            arr[arr1.length+i] = arr2[i];
        }

        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int num1 = 0;
                int num2 = 0;
                if(arr[i]>arr[j]){
                    num1 = arr[i];
                    num2 = arr[j];
                    arr[j] = num1;
                    arr[i] = num2;
                }
            }
            System.out.print(arr[i]);
        }
    }
}
