public class Ex6 {
    public static void main(String[] args){
        int x = 8;
        System.out.println("Fatorial de " + x + " é: " + getfact(x));
    }
    public static int getfact(int x){
        int result = 1;
        if(x<=0){
            return -1;
        } for(int i = 1; i <= x; i++){
            result*=i;
        }
        return result;
    }
}
