package hibernte_dz;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("productDaoImp")

public class ProductDaoImp implements ProductDao{
    private SessionFactoryUtil sessionFactoryUtil;
@Autowired
    public void setSessionFactoryUtil(SessionFactoryUtil sessionFactoryUtil){
        this.sessionFactoryUtil =sessionFactoryUtil;
    }


    @Override
    public List<Order> findAll(int customerId) {
        try (Session session = sessionFactoryUtil.getSession()) {

            session.beginTransaction();
            Customer customer = session.get(Customer.class,customerId);
            //List<Order> orders = session.createQuery("from Orders").getResultList();
            System.out.println(customer.getOrders());
            session.getTransaction().commit();
            return customer.getOrders();
        }
    }

    @Override
    public List<Product> findAllProductByIdCustomer(int customerId) {
        try (Session session = sessionFactoryUtil.getSession()) {

            session.beginTransaction();
            Customer customer = session.get(Customer.class,customerId);
            System.out.println(customer);
            System.out.println(customer.getProducts());
            session.getTransaction().commit();
            return customer.getProducts();
        }

    }

    @Override
    public List<Customer> findAllCustomerByIdProduct(int productId) {
        try (Session session = sessionFactoryUtil.getSession()) {

            session.beginTransaction();
            Product product = session.get(Product.class,productId);
            System.out.println();
            System.out.println(product.getCustomers());
            session.getTransaction().commit();
            return product.getCustomers();
        }

    }



    }





