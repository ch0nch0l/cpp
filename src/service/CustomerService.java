package service;

import helper.DBHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

public class CustomerService implements ICustomerService {

    //DB helper to prepare connection
    private DBHelper dbHelper = new DBHelper();

    /* Insert into database as batch
    * Table name comes as a parameter to choose target table
    * */
    @Override
    public boolean insertIntoDatabase(List customerList, String tableName) {

        boolean result = false;
        Connection connection = dbHelper.connect();

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                String query = "INSERT INTO " + tableName + "(first_name, last_name, city, state, postal_code, phone_no, email, ip_address) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);

                Iterator<Customer> iterator = customerList.iterator();
                while (iterator.hasNext()) {
                    Customer customer = iterator.next();

                    statement.setString(1, customer.getFirstName());
                    statement.setString(2, customer.getLastName());
                    statement.setString(3, customer.getCity());
                    statement.setString(4, customer.getState());
                    statement.setString(5, customer.getPostalCode());
                    statement.setString(6, customer.getPhoneNo());
                    statement.setString(7, customer.getEmail());
                    statement.setString(8, customer.getIpAddress());

                    statement.addBatch();
                }

                int[] numUpdates = statement.executeBatch();
                for (int i = 0; i < numUpdates.length; i++) {
                    if (numUpdates[i] == -2)
                        System.out.println("Execution " + i + " : unknown number of rows updated");
                    else {
                        System.out.println("Data Insertion for " + i + " is successful: " + numUpdates[i] + " rows updated");
                        result = true;
                    }
                }

                connection.commit();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
