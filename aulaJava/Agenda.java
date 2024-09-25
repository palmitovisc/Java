package Agenda;

import Contatos.Contato;

public class Agenda {
	
	private Contato contatos[];
	
	public Agenda(final int tamanho) {
		contatos = new Contato[tamanho];
	}

	public boolean adicionar(final Contato novoContato) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null) {
				contatos[i] = novoContato;
				return true;
			}
		}
		return false;
	}
	
	public boolean remover(final String nome) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null && contatos[i].getNome().equalsIgnoreCase(nome)) {
				contatos[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public void exibirContatos() {
		
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(contatos[i].toString());
			}
		}
		
	}
	
}

