package aop.aspect;

import aop.MyConfig;
import aop.Student;
import aop.UniLibrary;
import aop.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookname = uniLibrary.returnBook();

        System.out.println("в библиотеку вернули книгу " + bookname);


        context.close();
        System.out.println("method main ends");
    }
}
