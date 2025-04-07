package gasstation;

public interface GasService {

    double getGasPrice();

    void setGasPrice(double price);

    double getGasTotal(double litres);
    
}
