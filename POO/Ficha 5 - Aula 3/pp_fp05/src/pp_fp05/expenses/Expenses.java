package pp_fp05.expenses;

public class Expenses {
    private static int lastID = 0;
    protected int id;
    protected String type;
    protected float amount;
    protected String date;

    public Expenses(String type, float amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        id = ++lastID;
    }

    public Expenses() {
        id = ++lastID;
    }

    /**
     * Use this priority to get the id of a expense
     * @return the id of a expense
     */
    public int getId(){
        return id;
    }

    /**
     * Use this priority to set the amount of a expense, in case it dosent exist
     * @param amount the amount to set
     */
    public void setAmount(float amount){
        this.amount = amount;
    }

    /**
     * Use this priority to set the type of a expense, in case it dosent exist
     * @param type the type of an expense
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Use this priority to set the date of a expense, in case it dosent exist
     * the date must be in this order YYYY-MM-DD
     * @param type the date to set
     */
    public void setDate(String date){
        this.date = date;
    }


    /**
     * Use this method to see what is the amount
     * @return the amount
     */
    public float getAmount(){
        return this.amount;
    }

    /**
     * Use this method to see what is the type 
     * @return the type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Use this method to see what is the date
     * @return the date
     */
    public String getDate(){
        return this.date;
    }
}
