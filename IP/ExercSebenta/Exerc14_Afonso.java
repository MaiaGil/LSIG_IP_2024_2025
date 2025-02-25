public class Exerc14 {
    public static void main(String[] args) {
        String nomes[]= {"Maria", "Manuel", "Maria", "António"};

        String nomamigo = "Maria";

        double custos[] = {12.0, 3.5, 15.6, 0.90};

        System.out.println(function(nomes, custos, nomamigo));

        
    }
    public static double function(String names[], double prices[], String friendName){

        double total = 0;
        for(int i = 0; i<names.length; i++){
            if(names[i]==friendName){
                total += prices[i];
            }
        }
         
        return total;

    }
}
