package pp_fp06.pizza_restaurant.enums;

public enum TamanhoPizza {
    PEQUENA, MEDIA, FAMILIAR;

    public static String pizzaToString(TamanhoPizza size){
        switch (size) {
            case PEQUENA:
                return "Esta pizza é pequena";
            case MEDIA:
                return "Esta pizza é media";
            case FAMILIAR:
                return "Esta pizza é familiar";
            default:
                return "Esta opção não representa nenhum tamanho";
        }
    }
}
