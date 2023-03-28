package controller;

import model.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerProcessController implements ICustomerProcessController {

    private CustomerService customerService = new CustomerService();

    @Override
    public boolean insertCustomers(List<Customer> customerList, boolean flag) {
        return customerService.insertIntoDatabase(customerList, flag ? "VALID_CUSTOMERS" : "INVALID_CUSTOMERS");
    }
}
