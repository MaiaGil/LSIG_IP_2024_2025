public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        boolean res = function(array);

        System.out.println("Resultado para o array: " + Arrays.toString(array)+": "+res);

    }

    public static boolean function(int[] array) {

        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] == array[j])
                    return true;
            }
        }

        return false;
    }
}
