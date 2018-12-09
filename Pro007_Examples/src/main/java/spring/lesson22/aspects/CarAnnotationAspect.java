package spring.lesson22.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarAnnotationAspect {

    @Pointcut("execution(* spring.lesson22.dao.CarDAOImpl.read(..))")
    private void pointcutRead() {}

    @Pointcut("execution(* spring.lesson22.dao.CarDAOImpl.update(..))")
    private void pointcutUpdate() {}

    @Before("pointcutRead()")
    public void beforeRead() {
        System.out.println("AspectJ (@Before) - Вызов метода read()");
    }

    @After("pointcutRead()")
    public void afterRead() {
        System.out.println("AspectJ (@After) - Завершение метода read()");
    }

    @AfterReturning(value = "pointcutRead()", returning = "car")
    public void afterReturningRead(Object car) {
        System.out.println("AspectJ (@AfterReturning) - Успешное извлечение объекта");
        System.out.println("AspectJ (@AfterReturning) - " + car);
    }

    /* ProceedingJoinPoint - необходим для запуска метода*/
    @Around("pointcutUpdate()")
    private void aroundUpdate(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AspectJ (@Around) - Действия до запуска метода");
        point.proceed();
        System.out.println("AspectJ (@Around) - Действия после запуска метода");
    }

}
