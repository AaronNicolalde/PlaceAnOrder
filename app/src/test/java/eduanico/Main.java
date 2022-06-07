package eduanico;

public class Main {
    private static ProjectServiceImpl service = new ProjectServiceImpl();
    public static void main(String[] args) {

        Product product = new Product(238, 0);
        CreditCard card = new CreditCard(4110);

        generateOrder(product,card);
    }

    public static void generateOrder(Product product, CreditCard card){
        String fundReserverdCode = service.reserveFund(card,20);
        if ( fundReserverdCode != null){
            if(service.updateInventory(product,card)){
                String paymentCode = service.doPayment(product,card);
                if( paymentCode != null){
                    String orderID = service.generateOrder();
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
