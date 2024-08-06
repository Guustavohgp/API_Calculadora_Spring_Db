package com.example.calculadora.service;

import com.example.calculadora.model.Historico;
import com.example.calculadora.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public double calcular(double x, double y, String operacao) {
        double resultado;
        switch (operacao) {
            case "+":
                resultado = x + y;
                break;
            case "-":
                resultado = x - y;
                break;
            case "*":
                resultado = x * y;
                break;
            case "/":
                if (y == 0) throw new IllegalArgumentException("Divisão por zero não permitida");
                resultado = x / y;
                break;
            case "^":
                resultado = Math.pow(x, y);
                break;
            default:
                throw new IllegalArgumentException("Operação inválida");
        }
        salvarHistorico(x, y, operacao, resultado);
        return resultado;
    }

    private void salvarHistorico(double x, double y, String operacao, double resultado) {
        Historico historico = new Historico();
        historico.setX(x);
        historico.setY(y);
        historico.setOperacao(operacao);
        historico.setResultado(resultado);
        historicoRepository.save(historico);
    }
}
