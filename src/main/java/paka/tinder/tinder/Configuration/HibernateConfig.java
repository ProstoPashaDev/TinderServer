//package paka.tinder.tinder.Configuration;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    // Create and configure the SessionFactory from hibernate.cfg.xml
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
//
//        // Register your entity classes here
//        sessionFactoryBean.setAnnotatedClasses(
//                paka.tinder.tinder.User.class // Add any other entities as needed
//        );
//
//        return sessionFactoryBean;
//    }
//
//    // Define the transaction manager to integrate Spring's transaction management with Hibernate
//    @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }
//}
