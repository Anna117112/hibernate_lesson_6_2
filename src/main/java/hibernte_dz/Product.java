package hibernte_dz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
@Component("product")
@Scope("prototype")
// связь нашей сущьности с обектом в таблице
@Entity
// хотим хранить сущьность в таблице products
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;


    public List<Customer> getCustomers() {
        return customers;
    }
    @Autowired
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @ManyToMany
    @JoinTable(
            // имя сводной таблицы с внешгими ключами на нащи таблицы customers и products
            name = "customers_products", // название таблицы
            // имя столбца внешнкго ключа которвый указывает на нас
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id") // то на с чем связываем
    )
    private List<Customer> customers;


    @OneToMany(mappedBy = "products")
    private List<Order> orders;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


// обязательно должен быть пустой конструктор
    public Product() {
    }

    public Product(int id, String title, int price){
        this.id = id;
        this.title = title;
        this.price = price;
    }



    @Override
    public String toString() {
        return "Product [ id - " + id + " title  " + title + " price  " + price + "]";
    }

}
