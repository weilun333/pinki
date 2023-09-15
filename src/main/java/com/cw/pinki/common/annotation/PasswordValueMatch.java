package com.cw.pinki.common.annotation;

import com.cw.pinki.common.security.PasswordValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValueMatchValidator.class)
public @interface PasswordValueMatch {
    String message() default "該密碼與輸入密碼不一致";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    String fieldMatch();

    @Target({TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        PasswordValueMatch[] value();
    }

}
