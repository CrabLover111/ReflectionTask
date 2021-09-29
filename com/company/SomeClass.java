package com.company;

import java.lang.reflect.Method;
import java.text.Annotation;

public class SomeClass {
    @Anot1(a = 12, b = 11)
    public int sum(int a, int b) {
        int c = a + b;
        return c;

    }

    public void magic() {
        try {
            Method sum = SomeClass.class.getMethod("sum", int.class, int.class);
            Anot1 annotation = (Anot1) sum.getAnnotation(Anot1.class);
            int a1 = annotation.a();
            int a2 = annotation.b();
            sum(a1, a2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
