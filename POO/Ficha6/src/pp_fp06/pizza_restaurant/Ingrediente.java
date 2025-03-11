package pp_fp06.pizza_restaurant;
import pp_fp06.pizza_restaurant.enums.Origem;

public class Ingrediente {
    private int id;
    private static int idCounter = 0;
    private String nome;
    private Origem origem;
    private int calorias;
    private double numberUsed;

    public Ingrediente(String nome, Origem origem, int calorias, int numberUsed) {
        this.id = ++idCounter;
        this.nome = nome;
        this.origem = origem;
        this.calorias = calorias;
        this.numberUsed = numberUsed;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.nome;
    }

    public Origem getOrigem(){
        return this.origem;
    }

    public int getCal(){
        return this.calorias;
    }

    public double getNumberUsed(){
        return this.numberUsed;
    }
}
