package hibirnate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteObjectsInTable {
    public static void main(String[] args) {
        Session session;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // откуда берем конфиг показывающий как создавать сессии
                .addAnnotatedClass(Employee.class) // класс с которым будем работать
                .buildSessionFactory();

        try {


            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = (Employee) session.get(Employee.class, 5);
//            session.delete(employee);

            session.createQuery("delete Employee where name ='Ivan'").executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
