package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Gerente;
import Utilitarios.ConexaoBanco;

public class GerenteDAO {
	
	public List<Gerente> Listar() {
		String sql = "SELECT * FROM pessoas WHERE cargo ILIKE 'gerente'";
		List<Gerente> gerentes = new ArrayList<>();
		
		Connection conn = ConexaoBanco.conectar();
		PreparedStatement pgstmt = null;
		ResultSet rset = null;
		
		try {
			pgstmt = conn.prepareStatement(sql);
			rset = pgstmt.executeQuery();
			
			while(rset.next()) {
				String id = rset.getString("id"), nome = rset.getString("nome");
				String email = rset.getString("email"), cpf = rset.getString("cpf");
				String senha = rset.getString("senha"), cargo = rset.getString("cargo");
				int idade = rset.getInt("idade");
				double salario = rset.getDouble("salario"), bonusDeCargo = rset.getDouble("bonus_cargo");
				
				Gerente gerente = new Gerente(nome, email, cpf, idade, cargo, senha, salario, bonusDeCargo);
				gerente.setId(id);
				
				gerentes.add(gerente);
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
		return gerentes;
	}
	
	public void Salvar(Gerente gerente) {
		String sql = "INSERT INTO pessoas (id, nome, email, cpf, idade, senha, cargo, salario, bonus_Cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexaoPg = null;
		PreparedStatement pgstmt= null;
		
		try {
			conexaoPg = ConexaoBanco.conectar();	
			pgstmt = conexaoPg.prepareStatement(sql);
			
			pgstmt.setString(1, gerente.getId());
			pgstmt.setString(2, gerente.getNome());
			pgstmt.setString(3, gerente.getEmail());
			pgstmt.setString(4, gerente.getCpf());
			pgstmt.setInt(5, gerente.getIdade());
			pgstmt.setString(6, gerente.getSenha());
			pgstmt.setString(7, gerente.getCargo());
			pgstmt.setDouble(8, gerente.getSalarioAnual());
			pgstmt.setDouble(9,gerente.getBonusDeCargo());
			
			pgstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conexaoPg != null) {
					conexaoPg.close();
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
