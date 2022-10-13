package hibernte_dz;

import java.util.List;

public interface ProductDao {


    List<Order> findAll(int customerId);
    List<Product> findAllProductByIdCustomer(int id);
    List<Customer> findAllCustomerByIdProduct(int id);




}
