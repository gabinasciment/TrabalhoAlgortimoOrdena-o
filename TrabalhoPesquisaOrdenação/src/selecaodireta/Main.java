package selecaodireta;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Vetor original = carregarArquivo();

        int opcao;

        do {

            opcao = menu();

            switch (opcao) {

                case 1:
                    executarHeapSort(original);
                    break;

                case 2:
                    executarQuickSort(original);
                    break;

                case 3:
                    executarBubbleSort(original);
                    break;

                case 4:
                    executarSelecaoDireta(original);
                    break;

                case 5:
                    executarInsercaoDireta(original);
                    break;

                case 6:
                    executarShellSort(original);
                    break;

                case 7:
                    executarShakerSort(original);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scan.close();
    }
    
    
    public static int menu() {

        System.out.println("\n========== MENU ==========");
        System.out.println("1 - HeapSort");
        System.out.println("2 - QuickSort");
        System.out.println("3 - BubbleSort");
        System.out.println("4 - Seleção Direta");
        System.out.println("5 - Inserção Direta");
        System.out.println("6 - ShellSort");
        System.out.println("7 - ShakerSort");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        return scan.nextInt();
    }
    
    public static void executarHeapSort(Vetor original) {

        Vetor copia = original.copiar();

        copia.heapSort();

        System.out.println("\n===== HEAPSORT =====");

        System.out.println("Comparações: "
                + copia.getComparacoes());

        System.out.println("Movimentações: "
                + copia.getMovimentacoes());

        System.out.println("Tempo: "
                + copia.getTempo() + " ns");

        System.out.println("Tempo: "
                + (copia.getTempo() / 1_000_000.0) + " ms");
    }
    
    public static void executarShellSort(Vetor original) {

        Vetor copia = original.copiar();

       
        copia.shellSort();

       
        System.out.println("\n===== SHELLSORT =====");

        System.out.println("Vetor ordenado:");

        for (int i = 0; i < copia.getNElem(); i++) {
            System.out.print(copia.getVetor()[i] + " ");
        }

        System.out.println();

        
        System.out.println("\nComparações: "
                + copia.getComparacoes());

        System.out.println("Movimentações: "
                + copia.getMovimentacoes());

        System.out.println("Tempo: "
                + copia.getTempo() + " ns");

        System.out.println("Tempo: "
                + copia.getTempo() / 1_000_000.0 + " ms");
    }
    
    
    
}
