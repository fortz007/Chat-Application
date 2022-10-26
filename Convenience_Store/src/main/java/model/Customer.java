package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    private Integer quantity = 0;
    private List<Product> cart = new ArrayList<Product>();

    private double wallet;
    public Customer() {
    }

    public Customer(Integer id, String name, Character sex, String contact, double wallet) {
        super(id, name, sex, contact);
        this.wallet = wallet;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "quantity=" + quantity +
                ", cart=" + cart +
                ", wallet=" + wallet +
                "} " + super.toString();
    }
}
