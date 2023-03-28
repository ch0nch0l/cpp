package service;

import java.util.List;

public interface ICustomerService {

    boolean insertIntoDatabase(List customerList, String tableName);
}
