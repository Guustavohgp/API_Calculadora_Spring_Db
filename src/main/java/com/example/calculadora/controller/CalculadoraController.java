package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/calcular")
    public double calcular(@RequestParam double x, @RequestParam double y, @RequestParam String operacao) {
        return calculadoraService.calcular(x, y, operacao);
    }
}
