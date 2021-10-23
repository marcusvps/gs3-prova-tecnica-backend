package br.com.gs3.avaliacaotecnica.annotation;

import br.com.gs3.avaliacaotecnica.validator.TelefoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {
    String locale() default "";
    String message() default "A quantidade de caracteres do telefone é invalida.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
