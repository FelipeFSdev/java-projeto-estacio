package Model;

public final class Gerente extends Vendedor{
	double bonusDeCargo;

	public Gerente(
			String nome, String email,
			String cpf, int idade,
			String senha, String cargo,
			double salario, double bonusDeCargo
	) {
		super(nome, email, cpf, idade, senha, cargo, salario);
		this.bonusDeCargo = bonusDeCargo;
	}
	
	@Override
	public double getSalarioAnual() {
		double salarioAnual = (salario + bonusDeCargo) * 12;
		
		return salarioAnual;
	}
	
	public String cadastrarFuncionario(
			String nome, String email,
			String cpf, int idade,
			String senha, String cargo,
			double salario
	) {
		//TODO código para cadastrar funcionario no banco de dados
		return "Funcionario cadastrado com sucesso!";
	}
	public String atualizarFuncionario(String cpf, String nome, String email, String cargo) {
		//TODO identificar funcionario pelo cpf;
		//funcionario setNome(nome);
		//funcionario setEmail(email);
		//funcionario setCargp(cargo);
		return "Atualização realizada!";
	}
}