package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();

        try {
            List<Student> students = university.getStudents(); // выполнился метод getStudents затем сразу выполнился advice AfterReturning
            // и еще неуспело выполнится присвоение переменной students , как в методе AfterReturning advice мы поменяли первый элемент списка
            // после завершения advice и присвоения первому элементу новых значений, переменной присвоился обновленный список который затем выводится
        }catch(Exception e){
            System.out.println("было поймано исключение");
        }
//        System.out.println(students);

        context.close();
    }
}
