package selecaodireta;

public class HeapSort {

    int[] vetor;
    int nElem;

    public HeapSort(int[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
    }

    public void heapSort() {

        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        int temp;

        while (esq >= 0) {
            refazHeap(esq--, this.nElem - 1);
        }

        while (dir > 0) {

            temp = this.vetor[0];
            this.vetor[0] = this.vetor[dir];
            this.vetor[dir--] = temp;

            refazHeap(0, dir);
        }
    }

    private void refazHeap(int esq, int dir) {

        int i = esq;
        int maiorFolha = 2 * i + 1;
        int raiz = this.vetor[i];
        boolean heap = false;

        while ((maiorFolha <= dir) && (!heap)) {

            if (maiorFolha < dir) {

                if (this.vetor[maiorFolha] < this.vetor[maiorFolha + 1]) {
                    maiorFolha++;
                }
            }

            if (raiz < this.vetor[maiorFolha]) {

                this.vetor[i] = this.vetor[maiorFolha];
                i = maiorFolha;
                maiorFolha = 2 * i + 1;

            } else {
                heap = true;
            }
        }

        this.vetor[i] = raiz;
    }

}
