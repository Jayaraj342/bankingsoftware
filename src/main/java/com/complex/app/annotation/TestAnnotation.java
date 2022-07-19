package com.complex.app.annotation;

public class TestAnnotation {
    @MyCustomAnnotation(date = "1", comments = "1")
    public static void myMethod1() {
        // empty method
    }

    @MyCustomAnnotation(date = "2", comments = "2")
    public static void myMethod2() {
        // empty method
    }
}
