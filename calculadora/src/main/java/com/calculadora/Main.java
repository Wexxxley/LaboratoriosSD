package com.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que a classe é um Controller e os métodos retornam dados diretamente
@SpringBootApplication // Configuração principal e ponto de entrada da aplicação Spring Boot
public class Main {

    // Endpoint para somar, recebendo 'a' e 'b' do caminho (PathVariable)
    @GetMapping("/somar/{a}/{b}")
    public String somar(@PathVariable double a, @PathVariable double b) {
        return "Resultado: " + (a + b);
    }

    // Endpoint para subtrair
    @GetMapping("/subtrair/{a}/{b}")
    public String subtrair(@PathVariable double a, @PathVariable double b) {
        return "Resultado: " + (a - b);
    }

    // Endpoint para multiplicar
    @GetMapping("/multiplicar/{a}/{b}")
    public String multiplicar(@PathVariable double a, @PathVariable double b) {
        return "Resultado: " + (a * b);
    }

    // Endpoint para dividir com tratamento de divisão por zero
    @GetMapping("/dividir/{a}/{b}")
    public String dividir(@PathVariable double a, @PathVariable double b) {
        if (b == 0) {
            return "Erro: Divisão por zero!";
        }
        return "Resultado: " + (a / b);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}