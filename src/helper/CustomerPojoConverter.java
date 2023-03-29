package helper;

import model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerPojoConverter {

    public static List<Customer> customerInputToPojoList(List<String> fileInputList) {

        Customer customer;
        List<Customer> customerList = new ArrayList<>();
        int position = 1;

        //Convert each Input Customer String to Customer Model
        for (String singleInput : fileInputList) {
            List<String> customerInfo = Arrays.asList(singleInput.split(","));

            try {
                customer = new Customer();
                customer.setFirstName(customerInfo.get(0));
                customer.setLastName(customerInfo.get(1));
                customer.setCity(customerInfo.get(2));
                customer.setState(customerInfo.get(3));
                customer.setPostalCode(customerInfo.get(4));
                customer.setPhoneNo(customerInfo.get(5));
                customer.setEmail(customerInfo.get(6));

                if (customerInfo.size() == 8) {
                    customer.setIpAddress(customerInfo.get(7));
                }

                customerList.add(customer);
                position++;
            } catch (Exception e) {
                System.out.println("Error in String to Customer Model conversion in position: " + position);
                e.printStackTrace();
            }
        }

        if (!customerList.isEmpty())
            System.out.println("String to Pojo Conversion successful for " + customerList.size() + " Customers");

        return customerList;
    }
}
