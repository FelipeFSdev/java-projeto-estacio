package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Vendedor;
import Utilitarios.ConexaoBanco;

public class VendedorDAO {

	public void Salvar(Vendedor vendedor) {
		 String sql = "INSERT INTO pessoas(id, nome, email, cpf, idade, senha, cargo, salario) VALUES (?,?,?,?,?,?,?,?)";
		 ConexaoBanco pg = new ConexaoBanco();
		 
		 Connection conexaoPg = null;
		 PreparedStatement pgstmt = null;
		 
		 try {
			conexaoPg = ConexaoBanco.conectar();
			
			pgstmt = (PreparedStatement) conexaoPg.prepareStatement(sql);
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
			
		} finally {
			try {
				if(pgstmt != null) {
					pgstmt.close();
				}
				if(conexaoPg != null) {
					conexaoPg.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
