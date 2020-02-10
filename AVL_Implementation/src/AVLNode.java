
public class AVLNode {

	private int altura;
	private Pessoa chave;
	private AVLNode esquerda, direita;

	public AVLNode(Pessoa pessoa) {
		this(pessoa, null, null);
	}

	public AVLNode(Pessoa pessoa, AVLNode esquerda, AVLNode direita) {
		this.chave = pessoa;
		this.esquerda = esquerda;
		this.direita = direita;
		this.altura = 0;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Pessoa getChave() {
		return chave;
	}

	public void setChave(Pessoa chave) {
		this.chave = chave;
	}

	public AVLNode getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(AVLNode esquerda) {
		this.esquerda = esquerda;
	}

	public AVLNode getDireita() {
		return direita;
	}

	public void setDireita(AVLNode direita) {
		this.direita = direita;
	}

}



