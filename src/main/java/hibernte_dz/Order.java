package hibernte_dz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component("order")
@Scope("prototype")
// связь нашей сущьности с обектом в таблице
@Entity
// хотим хранить сущьность в таблице products
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private int data;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }



    public Product getProducts() {
        return products;
    }
    @Autowired
    public void setProducts(Product products) {
        this.products = products;
    }



    public Customer getCustomers() {
        return customers;
    }
    @Autowired
    public void setCustomers(Customer customers) {
        this.customers = customers;
    }


    // обязательно должен быть пустой конструктор
    public Order() {
    }





    @Override
    public String toString() {
        return "Order [имя покупателя " + customers.getName() + " product " + products +  "дата покупки " + data +"]";
    }

}


