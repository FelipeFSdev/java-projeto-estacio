package Model;

import java.util.UUID;

public abstract class Pessoa {
	protected String id;
	protected String nome;
	protected String email;
	protected String cpf;
	protected int idade;
	
	public Pessoa() {}
	
	public Pessoa (
			String nome, String email,
			String cpf, int idade
	) {
		id = UUID.randomUUID().toString();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.idade = idade;
	};
	
	public String getId() {
		return this.id;
	};
	public void setId(String novoId) {
		this.id = novoId;
	};
	
	public String getNome(){
		return this.nome;
	};
	public void setNome(String novoNome) {
		this.nome = novoNome;
	};
	
	public String getEmail(){
		return this.email;
	};
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	};
	
	public String getCpf(){
		return this.cpf;
	};
	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
	};
	
	public int getIdade(){
		return this.idade;
	};
	public void setIdade(int novaIdade) {
		this.idade = novaIdade;
	};
	
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", idade=" + idade + "]";
	}
	
}