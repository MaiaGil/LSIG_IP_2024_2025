package supermarket;

import gasstation.Company;

public class Supermarket extends Company implements MarketService {

    private double potatoPrice;

    public Supermarket(String name, int varNumber){
        super(name, varNumber);
    }

    @Override
    public double getPotatoPrice() {
        return this.potatoPrice;
    }

    @Override
    public void setPotatoPrice(double potatoPrice) {
        this.potatoPrice = potatoPrice;
    }

    @Override
    public double getMarketTotal(double kilos){
        return potatoPrice * kilos;
    }

}
