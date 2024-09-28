package Modelo;

import java.io.Serializable;

// Classe Financiamento (agora abstrata)
public abstract class Financiamento implements Serializable {
    // Atributos privados para encapsulamento
    private double valorImovel;
    private int prazoFinanc; // Prazo em meses
    private double txJurosAnual; // Taxa de juros anual em percentual

    // Método Construtor Financiamento
    public Financiamento(double valorImovel, int prazoFinanc, double txJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanc = prazoFinanc;
        this.txJurosAnual = txJurosAnual;
    }

    // Métodos comuns
    public void outDadosFinanc() {
        System.out.println("O valor do imóvel é R$ " + getValorImovel());
        System.out.println("O prazo é de " + getPrazoFinanc() + " meses.");
        System.out.println("A taxa de juros anual é " + getTxJurosAnual() + "%.");
        System.out.println("A parcela será R$ " + pagMensal() + " por mês.");
        System.out.println("O valor pago ao final do financiamento é R$ " + pagTotal() + ".");
    }

    // Método abstrato para cálculo do pagamento mensal
    public abstract double pagMensal();

    // Método para cálculo do valor total do financiamento
    public double pagTotal() {
        return pagMensal() * prazoFinanc;
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanc() {
        return prazoFinanc;
    }

    public double getTxJurosAnual() {
        return txJurosAnual;
    }
}
