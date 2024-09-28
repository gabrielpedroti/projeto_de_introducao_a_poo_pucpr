package Modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    // Atributos específicos para Apartamento
    private int numVagasGaragem;
    private int numAndar;

    // Construtor
    public Apartamento(double valorImovel, int prazoFinanc, double txJurosAnual, int numVagasGaragem, int numAndar) {
        super(valorImovel, prazoFinanc, txJurosAnual);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    // Implementação do método abstrato pagMensal para Apartamento
    @Override
    public double pagMensal() {
        return (getValorImovel() * (getTxJurosAnual() / 100 / 12)) / (1 - Math.pow(1 + (getTxJurosAnual() / 100 / 12), -getPrazoFinanc()));
    }

    // Getters para os novos atributos
    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }

    public int getNumAndar() {
        return numAndar;
    }
}
