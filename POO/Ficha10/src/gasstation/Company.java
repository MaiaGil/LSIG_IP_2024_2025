package gasstation;

public class Company {
    private String name;
    private int varNumber;

    public Company(String name, int varNumber) {
        this.name = name;
        this.varNumber = varNumber;
    }

    public String getName() {
        return name;
    }

    public int getVarNumber() {
        return varNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVarNumber(int varNumber) {
        this.varNumber = varNumber;
    }
}
