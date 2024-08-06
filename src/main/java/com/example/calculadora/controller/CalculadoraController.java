package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/api/calculadora/calcular")
    public double calcular(
            @RequestParam double x,
            @RequestParam double y,
            @RequestParam String operacao) throws UnsupportedEncodingException {

        // Decodifica a operação da URL
        String decodedOperacao = URLDecoder.decode(operacao, StandardCharsets.UTF_8.toString());

        // Verifica e substitui o símbolo de exponenciação se necessário
        if (decodedOperacao.equals(" ")) {
            decodedOperacao = "+";
        }

        // Passa a operação decodificada para o serviço
        return calculadoraService.calcular(x, y, decodedOperacao);
    }

    @GetMapping("/error")
    public String handleError() {
        return "Ocorreu um erro. Verifique os detalhes da solicitação.";
    }
}
