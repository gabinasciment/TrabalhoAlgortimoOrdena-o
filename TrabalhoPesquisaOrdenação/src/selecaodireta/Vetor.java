package selecaodireta;

public class Vetor {

	private int[] vetor;
	private int nElem;

	private long comparacoes;
	private long movimentacoes;
	private long tempo;

	public Vetor(int tamanho) {
		this.vetor = new int[tamanho];
		this.nElem = 0;
	}

	public void adicionar(int valor) {
		vetor[nElem] = valor;
		nElem++;
	}

	public int[] getVetor() {
		return vetor;
	}

	public int getNElem() {
		return nElem;
	}

	public long getComparacoes() {
		return comparacoes;
	}

	public long getMovimentacoes() {
		return movimentacoes;
	}

	public long getTempo() {
		return tempo;
	}
	
	
	public Vetor copiar() {

        Vetor copia = new Vetor(this.nElem);

        for (int i = 0; i < this.nElem; i++) {
            copia.vetor[i] = this.vetor[i];
        }

        copia.nElem = this.nElem;

        return copia;
    }

	public void heapSort() {

		comparacoes = 0;
		movimentacoes = 0;

		long inicio = System.nanoTime();

		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		int temp;

		while (esq >= 0) {

			comparacoes++;

			refazHeap(esq, nElem - 1);

			esq--;
		}

		while (dir > 0) {

			comparacoes++;

			temp = vetor[0];

			vetor[0] = vetor[dir];
			vetor[dir] = temp;

			// Troca = 2 movimentações
			movimentacoes += 2;

			dir--;

			refazHeap(0, dir);
		}

		long fim = System.nanoTime();

		tempo = fim - inicio;
	}

	private void refazHeap(int esq, int dir) {

		int i = esq;
		int maiorFolha = 2 * i + 1;
		int raiz = vetor[i];

		boolean heap = false;

		while ((maiorFolha <= dir) && (!heap)) {

			comparacoes++;

			if (maiorFolha < dir) {

				comparacoes++;

				if (vetor[maiorFolha] < vetor[maiorFolha + 1]) {
					maiorFolha++;
				}
			}

			comparacoes++;

			if (raiz < vetor[maiorFolha]) {

				vetor[i] = vetor[maiorFolha];

				movimentacoes++;

				i = maiorFolha;
				maiorFolha = 2 * i + 1;

			} else {

				heap = true;
			}
		}

		vetor[i] = raiz;

		movimentacoes++;
	}
	
	
	public void shellSort() {

	    int i, j, h;
	    int temp;

	
	    long inicio = System.nanoTime();

	    //sequência de incrementos
	    h = 1;

	    do {
	        h = 3 * h + 1;

	        // Comparação do while
	        comparacoes++;

	    } while (h < this.nElem);

	    do {

	        h = h / 3;

	        for (i = h; i < this.nElem; i++) {

	            temp = this.vetor[i];
	            movimentacoes++;

	            j = i;

	            while (this.vetor[j - h] > temp) {

	                comparacoes++;

	                this.vetor[j] = this.vetor[j - h];
	                movimentacoes++;

	                j -= h;

	                if (j < h) {

	                    comparacoes++;

	                    break;
	                }
	            }

	            // Quando o while termina
	            comparacoes++;

	            this.vetor[j] = temp;
	            movimentacoes++;
	        }

	        // Comparação do while
	        comparacoes++;

	    } while (h != 1);

	    
	    long fim = System.nanoTime();

	    tempo = fim - inicio;
	}

}
