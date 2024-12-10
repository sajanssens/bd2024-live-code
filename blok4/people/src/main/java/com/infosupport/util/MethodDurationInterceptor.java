package com.infosupport.util;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.NANOS;

// Must also be declared in beans.xml!
@MeasureMethodDuration
@Interceptor // AOP = Aspect Oriented Programming
@Priority(Interceptor.Priority.APPLICATION)
public class MethodDurationInterceptor {

    @AroundInvoke
    public Object measureDuration(InvocationContext targetMethod) throws Exception {
        var startTime = LocalDateTime.now();
        try {
            return targetMethod.proceed(); // like chain.next
        } finally {
            var endTime = LocalDateTime.now();
            long duration = NANOS.between(startTime, endTime);
            System.out.println(targetMethod.getClass().getSimpleName() + " " + targetMethod.getMethod().getName() + " method duration was " + duration);
        }
    }
}
