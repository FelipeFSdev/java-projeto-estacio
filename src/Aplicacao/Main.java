package Aplicacao;

import Utilitarios.ConexaoBanco;
import DataAccessObject.VendedorDAO;
import Model.Gerente;
import Model.Pessoa;
import Model.Vendedor;

public class Main {

	public static void main(String[] args) {
		Pessoa adm = new Gerente("felipe", "felipemail", "123", 21, "15648", "adm", 1600.0, 120.0);
		Pessoa func = new Vendedor("joao", "joaoemail", "654", 18, "468456", "vendedor", 1414.0);
		ConexaoBanco pg = new ConexaoBanco();
		VendedorDAO vendedorDao = new VendedorDAO();
		
		pg.getConexao();
		vendedorDao.Salvar((Vendedor) adm);
		System.out.println(((Vendedor)adm).getSalarioAnual());
		System.out.println(((Vendedor)func).getSalarioAnual());
		
		pg.fecharConexao();
	}

}