package br.com.gs3.avaliacaotecnica.validator;


import br.com.gs3.avaliacaotecnica.annotation.Telefone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class TelefoneValidator implements ConstraintValidator<Telefone, Set<br.com.gs3.avaliacaotecnica.dao.entity.Telefone>> {

    @Override
    public void initialize(Telefone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Set<br.com.gs3.avaliacaotecnica.dao.entity.Telefone> telefones, ConstraintValidatorContext constraintValidatorContext) {
        for (br.com.gs3.avaliacaotecnica.dao.entity.Telefone telefone : telefones) {
            String numeroSemMascara = telefone.getNumero().toString().trim().replace("-", "").replace("(", "".replace(")", ""));
            if(numeroSemMascara.length() > telefone.getTipoTelefone().getQtdCaracteres()){
                return false;
            }
        }
        return true;
    }
}
