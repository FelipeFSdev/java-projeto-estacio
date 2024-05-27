package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Vendedor;
import Utilitarios.ConexaoBanco;

public class VendedorDAO {
	
	public List<Vendedor> Listar() {
		String sql = "SELECT * FROM pessoas WHERE cargo ILIKE 'vendedor'";		
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		Connection conn = ConexaoBanco.conectar();
		PreparedStatement pgstmt = null;
		ResultSet rset = null;
		
		try {
			pgstmt = conn.prepareStatement(sql);
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(rset != null) {
					pgstmt.close();
				}
				if(pgstmt != null) {
					pgstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vendedores;
	}
	
	public Vendedor ListarPorCpf(String cpf) {
		String sql = "SELECT * FROM pessoas WHERE cpf ILIKE ? AND cargo ILIKE 'vendedor'";
		
		Connection conn = null;
		PreparedStatement pgstmt = null;
		ResultSet rset = null;
		
		try {
			conn = ConexaoBanco.conectar();
			pgstmt = conn.prepareStatement(sql);
			pgstmt.setString(1, cpf);
			rset = pgstmt.executeQuery();
			
			if(rset.next()) {
				String nome = rset.getString("nome"), email = rset.getString("email");
				String cpfFunc = rset.getString("cpf"), senha = rset.getString("senha");
				String id = rset.getString("id"), cargo = rset.getString("cargo");
				int idade = rset.getInt("idade");
				double salario = rset.getDouble("salario");
				
				Vendedor vendedor = new Vendedor(nome, email, cpfFunc, idade, senha, cargo, salario);
				vendedor.setId(id);
				
				return vendedor;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(rset != null) {
					pgstmt.close();
				}
				if(pgstmt != null) {
					pgstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void Salvar(Vendedor vendedor) {
		 String sql = "INSERT INTO pessoas(id, nome, email, cpf, idade, senha, cargo, salario) VALUES (?,?,?,?,?,?,?,?)";
		 
		 Connection conn = null;
		 PreparedStatement pgstmt = null;
		 
		 try {
			conn = ConexaoBanco.conectar();
			
			pgstmt = conn.prepareStatement(sql);
			pgstmt.setString(1, vendedor.getId());
			pgstmt.setString(2, vendedor.getNome());
			pgstmt.setString(3, vendedor.getEmail());
			pgstmt.setString(4, vendedor.getCpf());
			pgstmt.setInt(5, vendedor.getIdade());
			pgstmt.setString(6, vendedor.getSenha());
			pgstmt.setString(7, vendedor.getCargo());
			pgstmt.setDouble(8, vendedor.getSalarioAnual());
			
			pgstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pgstmt != null) {
					pgstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Atualizar(Vendedor vendedor) {
		String sql = "UPDATE pessoas SET nome = ?, email = ?, cpf = ?, idade = ?, senha = ?, cargo = ?, salario = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pgstmt = null;
		
		try {
			conn = ConexaoBanco.conectar();
			pgstmt = conn.prepareStatement(sql);
			
			pgstmt.setString(1, vendedor.getNome());
			pgstmt.setString(2, vendedor.getEmail());
			pgstmt.setString(3, vendedor.getCpf());
			pgstmt.setInt(4,vendedor.getIdade());
			pgstmt.setString(5, vendedor.getSenha());
			pgstmt.setString(6, vendedor.getCargo());
			pgstmt.setDouble(7, vendedor.getSalarioAnual());
			
			pgstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pgstmt != null) {
					pgstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
