package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

import Model.Cliente;
import Model.Gerente;
import Model.Vendedor;
import Utilitarios.ConexaoBanco;

import javax.swing.SpringLayout;

public class telaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField caixaSenha;
	private JTextField caixaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 71, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		panel.setBackground(Color.RED);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 11, SpringLayout.NORTH, panel);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("LOJAS EUROPEIAS");
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, -15, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 15, SpringLayout.EAST, lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		SpringLayout panelC = (SpringLayout) panel.getLayout();
		panelC.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblNewLabel, 0, SpringLayout.HORIZONTAL_CENTER, panel); 
		panelC.putConstraint(SpringLayout.VERTICAL_CENTER, lblNewLabel, 0, SpringLayout.VERTICAL_CENTER, panel);
		
		JPanel panel_1_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1_1, 50, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1_1, -15, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1_1, 15, SpringLayout.EAST, lblNewLabel);
		panel.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel_2, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		sl_contentPane.putConstraint(SpringLayout.VERTICAL_CENTER, panel_2, 0, SpringLayout.VERTICAL_CENTER, contentPane);
		panel_2.setPreferredSize(new Dimension(260, 300));
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 89, 63, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(45, 144, 49, 14);
		panel_2.add(lblNewLabel_1_1);
		
		caixaSenha = new JPasswordField();
		caixaSenha.setBounds(95, 144, 100, 15);
		panel_2.add(caixaSenha);
		
		caixaUsuario = new JTextField();
		caixaUsuario.setBounds(95, 89, 100, 15);
		panel_2.add(caixaUsuario);
		caixaUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String senha = new String(caixaSenha.getPassword());
				String usuario = caixaUsuario.getText();
				String sql = "SELECT * FROM pessoas WHERE nome ILIKE ? AND senha ILIKE ?";
				
				Connection conn = null;
				PreparedStatement pgstmt = null;
				ResultSet rset = null;
				
				try {
					conn = ConexaoBanco.conectar();
					pgstmt = conn.prepareStatement(sql);
					pgstmt.setString(1, usuario);
					pgstmt.setString(2, senha);
					rset = pgstmt.executeQuery();
					
					if(rset.next()) {
						String id = rset.getString("id"), nome = rset.getString("nome");
						String email = rset.getString("email"), cpfCliente = rset.getString("cpf");
						String endereco = rset.getString("endereco"), cep = rset.getString("cep");
						String numeroCasa = rset.getString("numero_casa"), senhaCliente = rset.getString("senha");
						int idade = rset.getInt("idade");
						
						if(rset.getString("cargo") == null) {
							Cliente cliente = new Cliente(nome, email, cpfCliente, idade, senhaCliente, endereco, cep, numeroCasa);
							cliente.setId(id);
							
							if(usuario.equals(cliente.getNome()) && senha.equals(cliente.getSenha())) {
								
								dispose();
								telaPrincipal telaprincipal = new telaPrincipal();
								telaprincipal.setVisible(true);
								
							}
							
						} else if (rset.getString("cargo") == "vendedor") {
							String cargo = rset.getString("cargo");
							double salario = rset.getDouble("salario");
							
							Vendedor vendedor = new Vendedor(nome, email, cpfCliente, idade, senhaCliente, cargo, salario);
							vendedor.setId(id);
							
							if(usuario.equals(vendedor.getNome()) && senha.equals(vendedor.getSenha())) {
								
								dispose();
								telaPrincipal telaprincipal = new telaPrincipal();
								telaprincipal.setVisible(true);
								
							}
						}
						else {
							String cargo = rset.getString("cargo");
							double salario = rset.getDouble("salario"), bonusCargo = rset.getDouble("bonus_cargo");
							
							Gerente gerente = new Gerente(nome, email, cpfCliente, idade, senhaCliente, cargo, salario, bonusCargo);
							gerente.setId(id);
							
							if(usuario.equals(gerente.getNome()) && senha.equals(gerente.getSenha())) {
								
								dispose();
								telaPrincipal telaprincipal = new telaPrincipal();
								telaprincipal.setVisible(true);
								
							}
						}
						
						
					}
					
				} catch (SQLException error) {
					error.printStackTrace();
				} finally {
					try {
						if(conn != null) {
							conn.close();
						}
						if(pgstmt != null) {
							pgstmt.close();
						}
						if(rset != null) {
							rset.close();
						}
					} catch (SQLException error) {
						error.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setBounds(95, 236, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblImagem = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagem, 71, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagem, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagem, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagem, 0, SpringLayout.EAST, contentPane);
		contentPane.add(lblImagem);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/vermelhoebrancofundo1.jpg"));
		
		lblImagem.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblImagem.getWidth();
                int height = lblImagem.getHeight();
                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblImagem.setIcon(new ImageIcon(img));
            }
        });
		
		
	}
}
