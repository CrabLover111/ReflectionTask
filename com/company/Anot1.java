package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Anot1 {
    public int a() default 0;
    public int b() default 0;




}
