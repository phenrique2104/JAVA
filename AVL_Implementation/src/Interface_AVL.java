import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Interface_AVL {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AVL arv = new AVL();
		String direc ="";
		Teclado_AVL t = new Teclado_AVL();
		
		//Diretório
		boolean v = true;
		while(v) {
			direc = t.leString("Digite o diretório onde está armazenado o Arquivo CSV:");
		
			try {
				arv.insert(direc);
				v = false;
			} 
			catch (ParseException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("Diretório Inválido.");
			}
		}
		arv.insereArvorePorNome();
		arv.insereArvorePorCpf();
		arv.insereArvorePorData();
		
		String str = "";
		long n = 0;
		String d1 = "";
		String d2 = "";
		boolean c = true;

		while (c) {
			System.out.println(" (1)Pesquisar uma pessoa por Nome;" + "\n (2)Pesquisar uma Pessoa por CPF;"
					+ "\n (3)Pesquisar uma pessoa por um intervalo de datas;");

			System.out.println("Escolha uma das opçoes acima ou digite -1 para sair:");
			int r = t.leInt();
			switch (r) {
			case 1:
				str = t.leString("Digite o nome que deseja pesquisar:");
				arv.buscaPorNome(str);
				break;

			case 2:
				str = t.leString("Digite o CPF que deseja pesquisar:");
				n = Long.parseLong(str);
				arv.buscaPorCpf(n);
				break;
			case 3:
				d1 = t.leString("Digite a data Inicial que deseja pesquisar no formato DD/MM/AAAA:");
				d2 = t.leString("Digite a data Final que deseja pesquisar no formato DD/MM/AAAA:");
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInicial = sdf1.parse(d1);
				Date dataFinal = sdf2.parse(d2);

				arv.buscaPorData(dataInicial, dataFinal);
				break;
			case -1:
				c = false;
				break;
			}
		}
	}
}
