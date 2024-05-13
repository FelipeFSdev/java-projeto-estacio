package Aplicacao;

import Loja.Produto;

import Usuarios.Pessoa;
import Usuarios.Funcionario;
import Usuarios.Administrador;

public class Main {

	public static void main(String[] args) {
		Pessoa adm = new Administrador("felipe", "felipemail", "123", 21, "15648", "adm", 1600.0, 120.0);
		Pessoa func = new Funcionario("joao", "joaoemail", "654", 18, "468456", "vendedor", 1414.0);
		Conexao pg = new Conexao();
		
		pg.getConexao();
		System.out.println(((Funcionario)adm).getSalarioAnual());
		System.out.println(((Funcionario)func).getSalarioAnual());
		
		pg.fecharConexao();
	}

}