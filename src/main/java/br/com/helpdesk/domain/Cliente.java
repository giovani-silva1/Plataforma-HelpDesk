package br.com.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Chamado> chamados = new ArrayList<>();

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String cpf, String senha) {
		super(id, nome, cpf, senha);
	}
	
	
	

	
	
	
}
