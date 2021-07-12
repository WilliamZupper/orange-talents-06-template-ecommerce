package br.com.ot6.william.mercadolivre.validacao;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
        String message() default "Restricao valor unico";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
        String campo();
        Class Classe();
}