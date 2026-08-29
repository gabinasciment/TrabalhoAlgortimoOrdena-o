package selecaodireta;

public class InsercaoDireta {
	int[] vetor;
	int nElem;

	long comparacoes;
	long movimentacoes;
	long tempo;

	public InsercaoDireta(int[] vetor) {
		this.vetor = vetor;
		this.nElem = vetor.length;
	}

	public void insercaoDireta() {
		int i, j;
		int temp;

		comparacoes = 0;
		movimentacoes = 0;

		long inicio = System.nanoTime();

		for (i = 1; i < this.nElem; i++) {
			temp = this.vetor[i];
			movimentacoes ++;
			j = i - 1;

			while (j >= 0) {
				comparacoes ++;

				if(this.vetor[j]>temp) {
					this.vetor[j+1] = this.vetor[j];
					movimentacoes++;
					j--;
				}else {
					break;
				}
			}
			this.vetor[j+1] = temp;
			movimentacoes++;
		}
		long fim = System.nanoTime();
		tempo = fim-inicio;
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

}
