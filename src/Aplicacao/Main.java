package Aplicacao;

import DataAccessObject.GerenteDAO;
import DataAccessObject.ProdutoDAO;
import DataAccessObject.VendedorDAO;
import DataAccessObject.ClienteDAO;
import Model.Gerente;
import Model.Pessoa;
import Model.Produto;
import Model.Vendedor;
import Model.Cliente;

public class Main {

	public static void main(String[] args) {
		Pessoa gerente = new Gerente("gerenteNome", "gerenteEmail", "777", 44, "gerenteSenha", "gerente", 2111.54, 124.92);
		Pessoa func = new Vendedor("felix", "felixemail", "999", 27, "55555", "vendedor", 1414.0);
		Produto produto = new Produto("produtoNome3", "produtoDescricao3", 250, 219.99, "testes");
		VendedorDAO vendedorDao = new VendedorDAO();
		GerenteDAO gerenteDao = new GerenteDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		ClienteDAO clienteDao = new ClienteDAO();
		
		/*listarTodos
		for(int i = 0; i < vendedorDao.Listar().size(); i++) {
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
		}
		for(int i = 0; i < clienteDao.Listar().size(); i++) {
			Cliente clientes = clienteDao.Listar().get(i);
			System.out.println(clientes);
		}*/
		
		
		/*update
		Vendedor vendedorUpdate = vendedorDao.ListarPorCpf("654");
		vendedorUpdate.setSalario(1414.00);
		vendedorUpdate.setNome("Nikola Jokic");
		vendedorDao.Atualizar(vendedorUpdate);
		
		Gerente gerenteUpdate = gerenteDao.ListarPorCpf("123");
		gerenteUpdate.setCargo("gerente");
		gerenteUpdate.setSalario(2111.54);
		gerenteDao.Atualizar(gerenteUpdate);

		Produto produtoUpdate = produtoDao.ListarPorNome("produtoNome");
		produtoUpdate.setNome("Basketball");
		produtoDao.Atualizar(produtoUpdate);
		
		Cliente clienteUpdate = clienteDao.ListarPorCpf("5695");
		clienteUpdate.setNome("Primeiro cliente");
		clienteUpdate.setEmail("emailDoCliente");
		clienteUpdate.setEndereco("Endereco um");
		clienteUpdate.setCep("Cep um");
		clienteUpdate.setNumeroCasa("89");
		clienteUpdate.setSenha("senhaCliente");
		clienteDao.Atualizar(clienteUpdate);
		*/
		
		/*delete*/
		Cliente clienteDelete = clienteDao.ListarPorCpf("5695");
		clienteDao.Deletar(clienteDelete);
		
		Produto produtoDelete = produtoDao.ListarPorNome("novoNome");
		produtoDao.Deletar(produtoDelete);
		
		Vendedor vendedorDelete = vendedorDao.ListarPorCpf("999");
		vendedorDao.Deletar(vendedorDelete);
		
		Gerente gerenteDelete = gerenteDao.ListarPorCpf("123");
		gerenteDao.Deletar(gerenteDelete);
		
		System.out.println(vendedorDao.ListarPorCpf("999"));
		System.out.println(gerenteDao.ListarPorCpf("123"));
		System.out.println(produtoDao.ListarPorNome("novoNome"));
		System.out.println(clienteDao.ListarPorCpf("5695"));
		
	}

}