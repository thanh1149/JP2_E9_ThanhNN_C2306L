package Service;

import Entity.Customer;
import Generic.IShopManagement;

import java.util.List;

public class CustomerService implements IShopManagement<Customer> {
    public static List<Customer> customerList;
    public CustomerService(){}



    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
