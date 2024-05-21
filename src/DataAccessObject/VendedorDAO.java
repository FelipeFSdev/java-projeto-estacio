package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Vendedor;
import Utilitarios.ConexaoBanco;

public class VendedorDAO {
	
	public List<Vendedor> Listar() {
		String sql = "SELECT * FROM pessoas WHERE cargo ILIKE 'vendedor'";
		
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		PreparedStatement pgstmt = null;
		ResultSet rset = null;
		
		try {
			pgstmt = ConexaoBanco.conectar().prepareStatement(sql);
			
			rset = pgstmt.executeQuery();
			while (rset.next()) {
				String id = rset.getString("id"), nome = rset.getString("nome");
				String email = rset.getString("email"), cpf = rset.getString("cpf");
				String cargo = rset.getString("cargo"), senha = rset.getString("senha");
				int idade = rset.getInt("idade");
				double salario = (rset.getDouble("salario")/12);
				Vendedor vendedor = new Vendedor(nome, email, cpf, idade, senha, cargo, salario);
				vendedor.setId(id);
				
				vendedores.add(vendedor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendedores;
	}

	public void Salvar(Vendedor vendedor) {
		 String sql = "INSERT INTO pessoas(id, nome, email, cpf, idade, senha, cargo, salario) VALUES (?,?,?,?,?,?,?,?)";
		 
		 Connection conexaoPg = null;
		 PreparedStatement pgstmt = null;
		 
		 try {
			conexaoPg = ConexaoBanco.conectar();
			
			pgstmt = conexaoPg.prepareStatement(sql);
			pgstmt.setString(1, vendedor.getId());
			pgstmt.setString(2, vendedor.getNome());
			pgstmt.setString(3, vendedor.getEmail());
			pgstmt.setString(4, vendedor.getCpf());
			pgstmt.setInt(5, vendedor.getIdade());
			pgstmt.setString(6, vendedor.getSenha());
			pgstmt.setString(7, vendedor.getCargo());
			pgstmt.setDouble(8, vendedor.getSalarioAnual());
			
			pgstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
