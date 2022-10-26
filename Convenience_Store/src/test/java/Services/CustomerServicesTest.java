package Services;

import enums.Grade;
import enums.Role;
import interfaces.CashierInterface;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesTest {

    @Test
    void buyProducts() {
        Staff staff1 = new Staff(123, "john", 'M', "14262w32724", Role.MANAGER);
        staff1.setName("Alex");
   //     System.out.println(staff1);
        Applicant applicant1 = new Applicant(1, "Faith", 'M', "Decagon", "Cashier", Grade.SECOND_CLASS_LOWER);
    //    System.out.println(applicant1.getGrade());
        Manager manager1 = new Manager();
        ApplicantServices applicantServ = new ApplicantServices();

        String filePath = "/Users/decagon/Desktop/week-two-sq012-fortz007/Convenience_Store/src/main/resources/FaithStore_ Inventory - Sheet1.csv";
       FaithStore store = new FaithStore();
        Cashier cashier = new Cashier();

        CashierInterface cashierServ = new CashierServices();
        cashierServ.productCatalogue(store, filePath);
  //      System.out.println(store.getProductList());

        Customer faith = new Customer(2, "Faith",'f',"0900000",100000.0);

       int cartSizeBeforeBuying = faith.getCart().size();

        CustomerServices customerServ2 = new CustomerServices();
        customerServ2.buyProducts(faith,"short bread",8,store);
        customerServ2.buyProducts(faith,"short bread",8,store);

        int cartSizeAfterBuying = faith.getCart().size();

        assertNotEquals(cartSizeBeforeBuying, cartSizeAfterBuying);
    }
}