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
	
	public double getBonusDeCargo() {
		return this.bonusDeCargo;
	}
	
	@Override
	public double getSalario() {
		return this.salario;
	}

}