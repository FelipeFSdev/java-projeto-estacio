package Usuarios;

import java.util.UUID;

public abstract class Pessoa {
	protected String id;
	protected String nome;
	protected String email;
	protected String cpf;
	protected int idade;
	
	public Pessoa (
			String nome, String email,
			String cpf, int idade
	) {
		id = UUID.randomUUID().toString();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public String getId() {
		return this.id;
	};
	public String getNome(){
		return this.nome;
	};
	public String getEmail(){
		return this.email;
	};
	public String getCpf(){
		return this.cpf;
	};
	public int getIdade(){
		return this.idade;
	};
	
	public void setNome(String nome) {
		this.nome = nome;
	};
	public void setEmail(String email) {
		this.email = email;
	};
	
}