package thread;

import controller.CustomerProcessController;
import helper.FileManager;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class CustomerProcessThread implements Runnable {

    private String threadName;
    private List<Customer> customerList;
    private boolean validInvalidFlag;
    private CustomerProcessController controller;
    private static final Object lock = new Object();

    public CustomerProcessThread(String threadName, List<Customer> customerList, CustomerProcessController controller, boolean validInvalidFlag) {
        this.threadName = threadName;
        this.customerList = customerList;
        this.validInvalidFlag = validInvalidFlag;
        this.controller = controller;
    }

    public void run() {
        synchronized (lock) {

            try {
                //Write customers in file
                FileManager.writeCustomersInFile(threadName, customerList);

                //Insert Customers in Database
                controller.insertCustomers(customerList, validInvalidFlag);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
