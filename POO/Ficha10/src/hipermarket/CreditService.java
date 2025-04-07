package hipermarket;

public interface CreditService {

    double getAnnualRate();

    void setAnnualRate(double rate);

    double computeMonthlyPayment(double amount, int moths);

}
