package Services;

import interfaces.CashierInterface;
import model.Customer;
import model.FaithStore;
import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class CashierServices implements CashierInterface {
    @Override
    public void productCatalogue(FaithStore store, String filePath) {
        List<Product> myProductList = store.getProductList();

        BufferedReader bufferedReader;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while((line = bufferedReader.readLine()) != null){
                String[] arrayOfProducts = line.split(",");
                myProductList.add(new Product(arrayOfProducts[0], arrayOfProducts[1],Double.parseDouble(arrayOfProducts[2]),
                        Integer.parseInt(arrayOfProducts[3]), arrayOfProducts[4]));
            }
            bufferedReader.close();
            store.setProductList(myProductList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String sell(Customer customer) {
        double totalPrice = 0d;
        int totalQuantity = 0;
        for (Product product : customer.getCart()) {
            totalPrice += product.getProductPrice();
            totalQuantity += product.getProductQuantity();
        }
        return customer.getName() + ", your total balance is " + "N"+(totalPrice * totalQuantity);
    }

    public void sellToQueue(Collection<Customer> customers) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        int count = FaithStore.allCustomers.size();
        for (int i = 0; i < count; i++) {
            Customer customer = FaithStore.allCustomers.poll();
            executorService.execute(() -> {
                System.out.println(customer.getName() + " is being attended to on thread " + Thread.currentThread().getName());
                sell(customer);
                System.out.println("Done selling");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("Finished!!!");
    }


    @Override
    public String dispenseReceipts(Customer customer) {
        customer.setQuantity(0);
        customer.setCart(null);
        return "Payment successful!";
    }


}
