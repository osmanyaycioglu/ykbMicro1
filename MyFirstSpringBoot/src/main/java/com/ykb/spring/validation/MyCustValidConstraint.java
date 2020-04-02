package com.ykb.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustValidConstraint implements ConstraintValidator<MyCustValid, String> {

    private MyCustValid constraintAnnotation;

    @Override
    public void initialize(final MyCustValid constraintAnnotationParam) {
        this.constraintAnnotation = constraintAnnotationParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        int length = this.constraintAnnotation.value1();
        if (valueParam.length() > length) {
            return false;
        }
        return true;
    }

}
