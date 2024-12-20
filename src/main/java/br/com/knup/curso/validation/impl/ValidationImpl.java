package br.com.knup.curso.validation.impl;

import br.com.knup.curso.validation.Validation;
import org.springframework.stereotype.Service;

@Service
public class ValidationImpl implements Validation {

    @Override
    public boolean isNumeric(String str) {
        if(str == null || str.isEmpty()){
            return false;
        }
        String number = str.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @Override
    public boolean divisionByZero(Double value) {
        return value.equals(0.0);
    }

    @Override
    public boolean greaterThanZero(Double value) {
        return value >= 0.0;
    }
}
