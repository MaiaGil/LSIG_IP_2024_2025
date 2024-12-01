public class Exerc4 {
    public static void main(String[] arg){
        int num[] = {1,2,3, 4};
        char letra[] = {'a','b','c'};
        System.out.println("");
        System.out.println(function(num,letra));
    }

    

    public static String function(int[] counts, char[] chars) {

        String res = "";

        if (counts.length==0 )
            return"";

        if (chars.length==0)
            return"";


        for (int i = 0; i < counts.length; i++) {
            if(counts[i]<0)
                return "";
        }

        if(counts.length==chars.length){
            for(int i = 0;i<counts.length;i++){
                for (int j = 0; j<counts[i]; j++){
                    res += chars[i];
                }
            }
        }
            
        if(counts.length<chars.length){
            for(int i = 0;i<chars.length;i++){
                if(i>counts.length){
                    break;
                }
                if(i<counts.length){
                    for (int j = 0; j<counts[i]; j++){
                        res += chars[i];
                    }
                }
            }
        }

        if (counts.length>chars.length){
            for(int i = 0;i<counts.length;i++){ 
                if (i>=chars.length){
                
                    for (int j = 0; j<counts[i]; j++){
                        res += chars[chars.length-1];     
                    }   
                }
                if (i<chars.length)
                    for (int j = 0; j<counts[i]; j++){
                        res += chars[i];
                    }     
            }
        }
        
        return res;
    }
}
