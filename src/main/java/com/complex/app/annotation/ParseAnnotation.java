package com.complex.app.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j(topic = "annotation testing")
public class ParseAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        for (Method method : ParseAnnotation.class.getClassLoader().loadClass(("com.complex.app.annotation.TestAnnotation")).getMethods()) {
            // checks if MethodInfo annotation is present for the method
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                try {
                    // iterates all the annotations available in the method
                    for (Annotation annotation : method.getDeclaredAnnotations()) {
                        log.info("Annotation in Method '" + method + "' : " + annotation);
                    }
                    MyCustomAnnotation myCustomAnnotation = method.getAnnotation(MyCustomAnnotation.class);
                    if (myCustomAnnotation.revision() == 1) {
                        log.info("Method with revision no 1 = " + method);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
// Similarly, can use annotation to check for errors on condition during runtime or compile time
