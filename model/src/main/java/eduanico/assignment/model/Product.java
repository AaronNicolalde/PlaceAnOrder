package eduanico.assignment.model;

import java.util.Objects;


public class Product {
    private final int productCode;
    private int quantity;

    public Product(int productCode, int quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productCode == product.productCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode);
    }
}
