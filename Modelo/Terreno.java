package Modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    // Atributo específico para Terreno
    private String tipoZona;

    // Construtor
    public Terreno(double valorImovel, int prazoFinanc, double txJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanc, txJurosAnual);
        this.tipoZona = tipoZona;
    }

    // Implementação do método abstrato pagMensal para Terreno
    @Override
    public double pagMensal() {
        return (getValorImovel() * (getTxJurosAnual() / 100 / 12)) / (1 - Math.pow(1 + (getTxJurosAnual() / 100 / 12), -getPrazoFinanc())) * 1.02; // 2% adicional para Terreno
    }

    // Getter para o novo atributo
    public String getTipoZona() {
        return tipoZona;
    }
}
