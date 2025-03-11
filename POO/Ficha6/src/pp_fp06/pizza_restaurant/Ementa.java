package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.TamanhoPizza;

public class Ementa {
    private String designacao;
    private String description;
    private int id;
    private static int idCounter = 0;
    private String startDate;//Do tipo DD-MM-YYYY
    private String finishDate;//Do tipo DD-MM-YYYY
    private final int NUMBERPIZZAS;
    private int countPizzas;
    private Pizza[] pizzas;

    public Ementa(String designacao, String description, String startDate) {
        this.designacao = designacao;
        this.description = description;
        this.id = ++idCounter;
        this.startDate = startDate;
        this.NUMBERPIZZAS = 10;
        this.pizzas = new Pizza[NUMBERPIZZAS];
        this.countPizzas = 0;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    
    public int getNumberPizzas() {
        return NUMBERPIZZAS;
    }
    

    public int getCountPizzas() {
        return countPizzas;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void addPizza(Pizza pizza){
        if (this.countPizzas > this.NUMBERPIZZAS){
            System.out.println("Erro: A ementa já tem o numero maximo de pizzas");
            return;
        }

        pizzas[this.countPizzas++] = pizza;
    }

    public void addPizza(String nome, String description, double preço, TamanhoPizza tamanho){
        Pizza pizza = new Pizza(nome, description, preço, tamanho);

        this.addPizza(pizza);
    }

    public boolean searchPizza(int id){
        for (int i = 0; i < this.countPizzas; i++){
            if (this.pizzas[i].getId() == id){
                return true;
            }
        }
        System.out.println("Erro: Does not exist any pizza with this id");
        return false;
    }

    public void pizzaInformation(int id){
        if (this.searchPizza(id)){
            for (int i = 0; i < this.countPizzas; i++){
                if (this.pizzas[i].getId() == id){
                    System.out.println("Nome: " + this.pizzas[i].getName());
                    System.out.println("description: " + this.pizzas[i].getDescription());
                    System.out.println("Preço: " + this.pizzas[i].getPreco());
                    System.out.println("Tamanho: " + this.pizzas[i].getSize());
                    this.pizzas[i].knowIngredientes();
                    return;
                }
            }
        }
    }

    public void pizzaCalories(int id){
        if (this.searchPizza(id)){
            for (int i = 0; i < this.countPizzas; i++){
                if (this.pizzas[i].getId() == id){
                    
                }
            }
        }
    }

}
