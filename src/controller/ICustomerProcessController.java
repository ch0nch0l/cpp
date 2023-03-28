package controller;

import model.Customer;

import java.util.List;

public interface ICustomerProcessController {

    boolean insertCustomers(List<Customer> customerList, boolean flag);
}
