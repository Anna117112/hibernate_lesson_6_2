package hibernte_dz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactoryUtil sessionFactoryUtil = applicationContext.getBean("sessionFactoryUtil", SessionFactoryUtil.class);

        //SessionFactoryUtil sessionFactoryUtil = new SessionFactoryUtil();
        sessionFactoryUtil.init();
        try {
            ProductDao productDaoImp = applicationContext.getBean("productDaoImp", ProductDao.class);
           // ProductDao productDao = new ProductDaoImp(sessionFactoryUtil);
           // productDao.findAllProductByIdCustomer(1);
           // productDao.findAllCustomerByIdProduct(4);
            productDaoImp.findAll(1);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sessionFactoryUtil.shutdown();
        }
    }
}
