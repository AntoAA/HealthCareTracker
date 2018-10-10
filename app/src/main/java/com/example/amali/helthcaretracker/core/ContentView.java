package com.example.amali.helthcaretracker.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by antonia_achim on 9/12/2018.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ContentView {

    int value() default 0;

    String resName() default "";
}
