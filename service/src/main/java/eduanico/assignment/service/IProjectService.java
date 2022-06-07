package eduanico.assignment.service;

import eduanico.assignment.model.CreditCard;
import eduanico.assignment.model.Product;

public interface IProjectService {
    String returnUID();
    boolean validateCard(int cardNumber, int totalAmount);


    String reserveFund(CreditCard card,int totalAmount);
    boolean updateInventory(Product product, CreditCard card);
    String doPayment(Product product, CreditCard card);
    String generateOrder();

    void generateOrder(Product product, CreditCard card);
}
