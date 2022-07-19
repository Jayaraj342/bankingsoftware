package com.complex.app.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    String author() default "Messi";

    String date();

    int revision() default 1;

    String comments();
}