package hibernte_dz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component("customer")
@Scope("prototype")
// связь нашей сущьности с обектом в таблице
    @Entity
// указываем имя соответствующей таблици в бд
    @Table(name = "customers")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;




    @ManyToMany
    @JoinTable(
            // имя сводной таблицы с внешгими ключами на нащи таблицы customers и products
            name = "customers_products", // название таблицы
            // имя столбца внешнкго ключа которвый указывает на нас
            joinColumns = @JoinColumn(name = "customers_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id") // то на с чем связываем
    )
    private List<Product> products;




    @OneToMany(mappedBy = "customers")
        private List<Order> orders;





    public List<Order> getOrders() {
        return orders;
    }
    @Autowired
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }
    @Autowired
    public void setProducts(List<Product> products) {
        this.products = products;
    }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        // обязательно должен быть пустой конструктор
        public Customer() {
        }



        @Override
        public String toString() {
            return "Customer [ id " + id + " name " + name + "]";
        }

    }


