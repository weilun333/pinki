package com.cw.pinki.common.security;

import com.cw.pinki.common.annotation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.passay.*;

import java.util.Arrays;
import java.util.StringJoiner;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @SneakyThrows
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        /*
            1. 密碼長度8~20
            2. 至少1個英文字母
            3. 至少1個數字
            4. 不可以與帳號相同
            5. 不可有空白字元
         */
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 20),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new UsernameRule(),
                new WhitespaceRule()
        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if(result.isValid()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        StringJoiner joiner = new StringJoiner(",");
        for(String mes : validator.getMessages(result)){
            joiner.add(mes);
        }
        context.buildConstraintViolationWithTemplate(joiner.toString()).addConstraintViolation();
        return false;
    }
}
