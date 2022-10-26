package Services;

import interfaces.CashierInterface;
import model.Cashier;
import model.Customer;
import model.FaithStore;
import org.junit.jupiter.api.Test;

import static model.FaithStore.allCustomers;
import static org.junit.jupiter.api.Assertions.*;

class CashierServicesTest {

    @Test
    void productCatalogue() {String filePath = "/Users/decagon/Desktop/week-two-sq012-fortz007/Convenience_Store/src/main/resources/FaithStore_ Inventory - Sheet1.csv";
        FaithStore store = new FaithStore();
        Cashier cashier = new Cashier();

        CashierInterface cashierServ = new CashierServices();
        cashierServ.productCatalogue(store, filePath);
        assertNotEquals(store.getProductList().size(), 0);
    }

    @Test
    void sell() {
        Customer fortune = new Customer(1, "Fortune",'m',"0900000",300000.0);
        FaithStore store = new FaithStore();

        CustomerServices customerServ1 = new CustomerServices();
        customerServ1.buyProducts(fortune,"milo",7,store);

        CashierServices cashierService = new CashierServices();

        String actual = cashierService.sell(fortune);
        System.out.println(actual);
//        String expected = "Fortune, your total balance is N1050";
//        assertEquals(actual, expected);
    }

    @Test
    void sellToQueue() {
        FaithStore store = new FaithStore();

        Customer fortune = new Customer(1, "Fortune",'m',"0900000",300000.0);
        Customer faith = new Customer(2, "Faith",'f',"0900000",100000.0);
        Customer osaze = new Customer(3, "osaze",'m',"0900000",100000.0);

        CustomerServices fortuneService = new CustomerServices();
        CustomerServices osazeService = new CustomerServices();
        CustomerServices faithService = new CustomerServices();


        allCustomers.add(fortune);
        allCustomers.add(osaze);
        allCustomers.add(faith);

        int allCustomersBefore = allCustomers.size();

        fortuneService.buyProducts(fortune,"milo",7,store);
        fortuneService.buyProducts(fortune,"milo",7,store);
        fortuneService.buyProducts(fortune,"milo",7,store);

        CashierServices cashierService = new CashierServices();

        cashierService.sellToQueue(allCustomers);
        int allCustomersAfter = allCustomers.size();
        assertNotEquals(allCustomersBefore, allCustomersAfter);
    }

    @Test
    void dispenseReceipts() {
        Customer fortune = new Customer(1, "Fortune",'m',"0900000",300000.0);

        CashierServices cashierService = new CashierServices();

        String actual = cashierService.dispenseReceipts(fortune);
        String expected = "Payment successful!";
        assertEquals(actual, expected);
    }
}