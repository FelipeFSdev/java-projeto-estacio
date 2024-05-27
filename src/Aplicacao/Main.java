package Aplicacao;

import DataAccessObject.GerenteDAO;
import DataAccessObject.ProdutoDAO;
import DataAccessObject.VendedorDAO;
import Model.Gerente;
import Model.Pessoa;
import Model.Produto;
import Model.Vendedor;

public class Main {

	public static void main(String[] args) {
		Pessoa gerente = new Gerente("gerenteNome", "gerenteEmail", "777", 44, "gerenteSenha", "gerente", 2111.54, 124.92);
		Pessoa func = new Vendedor("felix", "felixemail", "999", 27, "55555", "vendedor", 1414.0);
		Produto produto = new Produto("produtoNome3", "produtoDescricao3", 250, 219.99, "testes");
		VendedorDAO vendedorDao = new VendedorDAO();
		GerenteDAO gerenteDao = new GerenteDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		/*for(int i = 0; i < vendedorDao.Listar().size(); i++) {
			Vendedor vendedores = vendedorDao.Listar().get(i);
			System.out.println(vendedores);
		}
		for(int i = 0; i < produtoDao.Listar().size(); i++) {
			Produto produtos = produtoDao.Listar().get(i); //apenas para merito de teste **RETIRAR
			System.out.println(produtos);
		}
		for(int i = 0; i < gerenteDao.Listar().size(); i++) {
			Gerente gerentes = gerenteDao.Listar().get(i);
			System.out.println(gerentes);
		}*/
		
		System.out.println(vendedorDao.ListarPorCpf("999"));
		//vendedorDao.Atualizar(null);
		
	}

}