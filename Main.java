package Main;

import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Modelo.Financiamento;
import Util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Criar ArrayList para armazenar os financiamentos
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Adicionar financiamento de Casa
        System.out.println("Informe os dados para o Financiamento de Casa");
        financiamentos.add(new Casa(
                interfaceUsuario.inValor(),
                interfaceUsuario.inPrazo(),
                interfaceUsuario.inTaxa(),
                interfaceUsuario.inTamanhoAreaConstruida(),
                interfaceUsuario.inTamanhoTerreno()
        ));

        // Adicionar financiamento de Casa (dados fixos)
        financiamentos.add(new Casa(200000, 240, 7.5, 150, 300)); // Prazo em meses

        // Adicionar financiamento de Apartamento (dados fixos)
        financiamentos.add(new Apartamento(150000, 180, 8.5, 2, 5)); // Prazo em meses

        // Adicionar financiamento de Terreno (dados fixos)
        financiamentos.add(new Terreno(100000, 120, 10.0, "Residencial")); // Prazo em meses

        // Exibir detalhes dos financiamentos e calcular totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Detalhes do Financiamento " + (i + 1) + ":");
            financiamentos.get(i).outDadosFinanc();
            System.out.println();

            // Calcular totais
            totalImoveis += financiamentos.get(i).getValorImovel();
            totalFinanciamentos += financiamentos.get(i).pagTotal();
        }

        // Exibir totais
        System.out.println("Total de todos os imóveis: R$ " + totalImoveis);
        System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos);

        // Salvar dados serializados em arquivo
        salvarDadosSerializados(financiamentos, "dados_serializados.txt");

        // Ler dados serializados do arquivo
        ArrayList<Financiamento> financiamentosLidos = lerDadosSerializados("dados_serializados.txt");

        // Exibir detalhes dos financiamentos lidos
        System.out.println("\nFinanciamentos lidos do arquivo:");
        for (Financiamento financiamento : financiamentosLidos) {
            financiamento.outDadosFinanc();
            System.out.println();
        }
    }

    private static void salvarDadosSerializados(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
            System.out.println("Dados serializados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados serializados: " + e.getMessage());
        }
    }

    private static ArrayList<Financiamento> lerDadosSerializados(String nomeArquivo) {
        ArrayList<Financiamento> financiamentosLidos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            financiamentosLidos = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("Dados serializados lidos com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler dados serializados: " + e.getMessage());
        }
        return financiamentosLidos;
    }
}
