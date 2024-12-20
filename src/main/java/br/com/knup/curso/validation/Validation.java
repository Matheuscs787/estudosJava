package br.com.knup.curso.validation;

public interface Validation {
    boolean isNumeric(String str);
    boolean divisionByZero(Double value);
    boolean greaterThanZero(Double value);
}
