package ru.itis.moviehub.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class ServiceLoggerAspect {
    @Before(value = "execution(* ru.itis.moviehub.services.*.*(*))")
    public void before(JoinPoint joinPoint) {
        System.out.println("\n");
        System.out.println("Method is called");
        Date date = new Date();
        System.out.println("Time: " + date);
        System.out.println("Signature: " + joinPoint.getSignature());
        System.out.print("Arguments: ");
        for (Object arg : joinPoint.getArgs()) {
            System.out.print(arg + "\t");
        }
        System.out.println("\n");
    }
}

