package Services;

import interfaces.CustomerInterface;
import model.Customer;
import model.FaithStore;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerServices implements CustomerInterface {
    List<Product> totalProducts = new ArrayList<Product>();
    @Override
    public List<Product> buyProducts(Customer customer, String productName, int productQuantity, FaithStore store) {
        Double productTotalPrice = 0.0;

        int count = 0;
        for(int i =0; i<store.getProductList().size(); i++) {
            if(store.getProductList().get(i).getProductName().equalsIgnoreCase(productName)) {
                count ++;
            }
        }
        if ( count < 1) System.out.println("Product not available");

            for(int i=0; i<store.getProductList().size(); i++){
                if(store.getProductList().get(i).getProductName().equalsIgnoreCase(productName)) {
                    if (store.getProductList().get(i).getProductQuantity() >= productQuantity) {
                        if (customer.getWallet() >= store.getProductList().get(i).getProductPrice() * productQuantity) {

                            System.out.println(store.getProductList().get(i).getProductName() + " added to cart successfully");

                            totalProducts.add(new Product(store.getProductList().get(i).getProductId(),
                                    store.getProductList().get(i).getProductName(), store.getProductList().get(i).getProductPrice(),
                                    productQuantity, store.getProductList().get(i).getProductCategory()));

                            customer.setQuantity(customer.getQuantity() + productQuantity);

                            customer.setCart(totalProducts);

                            productTotalPrice += store.getProductList().get(i).getProductPrice();

                            double balance = customer.getWallet() - productTotalPrice * productQuantity;
                            customer.setWallet(balance);
                            break;
                        } else {
                            System.out.println("Insufficient funds");
                        }
                    } else {
                        System.out.println("OUT OF STOCK");
                    }
                }
            }

            return customer.getCart();
    }

    @Override
    public String toString() {
        return "CustomerServices{" +
                "totalProducts=" + totalProducts +
                '}';
    }
}
