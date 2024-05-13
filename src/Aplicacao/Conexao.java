package Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url = "jdbc:postgresql://localhost:5432/ProjetoFacul";
    private String usuario = "postgres";
    private String senha = "356428";
    private Connection conexao;

    public Conexao() {
        conectar();
    }

    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem sucedida com o banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do PostgreSQL não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão.");
                e.printStackTrace();
            }
        }
    }
}
