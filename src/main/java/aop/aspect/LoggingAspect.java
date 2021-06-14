package aop.aspect;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){
//
//    }

    @Before("aop.aspect.MyPointCuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature : " + methodSignature);
        System.out.println("methodSignature.getMethod() : " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() : " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() : " + methodSignature.getName());

        System.out.println("beforeAddLoggingAdvice(): логирование " + "попытки получить книгу/журнал");
        System.out.println("------------------------------------");

        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs(); // получаем аргументы массивом
            for(Object obj : arguments){
                if(obj instanceof Book){
                    Book mybook = (Book) obj;
                    System.out.println("Информация о книге: название - " + mybook.getName() +
                            ", автор - " + mybook.getAuthor() + ", год публикации - "+  mybook.getYearOfPublication() );
                    System.out.println("------------------------------------");
                } else if(obj instanceof String) {
                    System.out.println("книгу в библиотеку добавляет - " + obj);
                    System.out.println("------------------------------------");
                }
            }
        }
   }
// 123
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice(): проверка прав на получение " + "книги/журнала");
//    }



//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//        public void beforeAllWithoutReturnLoggingAdvice() {
//        System.out.println("beforeAllWithoutReturnLoggingAdvice(): writing Log #7");
//    }




//    @Pointcut("execution(* aop.UniLibrary.* (..))")
//    private void allMethodsFromUniLibrary() {
//
//    }
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {
//
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {
//
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//        public void beforeAllWithoutReturnLoggingAdvice() {
//        System.out.println("beforeAllWithoutReturnLoggingAdvice(): writing Log #7");
//    }


//@Pointcut("execution(* aop.UniLibrary.get*()))")
//    private void allGetMethodsFromUniLibrary() {
//}
//
//@Pointcut("execution(* aop.UniLibrary.return*()))")
//private void allReturnMethodsFromUniLibrary() {
//}
//
//@Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//private void allGetAndReturnMethodsFromUniLibrary() {
//
//}
//
//@Before("allGetAndReturnMethodsFromUniLibrary()")
//public void beforeGetAndReturnLoggingAdvice() {
//    System.out.println("beforeGetAndReturnLoggingAdvice(): writing Log #3");
//}
//
//
//@Before("allGetMethodsFromUniLibrary()")
//public void beforeGetLoggingAdvice() {
//    System.out.println("beforeGetLoggingAdvice(): writing Log #1");
//}
//
//@Before("allReturnMethodsFromUniLibrary()")
//public void beforeReturnLoggingAdvice() {
//    System.out.println("beforeReturnLoggingAdvice(): writing Log #2");
//}



}
