package interfaces;

import classes.CustomerClass;

public interface Customer {

    CustomerClass insertCustomer(CustomerClass customer);

    CustomerClass getCustomer(CustomerClass customer);

    CustomerClass updateCustomer(CustomerClass customer);

    boolean deleteCustomer(CustomerClass customer);
}