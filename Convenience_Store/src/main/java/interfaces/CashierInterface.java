package interfaces;

import model.Customer;
import model.FaithStore;

import java.util.Collection;

public interface CashierInterface {


    String dispenseReceipts(Customer customer);

    String sell(Customer customer);

    void sellToQueue(Collection<Customer> customers);

    public void productCatalogue(FaithStore store, String filePath);
}
