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
	
	public double getSalarioAnual() {
		double salarioAnual = this.salario*12;
		
		return salarioAnual;
	};
	public void setSalario(double novoSalario) {
		this.salario = novoSalario;
	};
	
	public String cadastrarCliente(
			String nome, String email,
			String cpf, int idade
	){
		//TODO codigo para cadastrar no banco de dados
		return "Cliente cadastrado com sucesso!";
	};
	public String atualizarCliente(String nome, String email) {
		setNome(nome);
		setEmail(email);
		return "Atualização realizada!";
	}
	@Override
	public String toString() {
		return "nome:" + nome + ", email:" + email + ", cpf:" + cpf + ", idade:"
				+ idade + ", cargo:" + cargo + ", salario:" + salario;
	}

	
	
}