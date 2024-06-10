package Model;

public class Vendedor extends Pessoa{
	protected String senha;
	protected String cargo;
	protected double salario;
	
	public Vendedor() {}
	public Vendedor(
			String nome, String email,
			String cpf, int idade,
			String senha, String cargo,
			double salario
	) {
		super(nome, email, cpf, idade);
		this.senha = senha;
		this.cargo = cargo;
		this.salario = salario;
	};
	

	public String getSenha() {
		return this.senha;
	};
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	};
	
	public String getCargo() {
		return this.cargo;
	};
	public void setCargo(String novoCargo) {
		this.cargo = novoCargo;
	};
	
	public double getSalario() {
		return this.salario;
	};
	public void setSalario(double novoSalario) {
		this.salario = novoSalario;
	};
	@Override
	public String toString() {
		return "Funcionário:" + nome + ". Email:" + email + ". CPF:" + cpf + ". Idade:"
				+ idade + ". Cargo:" + cargo + ". Salario anual:" + salario + ".";
	}

	
	
}