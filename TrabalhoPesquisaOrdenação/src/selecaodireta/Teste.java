package selecaodireta;

public class Teste {

    public static void main(String[] args) {

        Vetor original = new Vetor(7);

        original.adicionar(45);
        original.adicionar(12);
        original.adicionar(87);
        original.adicionar(3);
        original.adicionar(21);
        original.adicionar(9);
        original.adicionar(66);

        System.out.println("Vetor original:");

        for (int i = 0; i < original.getNElem(); i++) {
            System.out.print(original.getVetor()[i] + " ");
        }

        Vetor copia = original.copiar();

        copia.shellSort();

        System.out.println("\n\nVetor ordenado pelo ShellSort:");

        for (int i = 0; i < copia.getNElem(); i++) {
            System.out.print(copia.getVetor()[i] + " ");
        }

        System.out.println("\n\n===== MÉTRICAS =====");

        System.out.println("Comparações: "
                + copia.getComparacoes());

        System.out.println("Movimentações: "
                + copia.getMovimentacoes());

        System.out.println("Tempo: "
                + copia.getTempo() + " ns");

        System.out.println("Tempo: "
                + copia.getTempo() / 1_000_000.0 + " ms");

        System.out.println("\nVetor original:");

        for (int i = 0; i < original.getNElem(); i++) {
            System.out.print(original.getVetor()[i] + " ");
        }
    }
}