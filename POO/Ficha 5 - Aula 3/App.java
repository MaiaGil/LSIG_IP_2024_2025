import pp_fp05.expenses.Expenses;
import pp_fp05.expenses.USer;
import pp_fp05.expenses.Users;
public class App {
    static Users user = new Users();
    public static void main(String[] args) throws Exception {
   
        USer ovo = new USer();
        ovo.setName("joão");
        user.add(ovo);

        USer teste = new USer();
        teste.setName("xvzvv");
        user.add(teste);
        Expenses despesa = new Expenses("Comida", 13.453f, "2025-04-02");
        user.users[user.search(teste)].addExpenses(despesa);
        user.users[user.search(teste)].deleteExpense(despesa);

        user.update(ovo);
        user.delete(ovo);
        //System.out.println(user.users[user.search(ovo)].getNome());
        System.out.println(user.users[user.search(teste)].despesa[user.users[user.search(teste)].searchExpense(despesa)].getAmount() + " euros");
    }
}
