package com.trybe.acc.java.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Calculadora {

  /**
   * Métodos.
   **/

  @GetMapping("/")
  public ResponseEntity<ResultadoCalculo> calcular(
      @RequestParam("primeiroValor") Integer primeiroValor,
      @RequestParam("segundoValor") Integer segundoValor,
      @RequestParam("operacao") String operacao) {

    if (operacao.equalsIgnoreCase("ADICAO")) {
      int resultado = primeiroValor + segundoValor;
      return ResponseEntity.ok(new ResultadoCalculo(resultado));
    } else if (operacao.equalsIgnoreCase("SUBTRACAO")) {
      int resultado = primeiroValor - segundoValor;
      return ResponseEntity.ok(new ResultadoCalculo(resultado));
    } else if (operacao.equalsIgnoreCase("MULTIPLICACAO")) {
      int resultado = primeiroValor * segundoValor;
      return ResponseEntity.ok(new ResultadoCalculo(resultado));
    } else if (operacao.equalsIgnoreCase("DIVISAO")) {
      if (segundoValor == 0) {
        return ResponseEntity.ok(new ResultadoCalculo(0));
      } else {
        int resultado = primeiroValor / segundoValor;
        return ResponseEntity.ok(new ResultadoCalculo(resultado));
      }
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }
}
