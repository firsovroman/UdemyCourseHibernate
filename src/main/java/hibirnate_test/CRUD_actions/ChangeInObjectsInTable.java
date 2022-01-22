package hibirnate_test.CRUD_actions;

import hibirnate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ChangeInObjectsInTable {
    public static void main(String[] args) {
        Session session;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // откуда берем конфиг показывающий как создавать сессии
                .addAnnotatedClass(Employee.class) // класс с которым будем работать
                .buildSessionFactory();

        try {


            session = factory.getCurrentSession();
            session.beginTransaction();


//            Employee employee = (Employee) session.get(Employee.class, 1);
//            employee.setSalary(1500);

            session.createQuery("update Employee set salary = '1000' where name = 'Ivan'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
