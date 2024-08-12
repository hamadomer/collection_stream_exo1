package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Purchase {

    private Client client;

    private  String product;

    private int quantity = 0;

    private LocalDate purchaseDate;

    public Purchase(Client client, String product, int quantity, LocalDate purchaseDate) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return quantity == purchase.quantity && Objects.equals(client, purchase.client) && Objects.equals(product, purchase.product) && Objects.equals(purchaseDate, purchase.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, product, quantity, purchaseDate);
    }
}