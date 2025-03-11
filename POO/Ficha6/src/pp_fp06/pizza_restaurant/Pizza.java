package pp_fp06.pizza_restaurant;
import pp_fp06.pizza_restaurant.enums.Origem;
import pp_fp06.pizza_restaurant.enums.TamanhoPizza;

/**
 * Classe que representa uma Pizza no sistema do restaurante.
 * Cada pizza possui um ID único, nome, descrição, preço, tamanho e ingredientes.
 */
public class Pizza {
    private int id; // Identificador único da pizza
    private static int idCounter = 0; // Contador estático para gerar IDs únicos
    private String nome; // Nome da pizza
    private String description; // Descrição da pizza
    private double preco; // Preço da pizza
    private TamanhoPizza tamanho; // Tamanho da pizza
    private int numberIngredientes; // Número atual de ingredientes na pizza
    private Ingrediente[] ingredientes; // Array de ingredientes da pizza

    /**
     * Construtor da classe Pizza.
     * @param nome Nome da pizza.
     * @param description Descrição da pizza.
     * @param preco Preço da pizza.
     * @param tamanho Tamanho da pizza.
     */
    public Pizza(String nome, String description, double preco, TamanhoPizza tamanho) {
        this.id = ++idCounter;
        this.nome = nome;
        this.description = description;
        this.preco = preco;
        this.tamanho = tamanho;
        this.numberIngredientes = 0;
        this.ingredientes = new Ingrediente[5];
    }

    /**
     * Obtém o ID da pizza.
     * @return ID da pizza.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Obtém o nome da pizza.
     * @return Nome da pizza.
     */
    public String getName(){
        return this.nome;
    }

    /**
     * Obtém a descrição da pizza.
     * @return Descrição da pizza.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Obtém o preço da pizza.
     * @return Preço da pizza.
     */
    public double getPreco(){
        return this.preco;
    }

    /**
     * Obtém o tamanho da pizza.
     * @return Tamanho da pizza.
     */
    public TamanhoPizza getSize(){
        return this.tamanho;
    }

    /**
     * Adiciona um ingrediente à pizza.
     * @param ingrediente Ingrediente a ser adicionado.
     */
    public void addIngrediente(Ingrediente ingrediente){
        if (this.numberIngredientes >= 5){
            System.out.println("Erro: Esta pizza já tem 5 ingredientes");
            return;
        }
        ingredientes[this.numberIngredientes++] = ingrediente;
    }

    /**
     * Cria e adiciona um ingrediente à pizza.
     * @param nome Nome do ingrediente.
     * @param origem Origem do ingrediente.
     * @param cal Calorias do ingrediente.
     * @param numberUsed Quantidade do ingrediente usada na pizza.
     */
    public void addIngrediente(String nome, Origem origem, int cal, int numberUsed){
        Ingrediente ingrediente = new Ingrediente(nome, origem, cal, numberUsed);
        this.addIngrediente(ingrediente);
    }

    /**
     * Busca um ingrediente dentro da pizza.
     * @param ingrediente Ingrediente a ser buscado.
     * @return Posição do ingrediente no array ou -1 se não encontrado.
     */
    public int searchIngrediente(Ingrediente ingrediente){
        for (int i = 0; i < ingredientes.length; i++){
            if (ingredientes[i] == ingrediente){
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove um ingrediente da pizza.
     * @param ingrediente Ingrediente a ser removido.
     */
    public void deleteIngrediente(Ingrediente ingrediente){
        int position = searchIngrediente(ingrediente);
        if (position == -1){
            System.out.println("Este ingrediente não está na pizza");
            return;
        }
        for (int i = position; i < ingredientes.length - 1; i++){
            ingredientes[i] = ingredientes[i + 1];
        }
        ingredientes[ingredientes.length - 1] = null;
        this.numberIngredientes--;
    }

    /**
     * Exibe informações de um ingrediente específico.
     * @param id ID do ingrediente.
     */
    public void knowIngredienteInformation(int id){
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente != null && ingrediente.getId() == id) {
                System.out.println("O ingrediente " + ingrediente.getName() + " tem origem " + ingrediente.getOrigem()
                        + " e tem " + ingrediente.getCal() + " calorias.");
            }
        }
    }

    /**
     * Exibe todos os ingredientes da pizza.
     */
    public void knowIngredientes(){
        System.out.println("\nA pizza contém os seguintes ingredientes:");
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente != null) {
                System.out.println(ingrediente.getName());
            }
        }
    }

    /**
     * Calcula e retorna o total de calorias da pizza.
     * @return Total de calorias da pizza.
     */
    public double knowCalories(){
        double total = 0;
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente != null) {
                total += ingrediente.getCal() * ingrediente.getNumberUsed();
            }
        }
        return total;
    }
}

