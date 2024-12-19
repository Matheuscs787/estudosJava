package br.com.knup.curso.controller;

import br.com.knup.curso.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{a}/{b}")
    public Double sum(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b) throws Exception{

        if(!isNumeric(a) || !isNumeric(b)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    private boolean isNumeric(String str) {
        if(str == null || str.isEmpty()){
            return false;
        }
        String number = str.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
