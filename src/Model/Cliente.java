package Model;

public class Cliente extends Pessoa{
	private String endereco;
	private String cep;
	private String numeroCasa;
	private String senha;
	
	public Cliente() {}
	public Cliente(
			String nome, String email, String cpf,
			int idade, String senha,
			String endereco, String cep, String numeroCasa
			) {
		super(nome, email, cpf, idade);
		this.senha = senha;
		this.endereco = endereco;
		this.cep = cep;
		this.numeroCasa = numeroCasa;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + nome + ". Email: " + email + ". CPF: " + cpf + ". Idade: " + idade +
				". Endereço: " + endereco + ". CEP: " + cep + ". Numero de residência: " + numeroCasa + ".";
	}
}
