package Usuarios;

public class Funcionario extends Pessoa{
	protected String senha;
	protected String cargo;
	protected double salario;
	
	public Funcionario(
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
	
	public String getCargo() {
		return this.cargo;
	};
	public double getSalarioAnual() {
		double salarioAnual = this.salario*12;
		
		return salarioAnual;
	}
	
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
	
}