package aop.aspect;


import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice " +
//                "список студентов перед методом getStudents");
//        System.out.println("--------------------------------------");
//    }

    @AfterReturning(pointcut = "execution(* getStudents())",
            returning = "students1")
    // returning = "stud" обязательный параметр для того чтобы производить операции с листом
    public void afterGetStudentsLoggingAdvice(List<Student> students1) { //

//        Student firstStudent = students1.get(0);
//
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//
//        firstStudent.setNameSurname(nameSurname);
//
//        double avgGradde = firstStudent.getAvgGrade();
//        avgGradde = avgGradde+1;
//        firstStudent.setAvgGrade(avgGradde);
//
//
//        System.out.println("afterGetStudentsLoggingAdvice " +
//                "список студентов после работы метода getStudents");
//        System.out.println("--------------------------------------");
    }
        @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
            public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
                System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения "+ exception);

        }


    }

