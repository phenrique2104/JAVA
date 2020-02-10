import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class teste {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AVL teste = new AVL();
		try {
			teste.insert("C:\\Users\\Felipe\\Desktop\\teste.txt");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teste.lePessoa();
		teste.insereArvorePorNome();
		teste.insereArvorePorCpf();
		teste.insereArvorePorData();
		
		System.out.println("NÃO BUGOU");
		
		
		System.out.println("\n"+"EXIBINDO ÁRVORE ORDENADA POR NOMES EM ORDEM"+"\n");
		teste.exibeArvorePorNome();
		
		System.out.println("\n"+"EXIBINDO ÁRVORE ORDENADA POR CPF EM ORDEM"+"\n");
		teste.exibeArvorePorCpf();
		
		System.out.println("\n"+"EXIBINDO ÁRVORE ORDENADA POR DATA EM ORDEM"+"\n");
		teste.exibeArvorePorData();
		
		System.out.println("\n"+"BUSCANDO UMA PESSOA PELO SEU CPF"+"\n");
		System.out.println("\n"+"DEVE ACHAR A PESSOA FULANO");
		String cpfSring = "12345678910";
		long cpf_long = Long.parseLong(cpfSring);
		teste.buscaPorCpf(cpf_long);
		System.out.println("\n"+"NÃO DEVE ACHAR"+"\n");
		cpfSring = "11111111111";
		cpf_long = Long.parseLong(cpfSring);
		teste.buscaPorCpf(cpf_long);
		System.out.println("\n"+"DEVE ACHAR A PESSOA CICRANA");
		cpfSring = "10987654321";
		cpf_long = Long.parseLong(cpfSring);
		teste.buscaPorCpf(cpf_long);
		
		System.out.println("\n"+"BUSCANDO UMA PESSOA POR UM INTERVALO DE DATA"+"\n");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial1 = sdf1.parse("01/01/1950");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFinal1 = sdf2.parse("01/01/3000");
		
		System.out.println("\n"+"DEVE EXIBIR AS DUAS PESSOAS"+"\n");
		teste.buscaPorData(dataInicial1, dataFinal1);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial2 = sdf3.parse("01/01/1950");
		Date dataFinal2 = sdf4.parse("01/01/1980");
		
		System.out.println("\n"+"DEVE EXIBIR A PESSOA FULANO"+"\n");
		teste.buscaPorData(dataInicial2, dataFinal2);
		
		SimpleDateFormat sdf5 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf6 = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial3 = sdf5.parse("01/01/1980");
		Date dataFinal3 = sdf6.parse("01/01/3000");
		
		System.out.println("\n"+"DEVE EXIBIR A PESSOA CICRANA"+"\n");
		teste.buscaPorData(dataInicial3, dataFinal3);
		
		
		System.out.println("\n"+"EXIBIR POR NOME"+"\n");
		String tst1 = "Cic";
		String tst2 = "Ful";
		String tst3 = "Cisc";
		System.out.println("\n"+"DEVE EXIBIR A PESSOA CICRANA"+"\n");
		teste.buscaPorNome(tst1);
		System.out.println("\n"+"DEVE EXIBIR A PESSOA FULANO"+"\n");
		teste.buscaPorNome(tst2);
		System.out.println("\n"+"DEVE EXIBIR NINGUÉM"+"\n");
		teste.buscaPorNome(tst3);
		
	}

}
