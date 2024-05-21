package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Utilitarios.ConexaoBanco;

public class ClienteDAO {

	public void Salvar(Cliente cliente) {
		String sql = "INSERT INTO pessoas (id, nome, email, cpf, idade, endereco, cep, numero_casa VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexaoPg = null;
		PreparedStatement pgstmt = null;
		
		try {
			conexaoPg = ConexaoBanco.conectar();
			pgstmt = conexaoPg.prepareStatement(sql);
			
			pgstmt.setString(1, cliente.getId());
			pgstmt.setString(2, cliente.getNome());
			pgstmt.setString(3, cliente.getEmail());
			pgstmt.setString(4, cliente.getCpf());
			pgstmt.setInt(5, cliente.getIdade());
			pgstmt.setString(6, cliente.getEndereco());
			pgstmt.setString(7, cliente.getCep());
			pgstmt.setString(8, cliente.getNumeroCasa());
			
			pgstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
