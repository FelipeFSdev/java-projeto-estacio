package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Gerente;
import Utilitarios.ConexaoBanco;

public class GerenteDAO {
	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
