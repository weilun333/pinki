package com.cw.pinki.common.annotation;

import com.cw.pinki.common.security.PasswordConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "密碼格式錯誤，密碼須為8-20的英文及數字組合";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
