import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AVL {

	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	//Lê txt no modo CSV, cria os Objetos Pessoa e insere no ArrayList pessoas.
	public void insert(String direc) throws NumberFormatException, IOException, ParseException {

		String cpf = "";
		String rg = "";
		String nome = "";
		String data = "";
		String cidade = "";
		
		//"C:\\Users\\Felipe\\Desktop\\teste.txt"
		File file = new File(direc);
		BufferedReader insert = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

		String dado;
		while ((dado = insert.readLine()) != null) {
			String spl[] = new String[4];
			spl = dado.split(";");
			for (int i = 0; i < spl.length; i++) {
				switch (i) {
				case 0:
					if (spl[i].charAt(0) == ' ') {
						for (int j = 1; j < spl[i].length(); j++) {
							if (spl[i].charAt(j) != ' ') {
								cpf += spl[i].charAt(j);
							}
						}
					} else {
						cpf = spl[i];
					}
					break;
				case 1:
					if (spl[i].charAt(0) == ' ') {
						for (int j = 1; j < spl[i].length(); j++) {
							if (spl[i].charAt(j) != ' ') {
								rg += spl[i].charAt(j);
							}
						}
					} else {
						rg = spl[i];
					}
					break;
				case 2:
					if (spl[i].charAt(0) == ' ') {
						for (int j = 1; j < spl[i].length(); j++) {
							if (spl[i].charAt(j) != ' ') {
								nome += spl[i].charAt(j);
							}
						}
					} else {
						nome = spl[i];
					}
					break;
				case 3:
					if (spl[i].charAt(0) == ' ') {
						for (int j = 1; j < spl[i].length(); j++) {
							if (spl[i].charAt(j) != ' ') {
								data += spl[i].charAt(j);
							}
						}
					} else {
						data = spl[i];
					}
					break;
				case 4:
					if (spl[i].charAt(0) == ' ') {
						for (int j = 1; j < spl[i].length(); j++) {
							if (spl[i].charAt(j) != ' ') {
								cidade += spl[i].charAt(j);
							}
						}
					} else {
						cidade = spl[i];
					}
					break;
				}
			}

			long cpf_int = Long.parseLong(cpf);
			long rg_int = Long.parseLong(rg);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data_date = sdf.parse(data);
			Pessoa p = new Pessoa(cpf_int, rg_int, nome, data_date, cidade);
			pessoas.add(p);

			// cont ++;
			cpf = "";
			rg = "";
			nome = "";
			data = "";
			cidade = "";

		}
	}
	
	//Lê o ArrayList pessoas e printa na tela os parâmetros da pessoa.
	public void lePessoa() {
		for (int i = 0; i < pessoas.size(); i++) {
			System.out.println(i + ": " + pessoas.get(i).getCpf());
			System.out.println(i + ": " + pessoas.get(i).getRg());
			System.out.println(i + ": " + pessoas.get(i).getNome());
			System.out.println(i + ": " + pessoas.get(i).toStringData());
			System.out.println(i + ": " + pessoas.get(i).getCidade());
			System.out.println(pessoas.get(i).toString());
			System.out.println("");
		}
	}
	//Instancia as três árvores
	AVLArvore ArvorePorNome = new AVLArvore();
	AVLArvore ArvorePorCpf = new AVLArvore();
	AVLArvore ArvorePorData = new AVLArvore();

	//Insere na árvore por Nome.
	public void insereArvorePorNome() {
		for (int i = 0; i < pessoas.size(); i++) {
			ArvorePorNome.insert(pessoas.get(i), 1);
		}
	}
	
	//Insere na árvore por CPF.
	public void insereArvorePorCpf() {
		for (int i = 0; i < pessoas.size(); i++) {
			ArvorePorCpf.insert(pessoas.get(i), 2);
		}
	}

	//Insere na árvore por Data.
	public void insereArvorePorData() {
		for (int i = 0; i < pessoas.size(); i++) {
			ArvorePorData.insert(pessoas.get(i), 3);
		}
	}

	//Exibe a árvore ordenada por Nome.
	public void exibeArvorePorNome() {
		ArvorePorNome.exibeEmOrdem();
		;
	}
	
	//Exibe a árvore ordenada por CPF.
	public void exibeArvorePorCpf() {
		ArvorePorCpf.exibeEmOrdem();
	}

	//Exibe a árvore ordenada por Data.
	public void exibeArvorePorData() {
		ArvorePorData.exibeEmOrdem();
	}

	//Busca o CPF na árvore.
	public void buscaPorCpf(long cpf) throws Exception {
		try {
			System.out.println(ArvorePorCpf.buscaPorCpf(cpf).getChave().toString());
		} catch (Exception e) {
			System.out.println("NÃO FOI ENCONTRADA NENHUMA PESSOA COM O CPF INFORMADO");
		}
	}

	//Busca o por intervalo de Data na árvore.
	public void buscaPorData(Date dataInicial, Date dataFinal) {
		ArvorePorData.buscaPorData(dataInicial, dataFinal);
	}
	
	//Busca o Nome na árvore.
	public void buscaPorNome(String str) {
		ArvorePorNome.buscaPorNome(str);
	}
}
