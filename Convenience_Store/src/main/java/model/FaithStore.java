package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FaithStore {
    private static List<Product> productList = new ArrayList<Product>();

    public static Queue<Customer> allCustomers = new LinkedList<>();

    public FaithStore() {
    }

    public FaithStore(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
