package pp_fp05.expenses;
import java.util.Scanner;

public class Users {
    private static final int SIZE = 20;
    public USer[] users;
    private static int count;
    private Scanner in = new Scanner(System.in);

    //constructors
    public Users(){
        users = new USer[SIZE];
        count = 0;
    }

    //properties
    /**
     * 
     * @return the number of user that already exist
     */
    public int getCount(){
        return this.count;
    }

    //methods

    /**
     * Use this method to add a new user to the list of users
     * @param user the user you want to add
     */
    public void add(USer user){
        this.users[count++] = user;
    }

    /**
     * Use this method to add a new user to the list of users, in this case you will use the name of the new User
     * @param nome name of the new user
     */
    public void add(String nome){
        USer user = new USer(nome);

        this.add(user);
    }

    /**
     * Use this method to update the caracteristic of the User
     * @param user the User you want to update
     */
    public void update(USer user){
        int pos  = search(user);
        
        System.out.print("\nEscolha o novo nome - ");
        String nome = in.nextLine();

        users[pos].setName(nome);
    }

    /**
     * Use this method to remove a user from your list
     * @param user the User you want to delete
     */
    public void delete(USer user){
        int pos  = search(user);

        for(int i = pos; i < count-1; i++){
            users[i] = users[i+1];
        }
        count--;
        System.out.println("User deleted successfully");
    }

    /**
     * Use this method to know what is the position of the User in the array
     * @param user the User you want to know
     * @return the position of the User
     */
    public int search(USer user){
        int pos = user.getId()-1;
        return pos;
    }
}
