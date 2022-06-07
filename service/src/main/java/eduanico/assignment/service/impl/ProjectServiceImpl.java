package eduanico.assignment.service.impl;

import eduanico.assignment.model.CreditCard;
import eduanico.assignment.model.Product;
import eduanico.assignment.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements IProjectService {

    public ProjectServiceImpl() {
    }

    @Override
    public String returnUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String reserveFund(CreditCard card, int totalAmount) {
        int cardNumber = card.getNumber();
        if(!validateCard(cardNumber, totalAmount)){
            System.out.println("Incorrect data: credit card " + cardNumber + ", total amount "+ totalAmount);
            return null;
        }
        String fundReserverdCode = returnUID();
        card.setUUID(fundReserverdCode);

        System.out.println("Fund Reserved with UUID : " + fundReserverdCode);
        return fundReserverdCode;
    }

    @Override
    public boolean validateCard(int cardNumber,int totalAmount){
        String numberString = Integer.toString(cardNumber);
        if(numberString.startsWith("4000") || (totalAmount<0 ) || (cardNumber >= 4111 &&  cardNumber <= 4222) ){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInventory(Product product, CreditCard card) {
        if(card.getUUID().equals(null)){
            System.out.println("Funds were not reserved.");
            return false;
        }
        if(!validateCode(product) || !validateQuantity(product)){
            System.out.println("Invalid product code : " + product.getProductCode() +  ", quantity: " + product.getQuantity());
            return false;
        }


        return true;
    }

    @Override
    public String doPayment(Product product, CreditCard card) {
        if(!updateInventory(product,card)){
            System.out.println("Inventory not update");
            return null;
        }
        System.out.println("Inventory Updated.");
        String paymentCode = returnUID();
        return paymentCode;
    }

    @Override
    public String generateOrder() {
        String orderID = returnUID();
        return orderID;
    }

    public boolean validateCode(Product product){
        int code = product.getProductCode();
        Integer val = (Integer) code;
        if( code >= 239 && code <= 384 || val == null ){
            System.out.println("Code can not be update : " + code);
            return false;
        }
        return true;
    }

    public boolean validateQuantity(Product product){
        int quantity = product.getQuantity();
        if( quantity < 0 ){
            System.out.println("Insert a correct quantity : " + quantity);
            return false;
        }
        return true;
    }

    @Override
    public void generateOrder(Product product, CreditCard card){
        String fundReserverdCode = reserveFund(card,3000);
        if ( fundReserverdCode != null){
            if(updateInventory(product,card)){
                String paymentCode = doPayment(product,card);
                if( paymentCode != null){
                    String orderID = generateOrder();
                    System.out.println("Order Succesfully.\nFund Reserved Code : "+ fundReserverdCode + "\nPayment Code : "+ paymentCode + "\nOrder ID: " + orderID);
                }else{
                    System.out.println("Error in payment.");
                }
            }else{
                System.out.println("Error updating inventory.");
            }
        }else{
            System.out.println("Error reserving fund.");
        }
    }



}
