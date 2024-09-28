package Modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    // Atributos específicos para Casa
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    // Construtor
    public Casa(double valorImovel, int prazoFinanc, double txJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanc, txJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    // Implementação do método abstrato pagMensal para Casa
    @Override
    public double pagMensal() {
        return (getValorImovel() * (getTxJurosAnual() / 100 / 12)) / (1 - Math.pow(1 + (getTxJurosAnual() / 100 / 12), -getPrazoFinanc()));
    }

    // Getters para os novos atributos
    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }
}
