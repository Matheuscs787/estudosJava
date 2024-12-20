package br.com.knup.curso.controller;

import br.com.knup.curso.service.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/sum/{a}/{b}")
    public Double sum(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b) throws Exception{
        return mathService.sum(a, b);
    }

    @GetMapping("/div/{a}/{b}")
    public Double div(@PathVariable(value = "a") Double a, @PathVariable(value = "b") Double b) throws Exception{
        return mathService.div(a, b);
    }

    @GetMapping("/mult/{a}/{b}")
    public Double mult(@PathVariable(value = "a") Double a, @PathVariable(value = "b") Double b) throws Exception{
        return mathService.mult(a, b);
    }

    @GetMapping("/median/{a}/{b}")
    public Double median(@PathVariable(value = "a") Double a, @PathVariable(value = "b") Double b) throws Exception{
        return mathService.median(a, b);
    }

    @GetMapping("/sub/{a}/{b}")
    public Double sub(@PathVariable(value = "a") Double a, @PathVariable(value = "b") Double b) throws Exception{
        return mathService.sub(a, b);
    }

    @GetMapping("/sqrt/{a}")
    public Double sqrt(@PathVariable(value = "a") Double a) throws Exception{
        return mathService.sqrt(a);
    }

}
