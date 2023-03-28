import controller.CustomerProcessController;
import helper.FileManager;
import helper.Validator;
import model.Customer;
import thread.CustomerProcessThread;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        /**counter is the number of customers should be there in each file
         * In the requirement document the counter was mentioned as 100k
         * but after validation the total length becomes less than 100k
         * As a result alternatively the counter is set to 10k here**/
        final int counter = 10000, length;
        final String inputFilePath = "E:\\2023\\cpp\\data\\input\\1M-customers.txt";
        final CustomerProcessController controller = new CustomerProcessController();

        int fromIndex, toIndex;
        List<Customer> allCustomerList, validCustomerList, invalidCustomerList;

        //Read all customers from provided file "1M-customers.txt"
        allCustomerList = FileManager.readCustomersFromFile(inputFilePath);

        //Validate all customers and segregate to Valid/Invalid list
        Map<String, List<Customer>> customerMap = Validator.getValidInvalidCustomers(allCustomerList);
        if (customerMap == null || customerMap.isEmpty()){
            System.out.println("No Valid or Invalid customer found.");
            return;
        }

        validCustomerList = customerMap.get("VALID_CUSTOMERS");
        invalidCustomerList = customerMap.get("INVALID_CUSTOMERS");

        //Get the length of Valid Customer List
        length = validCustomerList.size();

        //Generate multiple thread in case the length is greater than counter.
        if (length > counter) {
            int noOfThreads = (length / counter) + (length % counter > 0 ? 1 : 0);

            CustomerProcessThread[] threads = new CustomerProcessThread[noOfThreads];

            for (int i = 0; i < noOfThreads; i++) {
                fromIndex = i * counter;
                toIndex = ((i + 1) * counter);

                if (i == (noOfThreads - 1))
                    toIndex = fromIndex + length % counter;

                threads[i] = new CustomerProcessThread("Thread_Valid_Cust_" + (i + 1), validCustomerList.subList(fromIndex, toIndex), controller, true);
                new Thread(threads[i]).start();
            }
        } else {
            //Single Thread for Valid customers if the length is less than count
            CustomerProcessThread validThread = new CustomerProcessThread("Thread_Valid_Cust", validCustomerList, controller, true);
            new Thread(validThread).start();
        }

        //Different thread for Invalid customers
        CustomerProcessThread invalidThread = new CustomerProcessThread("Thread_Invalid_Cust", invalidCustomerList, controller, false);
        new Thread(invalidThread).start();

    }
}
