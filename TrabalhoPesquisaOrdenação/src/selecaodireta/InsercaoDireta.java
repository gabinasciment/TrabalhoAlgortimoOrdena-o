package selecaodireta;

public class InsercaoDireta {

	    int[] vetor;
	    int nElem;

	    public InsercaoDireta(int[] vetor) {
	        this.vetor = vetor;
	        this.nElem = vetor.length;
	    }

	    public void insercaoDireta() {

	        int i, j;
	        int temp;

	        for (i = 1; i < this.nElem; i++) {

	            temp = this.vetor[i];
	            j = i - 1;

	            while ((j >= 0) && (this.vetor[j] > temp)) {

	                this.vetor[j + 1] = this.vetor[j];
	                j--;
	            }

	            this.vetor[j + 1] = temp;
	        }
	    }

}
