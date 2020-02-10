import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AVLArvore {

	private AVLNode raiz;

	// Construtor da Arvore AVL
	public AVLArvore() {
		raiz = null;
	}

	private static int altura(AVLNode nodo) {
		if (nodo == null)
			return -1;
		else
			return nodo.getAltura();
	}

	// Seleciona dois nodos, compara a altura entre eles e retorna a maior dentre elas
	private static int getNodoMaisAlto(int NodoEsquerda, int NodoDireita) {
		if (NodoEsquerda > NodoDireita)
			return NodoEsquerda;
		else
			return NodoDireita;
	}
	// Retorna o fator de um nodo
	// Calcula o fator de balanceamento
	private int getFator(AVLNode nodo) {
		return altura(nodo.getEsquerda()) - altura(nodo.getDireita());
	}

	// Metodo Mestre de Inserções.
	public void insert(Pessoa pessoa, int aux) {
		if (aux == 1) {
			raiz = insertPorNome(pessoa, raiz);
		} else if (aux == 2) {
			raiz = insertPorCpf(pessoa, raiz);
		} else if (aux == 3) {
			raiz = insertPorData(pessoa, raiz);
		} else {
			System.out.println("Digito Inválido");
		}
	}

	//Insere na árvore, ordenando por Nome.
	private AVLNode insertPorNome(Pessoa pessoa, AVLNode nodo) {
		if (nodo == null) {
			nodo = new AVLNode(pessoa, null, null);
		}
		else if (pessoa.compareTo(nodo.getChave(), 1) > 0) {
			nodo.setEsquerda((insertPorNome(pessoa, nodo.getEsquerda())));
		}
		else if (pessoa.compareTo(nodo.getChave(), 1) < 0) {
			nodo.setDireita(insertPorNome(pessoa, nodo.getDireita()));
		}
		if (getFator(nodo) == 2) {
			if (getFator(nodo.getEsquerda()) > 0)
				nodo = rotacaoSimplesDireita(nodo);
			else
				nodo = rotacaoDuplaDireita(nodo);
		} else if (getFator(nodo) == -2) {
			if (getFator(nodo.getDireita()) < 0)
				nodo = rotacaoSimplesEsquerda(nodo);
			else
				nodo = rotacaoDuplaEsquerda(nodo);
		}
		nodo.setAltura(getNodoMaisAlto(altura(nodo.getEsquerda()), altura(nodo.getDireita())) + 1);
		return nodo;
	}
	
	//Insere na árvore, ordenando por CPF.
	private AVLNode insertPorCpf(Pessoa pessoa, AVLNode nodo) {
		if (nodo == null) {
			nodo = new AVLNode(pessoa, null, null);
		}
		else if (pessoa.compareTo(nodo.getChave(), 2) > 0) {
			nodo.setEsquerda((insertPorCpf(pessoa, nodo.getEsquerda())));
		}
		else if (pessoa.compareTo(nodo.getChave(), 2) < 0) {
			nodo.setDireita(insertPorCpf(pessoa, nodo.getDireita()));
		}
		if (getFator(nodo) == 2) {
			if (getFator(nodo.getEsquerda()) > 0)
				nodo = rotacaoSimplesDireita(nodo);
			else
				nodo = rotacaoDuplaDireita(nodo);
		} else if (getFator(nodo) == -2) {
			if (getFator(nodo.getDireita()) < 0)
				nodo = rotacaoSimplesEsquerda(nodo);
			else
				nodo = rotacaoDuplaEsquerda(nodo);
		}
		nodo.setAltura(getNodoMaisAlto(altura(nodo.getEsquerda()), altura(nodo.getDireita())) + 1);
		return nodo;
	}

	//Insere na árvore, ordenando por data.
	private AVLNode insertPorData(Pessoa pessoa, AVLNode nodo) {
		if (nodo == null) {
			nodo = new AVLNode(pessoa, null, null);
		}
		else if (pessoa.compareTo(nodo.getChave(), 3) > 0) {
			nodo.setEsquerda((insertPorData(pessoa, nodo.getEsquerda())));
		}
		else if (pessoa.compareTo(nodo.getChave(), 3) < 0) {
			nodo.setDireita(insertPorData(pessoa, nodo.getDireita()));
		}
		if (getFator(nodo) == 2) {
			if (getFator(nodo.getEsquerda()) > 0)
				nodo = rotacaoSimplesDireita(nodo);
			else
				nodo = rotacaoDuplaDireita(nodo);
		} else if (getFator(nodo) == -2) {
			if (getFator(nodo.getDireita()) < 0)
				nodo = rotacaoSimplesEsquerda(nodo);
			else
				nodo = rotacaoDuplaEsquerda(nodo);
		}
		nodo.setAltura(getNodoMaisAlto(altura(nodo.getEsquerda()), altura(nodo.getDireita())) + 1);
		return nodo;
	}
	
	//Rotaciona a Sub-árvore a Direita.
	private static AVLNode rotacaoSimplesDireita(AVLNode n2) {
		AVLNode n1 = n2.getEsquerda();
		n2.setEsquerda(n1.getDireita());
		n1.setDireita(n2);
		n2.setAltura(getNodoMaisAlto(altura(n2.getEsquerda()), altura(n2.getDireita())) + 1);
		n1.setAltura(getNodoMaisAlto(altura(n1.getEsquerda()), n2.getAltura()) + 1);
		return n1; 
	}
	
	//Rotaciona a Sub-árvore a esquerda.
	private static AVLNode rotacaoSimplesEsquerda(AVLNode n1) {
		AVLNode n2 = n1.getDireita();
		n1.setDireita(n2.getEsquerda());
		n2.setEsquerda(n1);
		n1.setAltura(getNodoMaisAlto(altura(n1.getEsquerda()), altura(n1.getDireita())) + 1);
		n2.setAltura(getNodoMaisAlto(altura(n2.getDireita()), n1.getAltura()) + 1);
		return n2;
	}
	
	//Rotaciona a Sub-árvore primeiro a esquerda, depois a direita.
	private static AVLNode rotacaoDuplaDireita(AVLNode n3) {
		n3.setEsquerda(rotacaoSimplesEsquerda(n3.getEsquerda()));
		return rotacaoSimplesDireita(n3);
	}
	//Rotaciona a Sub-árvore primeiro a direita, depois a esquerda.
	private static AVLNode rotacaoDuplaEsquerda(AVLNode n1) {
		n1.setDireita(rotacaoSimplesDireita(n1.getDireita()));
		return rotacaoSimplesEsquerda(n1);
	}

	public void exibeEmOrdem() {
		exibeEmOrdem(raiz);
	}

	protected void exibeEmOrdem(AVLNode nodo) {
		if (nodo != null) {
			exibeEmOrdem(nodo.getEsquerda());
			System.out.println(nodo.getChave().toString());
			exibeEmOrdem(nodo.getDireita());
		}
	}

	public AVLNode buscaPorCpf(long cpf) {
		return buscaPorCpf(raiz, cpf);
	}

	protected AVLNode buscaPorCpf(AVLNode nodo, long cpf) {

		if (nodo == null)
			return null;

		if (cpf - nodo.getChave().getCpf() == 0) {
			return nodo;
		}

		if (cpf - nodo.getChave().getCpf() < 0) {
			return buscaPorCpf(nodo.getEsquerda(), cpf);
		}

		return buscaPorCpf(nodo.getDireita(), cpf);
	}

	public void buscaPorData(Date dataInicial, Date dataFinal) {
		buscaPorData(raiz, dataInicial, dataFinal);
	}

	protected void buscaPorData(AVLNode nodo, Date dataInicial, Date dataFinal) {
		if (nodo != null) {
			buscaPorData(nodo.getEsquerda(), dataInicial, dataFinal);
			if((nodo.getChave().getData().after(dataInicial) || nodo.getChave().getData().equals(dataInicial)) 
					&& 
					(nodo.getChave().getData().before(dataFinal) || nodo.getChave().getData().equals(dataFinal)) 
				){
			System.out.println(nodo.getChave().toString());
			}
			buscaPorData(nodo.getDireita(), dataInicial, dataFinal);
		}
		return;
	}
	
	public void buscaPorNome(String str){
		buscaPorNome(raiz, str);
	}
	
	protected void buscaPorNome(AVLNode nodo, String str) {
		if(nodo != null) {
			buscaPorNome(nodo.getEsquerda(), str);
			boolean ver = false;
			int temp = str.length();
			for (int i = 0; i < temp ; i++) {				
				if(str.charAt(i) == nodo.getChave().getNome().charAt(i)) {
					ver = true;
				}
				else {
					ver = false;
					break;
				}
			}
			if(ver) {
				System.out.println(nodo.getChave().toString());
			}
			buscaPorNome(nodo.getDireita(), str);
		}
	}
}
