package br.com.knup.curso.service.impl;

import br.com.knup.curso.exceptions.DivisionByZeroException;
import br.com.knup.curso.exceptions.UnsupportedMathOperationException;
import br.com.knup.curso.service.MathService;
import br.com.knup.curso.validation.Validation;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

    private final Validation validation;

    public MathServiceImpl(Validation validation) {
        this.validation = validation;
    }

    @Override
    public Double sum(String a, String b) {
        if(!validation.isNumeric(a) || !validation.isNumeric(b)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    @Override
    public Double sub(Double a, Double b) {
        return a-b;
    }

    @Override
    public Double mult(Double a, Double b) {
        return a*b;
    }

    @Override
    public Double div(Double a, Double b) {
        if (validation.divisionByZero(b)){
            throw new DivisionByZeroException("Division by zero");
        }

        return a/b;
    }

    @Override
    public Double median(Double a, Double b) {
        return (a+b)/2;
    }

    @Override
    public Double sqrt(Double a) {
        if(!validation.greaterThanZero(a)){
            throw new UnsupportedMathOperationException("Please set a value greater than zero");
        }
        return Math.sqrt(a);
    }
}