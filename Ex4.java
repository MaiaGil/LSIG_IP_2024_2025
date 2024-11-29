public class Ex4 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1,5,-2,5,6};
        char acc[] = new char[] { 'a','g','h'};
        System.out.println(getchar(arr, acc));
    }

    public static String getchar(int[] arr, char[] acc) {
        //validar numeros interios
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0)
                return "";
        }

        // validar tamanho minimo
        if (arr.length == 0)
            return "";
        if (acc.length == 0)
            return "";

        // Validar tamanho dos arrays
        String resultado = "";

        if ((arr.length == acc.length) || (arr.length < acc.length)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    resultado += acc[i];
                }
            }
        } else {
            char ultimo = acc[0];
            for (int i = 0; i < arr.length; i++) {
                if (acc.length < i + 1) {
                    for (int j = 0; j < arr[i]; j++) {
                        resultado += ultimo;
                    }
                } else {
                    for (int j = 0; j < arr[i]; j++) {
                        resultado += acc[i];
                    }
                    ultimo = acc[i];
                }
            }
        }

        return resultado;
    }
}
// 