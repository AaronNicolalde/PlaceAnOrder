package eduanico;

public class CreditCard {
    private final int number;
    private String UUID = null;

    public CreditCard(int number) {
        this.number = number;

    }

    public int getNumber() {
        return number;
    }


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }


}