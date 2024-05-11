package br.com.conversor.recordacao;

import java.util.Map;

public record ValorMoeda(Map<String, Double> conversion_rates) {

    @Override
    public String toString() {
        return "ValorMoeda{" +
                "conversion_rates=" + conversion_rates +
                '}';
    }
}
