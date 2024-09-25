package Contatos;

public class Contato {
	
	private String nome;
	private String email;
	private String telefone;
	
	public Contato(final String nome, final String email, final String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {	
		return "Nome: "+this.nome+"\r\n"
				+"E-mail: "+this.email+"\r\n"
				+"Telefone: "+this.telefone;
	}

}
