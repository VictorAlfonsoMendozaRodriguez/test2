package com.victor.entities.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = TotalScoreConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TotalScoreConstrait {
    String message() default "the List cannot add more than 100 points.";
    int customField() default 100;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}