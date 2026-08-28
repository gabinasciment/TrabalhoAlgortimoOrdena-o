package selecaodireta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    /*
     * Copia um arquivo TXT de um caminho para outro.
     */
    public static void copiarArquivo(String origem, String destino) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader(origem)
        );

        BufferedWriter writer = new BufferedWriter(
                new FileWriter(destino)
        );

        String linha;

        while ((linha = reader.readLine()) != null) {

            writer.write(linha);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }


    /*
     * Lê um arquivo contendo números inteiros
     * e retorna um Vetor com esses números.
     */
    public static Vetor lerArquivo(String caminho) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader(caminho)
        );

        // Primeiro vamos descobrir quantos números existem
        int quantidade = 0;

        String linha;

        while ((linha = reader.readLine()) != null) {

            if (!linha.trim().isEmpty()) {
                quantidade++;
            }
        }

        reader.close();


        // Cria o vetor com o tamanho necessário
        Vetor vetor = new Vetor(quantidade);


        // Abre novamente o arquivo para ler os números
        reader = new BufferedReader(
                new FileReader(caminho)
        );

        while ((linha = reader.readLine()) != null) {

            if (!linha.trim().isEmpty()) {

                int numero = Integer.parseInt(linha.trim());

                vetor.adicionar(numero);
            }
        }

        reader.close();

        return vetor;
    }


    /*
     * Escreve o conteúdo do vetor e as métricas
     * em um arquivo TXT.
     */
    public static void escreverArquivo(
            String caminho,
            Vetor vetor,
            String algoritmo) throws IOException {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter(caminho)
        );

        writer.write("Algoritmo: " + algoritmo);
        writer.newLine();
        writer.newLine();

        writer.write("Números ordenados:");
        writer.newLine();

        for (int i = 0; i < vetor.getNElem(); i++) {

            writer.write(String.valueOf(vetor.getVetor()[i]));
            writer.newLine();
        }

        writer.newLine();

        writer.write("Métricas:");
        writer.newLine();

        writer.write("Comparações: "
                + vetor.getComparacoes());
        writer.newLine();

        writer.write("Movimentações: "
                + vetor.getMovimentacoes());
        writer.newLine();

        writer.write("Tempo: "
                + vetor.getTempo() + " ns");
        writer.newLine();

        writer.write("Tempo: "
                + vetor.getTempo() / 1_000_000.0 + " ms");
        writer.newLine();

        writer.close();
    }
}