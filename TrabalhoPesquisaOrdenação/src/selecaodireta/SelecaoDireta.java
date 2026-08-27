package selecaodireta;

public class SelecaoDireta {

    int[] vetor;
    int nElem;

    public SelecaoDireta(int[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
    }

    public void selecaoDireta() {

        int i, j, minimo;
        int temp;

        for (i = 0; i < this.nElem - 1; i++) {

            minimo = i;

            for (j = i + 1; j < this.nElem; j++) {

                if (this.vetor[j] < this.vetor[minimo]) {
                    minimo = j;
                }
            }

            temp = this.vetor[minimo];
            this.vetor[minimo] = this.vetor[i];
            this.vetor[i] = temp;
        }
    }
}
