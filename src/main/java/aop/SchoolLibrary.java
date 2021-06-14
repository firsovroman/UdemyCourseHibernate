package aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibary{


    public void getBook() {
        System.out.println("Мы берем кнгиу из SchoolLibrary");
    }
}
