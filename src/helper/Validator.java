package helper;

import model.Customer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    //Get all valid and invalid customers in Map
    public static Map<String, List<Customer>> getValidInvalidCustomers(List<Customer> customerList) {

        List<Customer> validCustomers = new ArrayList<>(), invalidCustomers = new ArrayList<>();

        if (customerList.isEmpty()){
            System.out.println("No Customer Found...!");
            return null;
        }

        System.out.println("Customer Validation Started...!");

        Map<String, List<Customer>> customerMap = new HashMap<>();

        //Email and Phone no Validation Started
        for (Customer customer : customerList) {
            if (!validateEmail(customer.getEmail()) || !validatePhoneNo(customer.getPhoneNo())) {
                invalidCustomers.add(customer);
            } else {
                validCustomers.add(customer);
            }
        }

        customerMap.put("INVALID_CUSTOMERS", filterDuplicates(invalidCustomers));
        customerMap.put("VALID_CUSTOMERS", filterDuplicates(validCustomers));

        if (!customerMap.isEmpty())
            System.out.println("Email and Phone number Validation complete. Duplicate customers removed successfully");
        else
            System.out.println("No valid or invalid customer found.");

        return customerMap;
    }

    //Remove Duplicates found by Email and Phone No.
    private static List<Customer> filterDuplicates(List<Customer> customerList){
        Set<Customer> filteredCustomers = customerList.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Customer::getEmail))));
        Set<Customer> finalCustomerList = filteredCustomers.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Customer::getPhoneNo))));

        return new ArrayList<>(finalCustomerList);
    }


    //Check if Customer Email is valid or not
    private static boolean validateEmail(String email) {
        String emailFormat = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(emailFormat);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    //Check if Customer Phone no. is valid or not
    private static boolean validatePhoneNo(String phoneNo) {
        String phoneNoFormat = "^\\d{10}$" + "|^\\d{3}[-\\s]\\d{3}[-s]\\d{4}$" + "|^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";

        Pattern pattern = Pattern.compile(phoneNoFormat);
        Matcher matcher = pattern.matcher(phoneNo);

        return matcher.matches();
    }
}
