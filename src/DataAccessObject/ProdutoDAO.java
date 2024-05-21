package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Produto;
import Utilitarios.ConexaoBanco;

public class ProdutoDAO {
	
	public List<Produto> Listar(){
		String sql = "SELECT * FROM produtos";
		ArrayList<Produto> produtos = new ArrayList<>();
		
		PreparedStatement pgstmt = null;
		ResultSet rset = null;
		try {
			pgstmt = ConexaoBanco.conectar().prepareStatement(sql);
			
			rset = pgstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("id"), nome = rset.getString("nome");
				String descricao = rset.getString("descricao"), categoria = rset.getString("categoria");
				int quantidade = rset.getInt("quantidade");
				double valor = rset.getDouble("valor");
				
				Produto produto = new Produto(nome, descricao, quantidade, valor, categoria);
				produto.setId(id);
				
				produtos.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return produtos;
	}

	public void Salvar(Produto produto) {
		String sql = "INSERT INTO produtos (id, nome, descricao, quantidade, valor, categoria) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conexaoPg = null;
		PreparedStatement pgstmt = null;
		
		try {
			conexaoPg = ConexaoBanco.conectar();
			pgstmt = conexaoPg.prepareStatement(sql);
			
			pgstmt.setString(1, produto.getId());
			pgstmt.setString(2, produto.getNome());
			pgstmt.setString(3, produto.getDescricao());
			pgstmt.setInt(4, produto.getQuantidade());
			pgstmt.setDouble(5, produto.getValor());
			pgstmt.setString(6, produto.getCategoria());
			
			pgstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}