package interfaces;

import model.Customer;
import model.FaithStore;
import model.Product;

import java.util.List;

public interface CustomerInterface {
    public List<Product> buyProducts(Customer customer, String productName, int productQuantity, FaithStore store);
}
