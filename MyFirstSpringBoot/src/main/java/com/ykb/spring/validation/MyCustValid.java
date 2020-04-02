package com.ykb.spring.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          FIELD,
          METHOD,
          PARAMETER
})
@Constraint(validatedBy = MyCustValidConstraint.class)
public @interface MyCustValid {

    int value1();

    String message() default "MyCusValid Failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
