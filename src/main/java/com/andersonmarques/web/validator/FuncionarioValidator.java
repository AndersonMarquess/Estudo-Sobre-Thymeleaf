package com.andersonmarques.web.validator;

import com.andersonmarques.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        //Se true ele vai para o validate
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Funcionario funcionario = (Funcionario) target;

        LocalDate entrada = funcionario.getDataEntrada();

        if (funcionario.getDataSaida() != null) {

            if (funcionario.getDataSaida().isBefore(entrada)) {
                //Erro code dentro do properties
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }
    }
}
