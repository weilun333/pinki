package com.cw.pinki.common.security;

import com.cw.pinki.common.annotation.PasswordValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValueMatchValidator implements ConstraintValidator<PasswordValueMatch, Object> {
    private String field;
    private String fieldMatch;
    private String message;

    @Override
    public void initialize(PasswordValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch= constraintAnnotation.fieldMatch();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(o).getPropertyValue(fieldMatch);
        boolean isValid = false;
        if(fieldValue != null){
            isValid = fieldValue.equals(fieldMatchValue);
        }
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(fieldMatch).addConstraintViolation();
        }
        return isValid;
    }
}
