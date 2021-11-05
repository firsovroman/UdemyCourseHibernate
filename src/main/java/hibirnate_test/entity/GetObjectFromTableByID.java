package hibirnate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetObjectFromTableByID {
    public static void main(String[] args) {
        Session session;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // откуда берем конфиг показывающий как создавать сессии
                .addAnnotatedClass(Employee.class) // класс с которым будем работать
                .buildSessionFactory();

        try {


            session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova", "Sales", 850);
            session.beginTransaction(); // открываем транзакцию

            session.save(emp);
            session.getTransaction().commit();

            int myId = emp.getId();
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, myId);
            session.getTransaction().commit();

            System.out.println(employee);
        } finally {
            factory.close();
        }

    }
}
