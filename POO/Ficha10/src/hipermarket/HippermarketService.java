package hipermarket;
import gasstation.*;//O * é para dar import a tudo o que está dentro do packadge
import supermarket.*;

public interface HippermarketService extends CoffeService, GasService, MarketService, CreditService{
    //Quando uma interface usa os metodos de outras interfaces está tem de ser usadaom um extend
}


