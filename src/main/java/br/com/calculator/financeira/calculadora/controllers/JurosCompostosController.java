package br.com.calculator.financeira.calculadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calcJurosCompostos")
public class JurosCompostosController {

    @GetMapping("/montante")
    @ResponseBody
    public ResponseEntity<Double> montante(@RequestParam Double c,
                                               @RequestParam Double i,
                                               @RequestParam Integer n){
        Double m = c * Math.pow(1+i,n);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
    @GetMapping("/capital")
    @ResponseBody
    public ResponseEntity<Double> capital(@RequestParam Double m,
                                          @RequestParam Double i,
                                          @RequestParam Integer n){
        Double c = m / Math.pow((1+i),n);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @GetMapping("/periodo")
    @ResponseBody
    public ResponseEntity<Double> tempo(@RequestParam Double m,
                                          @RequestParam Double i,
                                          @RequestParam Double c){
        Double n = (Math.log(m/c))/(Math.log(1+i));
        return new ResponseEntity<>(n, HttpStatus.OK);
    }
    @GetMapping("/taxa")
    @ResponseBody
    public ResponseEntity<Double> taxa(@RequestParam Double m,
                                        @RequestParam Integer n,
                                        @RequestParam Double c){
        Double i = 0.0;
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
}
