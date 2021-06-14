package hibirnate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        Session session;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // откуда берем конфиг показывающий как создавать сессии
                .addAnnotatedClass(Employee.class) // класс с которым будем работать
                .buildSessionFactory();

        try {

            session = factory.getCurrentSession();
            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
            session.beginTransaction(); // открываем транзакцию

            session.save(emp);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}