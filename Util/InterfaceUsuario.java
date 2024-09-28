package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Método genérico para entrada de dados numéricos com validação
    private double inputDouble(String mensagem, String erro, double minValor) {
        double valor = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();

                if (valor < minValor) {
                    System.out.println(erro);
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor numérico válido.");
                scanner.next(); // Limpeza do buffer do scanner
            }
        } while (!entradaValida);

        return valor;
    }

    // Métodos específicos chamando o método genérico

    public double inValor() {
        return inputDouble("Digite o valor do imóvel: ", "Valor do imóvel deve ser positivo.", 0);
    }

    public int inPrazo() {
        return (int) inputDouble("Digite o prazo em meses: ", "Prazo deve ser maior que zero.", 1);
    }

    public double inTaxa() {
        return inputDouble("Digite a taxa de juros anual: ", "Taxa de juros deve ser positiva.", 0);
    }

    public double inTamanhoAreaConstruida() {
        return inputDouble("Digite o tamanho da área construída (m²): ", "Tamanho deve ser maior que zero.", 0);
    }

    public double inTamanhoTerreno() {
        return inputDouble("Digite o tamanho do terreno (m²): ", "Tamanho do terreno deve ser maior que zero.", 0);
    }
}
