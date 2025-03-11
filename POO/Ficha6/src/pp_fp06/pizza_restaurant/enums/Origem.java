package pp_fp06.pizza_restaurant.enums;

public enum Origem {
    ANIMAL,VEGETAL,MINERAL;

    public static String pizzaToString(Origem origin){
        switch (origin) {
            case ANIMAL:
                return "Este ingrediente tem origem animal";
            case VEGETAL:
                return "Este ingrediente tem origem vegetal";
            case MINERAL:
                return "Este ingrediente tem origem mineral";
            default:
                return "Esta opção não representa nenhuma tipo de origem do ingrediente";
        }
    }
}
