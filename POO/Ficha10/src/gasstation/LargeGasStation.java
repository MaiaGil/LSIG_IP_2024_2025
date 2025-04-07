package gasstation;

public class LargeGasStation extends GasStation implements CoffeService {

    private double coffePrice;

    public LargeGasStation(String name, int varNumber, int gasPrice, double coffePrice) {
        super(name, varNumber, gasPrice);
        this.coffePrice = coffePrice;
    }

    @Override
    public double getCoffePrice() {
        return this.coffePrice;
    }

    @Override
    public void setCoffePrice(double coffePrice) {
        this.coffePrice = coffePrice;
    }

    @Override
    public double getCoffeTotal(int coffees){
        return coffees * this.coffePrice;
    }
}
