package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Book book = context.getBean("book", Book.class);

        UniLibrary ulib = context.getBean("uniLibrary", UniLibrary.class);
        ulib.addBook("Roman", book);
        ulib.addMagazine();


//        ulib.returnBook();


//        SchoolLibrary schlib = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schlib.getBook();

        context.close();
    }
}
