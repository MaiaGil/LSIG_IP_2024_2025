package pp_fp05.expenses;
import java.util.Scanner;

public class USer {
    private Scanner in = new Scanner(System.in);
    private static int Lastid = 0;
    private int id;
    private String nome;//,email, birthDay;

    public Expenses[] despesa;
    private static final int SIZE = 200;
    private static int count;


    public USer() {
        this.id = ++Lastid;
        this.despesa = new Expenses[SIZE];
        this.count = 0;
    }

    public USer(String nome){
        this.id = ++Lastid;
        this.nome = nome;
        this.despesa = new Expenses[SIZE];
        this.count = 0;
    }

    /**
     * Use this propertie to get the id of a user
     * @return the id of a user
     */
    public int getId() {
        return id;
    }

    /**
     * Use this propertie to get the name of a user
     * @return the name of a user
     */
    public String getNome() {
        return nome;
    }

    /**
     * Use this propertie to set the name of a user
     * @param nome the name of the user
     */
    public void setName(String nome){
        this.nome = nome;
    }
    
    /**
     * Use this method to add a Expense to a user
     * @param despesa the expense that will be added
     */
    public void addExpenses(Expenses despesa){
        this.despesa[count++] = despesa;
    }

    /**
     * Use this method to add expense to a user, using the amount, the type and the date of the expense 
     * @param amount the amount spend on the expense
     * @param type the type of expense 
     * @param date the date of the expense, the date must be in this order YYYY-MM-DD
     */
    public void addExpenses(int amount, String type, String date){
        Expenses despesa = new Expenses(type, amount, date);

        this.addExpenses(despesa);
    }

    /**
     * Use this method to search the array of Expenses and know what is the position of that expense
     * @param despesa the expense you want to know 
     * @return the positon of that expense
     */
    public int searchExpense(Expenses despesa){
        int pos = despesa.getId()-1;
        return pos;
    }

    /**
     * Use this method to update the expense caracteristic
     * the date must be in this order YYYY-MM-DD
     * @param despesa the expense that you want to update
     */
    public void updateExpense(Expenses despesa){
        int pos = searchExpense(despesa);

        System.out.print("Choose the new amount - ");
        float amount = in.nextFloat();
        this.despesa[pos].setAmount(amount);

        System.out.print("Choose the new type - ");
        String type = in.nextLine();
        this.despesa[pos].setType(type);

        System.out.print("Choose the new date - ");
        String date = in.nextLine();
        this.despesa[pos].setDate(date);
    }

    /**
     * Use this method to remove a expense from your list
     * @param despesa the expense you want to delete
     */
    public void deleteExpense(Expenses despesa){
        int pos = searchExpense(despesa);

        for(int i = pos; i < count-1; i++){
            this.despesa[i] = this.despesa[i+1];
        }
        count--;
    }

    /**
     * Use this method to add the amount of all your expenses
     * @return the value of all your expenses
     */
    public float allExpenses(){
        float soma = 0;
        for (int i = 0; i < despesa.length; i++){
            soma += despesa[i].amount;
        }
        return soma;
    }
}