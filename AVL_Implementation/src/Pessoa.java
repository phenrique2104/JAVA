import java.util.Date;

public class Pessoa {
	long cpf;
	long rg;
	String nome;
	Date data;
	String cidade;

	public Pessoa(long cpf, long rg, String nome, Date data, String cidade) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.data = data;
		this.cidade = cidade;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toStringData() {
		int mes = data.getMonth() + 1;
		int ano = data.getYear() + 1900;
		return data.getDate() + "/" + mes + "/" + ano;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int compareTo(Pessoa chave, int aux) {
		switch (aux) {
		case 1:
			return chave.getNome().compareTo(this.nome);
		case 2:
			if (chave.getCpf() - this.cpf > 0) {
				return 1;
			} else if (chave.getCpf() - this.cpf < 0) {
				return -1;
			} else {
				return 0;
			}
		case 3:
			return chave.getData().compareTo(this.data);
		}
		return 0;
	}

	public String toString() {
		String s = "\n";
		s += "Nome: " + this.nome + "\n";
		s += "Cidade: " + this.cidade + "\n";
		s += "CPF: " + this.cpf + "\n";
		s += "RG: " + this.rg + "\n";
		s += "Data de Nascimento: " + this.toStringData() + "\n";
		return s;
	}
}
