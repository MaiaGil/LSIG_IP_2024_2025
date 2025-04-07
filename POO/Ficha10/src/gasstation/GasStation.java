package gasstation;

public class GasStation extends Company implements GasService {

    private double gasPrice;

    public GasStation(String name, int varNumber, int gasPrice) {
        super(name, varNumber);
        this.gasPrice = gasPrice;
    }

    @Override
    public double getGasPrice(){
        return this.gasPrice;
    }

    @Override
    public void setGasPrice(double price){
        this.gasPrice = price;
    }

    @Override
    public double getGasTotal(double litres){
        return this.gasPrice * litres;
    }

}
