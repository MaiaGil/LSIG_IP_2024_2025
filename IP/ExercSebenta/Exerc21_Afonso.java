public class Exerc21 {
    public static void main(String[] args) {
        String abc= "";
        System.out.println(function(abc));
    }
    public static String function(String str){
        String res = "";

        if(str.length()==0){
            return "";
        }

        for(int i = 1; i<str.length();i++){
            res += str.charAt(i);
        }

        res += str.charAt(0);
        return res;
    }

}
