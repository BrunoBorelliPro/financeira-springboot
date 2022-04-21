package br.com.calculator.financeira.calculadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calcJurosSimples")
public class JurosSimplesController {

    @GetMapping("/juros")
    @ResponseBody
    public ResponseEntity<Double> jurosSimples(@RequestParam Double c,
                                                        @RequestParam Double i,
                                                        @RequestParam Integer n){
        Double j = c * i * n;
        return new ResponseEntity<>(j, HttpStatus.OK);
    }

    @GetMapping("/capital")
    @ResponseBody
    public ResponseEntity<Double> capital(@RequestParam Double j,
                                                          @RequestParam Double i,
                                                          @RequestParam Integer n){
        Double c = j / (i * n);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @GetMapping("/taxa")
    @ResponseBody
    public ResponseEntity<Double> taxa(@RequestParam Double c,
                                                   @RequestParam Double j,
                                                   @RequestParam Double n){
        Double i = j / (c * n);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @GetMapping("/periodo")
    @ResponseBody
    public ResponseEntity<Double> periodo(@RequestParam Double c,
                                                       @RequestParam Double j,
                                                       @RequestParam Double i){
        Double n = j / (c * i);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }
}
