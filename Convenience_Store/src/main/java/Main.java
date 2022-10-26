import Services.ApplicantServices;
import Services.CashierServices;
import Services.CustomerServices;
import enums.Grade;
import enums.Role;
import interfaces.CashierInterface;
import model.*;

import static model.FaithStore.allCustomers;

public class Main {
    public static void main(String[] args) {
        Staff staff1 = new Staff(123, "john", 'M', "14262w32724", Role.MANAGER);
        staff1.setName("Alex");
   //     System.out.println(staff1);
        Applicant applicant1 = new Applicant(1, "Faith", 'M', "Decagon", "Cashier", Grade.SECOND_CLASS_LOWER);
   //     System.out.println(applicant1.getGrade());
        Manager manager1 = new Manager();
//        System.out.println(manager1.hireCashier(applicant1));
        ApplicantServices applicantServ = new ApplicantServices();

        String filePath = "/Users/decagon/Desktop/week-two-sq012-fortz007/Convenience_Store/src/main/resources/FaithStore_ Inventory - Sheet1.csv";
        FaithStore store = new FaithStore();
        Cashier cashier = new Cashier();

        CashierInterface cashierServ = new CashierServices();
        cashierServ.productCatalogue(store, filePath);
        System.out.println(store.getProductList());

        Customer fortune = new Customer(1, "Fortune",'m',"0900000",300000.0);
        Customer faith = new Customer(2, "Faith",'f',"0900000",100000.0);
        Customer osaze = new Customer(3, "osaze",'m',"0900000",100000.0);
        Customer ifeanyi = new Customer(4, "Ifeanyi",'m',"0900000",100000.0);
        CustomerServices customerServ1 = new CustomerServices();
        CustomerServices customerServ2 = new CustomerServices();
        customerServ1.buyProducts(fortune,"milo",7,store);
        customerServ1.buyProducts(osaze,"short bread",8,store);
        customerServ2.buyProducts(ifeanyi,"Harpic",17,store);
        customerServ2.buyProducts(faith,"Dano Milk", 2,store);

        allCustomers.add(fortune);
        allCustomers.add(faith);
        allCustomers.add(osaze);
        allCustomers.add(ifeanyi);

        CashierServices cashierServices = new CashierServices();
      cashierServices.sell(fortune);
      cashierServices.sell(faith);
      cashierServices.sell(osaze);
      cashierServices.sell(ifeanyi);

        //cashierServices.dispenseReceipts();

        cashierServices.sellToQueue(allCustomers);

//        fortune.setWallet(200000.0);
//
//        System.out.println("Customer balance is: " + fortune.getWallet());
//
//        CustomerServices customerServ3 = new CustomerServices();
//        System.out.println(customerServ3.buyProducts(fortune,"Harpic",1200,store));
//        System.out.println(fortune.getWallet());




    }
}

