package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObject.ProdutoDAO;
import DataAccessObject.VendedorDAO;
import Model.Cliente;
import Model.Produto;
import Model.Vendedor;
import Utilitarios.ConexaoBanco;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class telaGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabelaProdutos;
	private JTable tabelaVendedor;
	private JTextField caixaNomeProduto;
	private JTextField caixaDescricao;
	private JTextField caixaQuantidade;
	private JTextField caixaValor;
	private JTextField CaixaCategoria;
	private JTextField caixaNomeVendedor;
	private JTextField caixaEmail;
	private JTextField caixaCpf;
	private JTextField caixaIdade;
	private JPasswordField passwordField;
	private JTextField caixaCargo;
	private JTextField caixaSalario;
	DefaultTableModel modeloVendedor = new DefaultTableModel();
	DefaultTableModel modeloProduto = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaGerente frame = new telaGerente();
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
	public telaGerente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel_1_3.setBounds(842, 72, 220, 408);
		contentPane.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 36, 169, 361);
		panel_1_3.add(scrollPane_1);
		
		tabelaVendedor = new JTable();
		scrollPane_1.setViewportView(tabelaVendedor);
		
		Object[] tituloVendedor = {
				"Nome", "Email",
				"Cpf", "Idade",
				};
		modeloVendedor.setColumnIdentifiers(tituloVendedor);
		tabelaVendedor.setModel(modeloVendedor);
		
		Object[] linhaVendedor = new Object[5];
		
		VendedorDAO vendedorDao = new VendedorDAO();
		for(int i = 0; i < vendedorDao.Listar().size(); i++) {
			linhaVendedor[0] = vendedorDao.Listar().get(i).getNome();
			linhaVendedor[1] = vendedorDao.Listar().get(i).getEmail();
			linhaVendedor[2] = vendedorDao.Listar().get(i).getCpf();
			linhaVendedor[3] = vendedorDao.Listar().get(i).getIdade();
			modeloVendedor.addRow(linhaVendedor);
		}
		
		JLabel lblListarVendedores = new JLabel("Listar vendedores");
		lblListarVendedores.setFont(new Font("Arial", Font.BOLD, 14));
		lblListarVendedores.setBounds(45, 11, 142, 17);
		panel_1_3.add(lblListarVendedores);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel_1_2.setBounds(538, 72, 274, 408);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblCadastroVendedir = new JLabel("Cadastro vendedor");
		lblCadastroVendedir.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastroVendedir.setBounds(45, 11, 142, 17);
		panel_1_2.add(lblCadastroVendedir);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 30, 46, 14);
		panel_1_2.add(lblNewLabel_1_2);
		
		caixaNomeVendedor = new JTextField();
		caixaNomeVendedor.setColumns(10);
		caixaNomeVendedor.setBounds(10, 55, 102, 20);
		panel_1_2.add(caixaNomeVendedor);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email:");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(10, 86, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1);
		
		caixaEmail = new JTextField();
		caixaEmail.setColumns(10);
		caixaEmail.setBounds(10, 111, 102, 20);
		panel_1_2.add(caixaEmail);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("CPF:");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBounds(10, 142, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1_1);
		
		caixaCpf = new JTextField();
		caixaCpf.setColumns(10);
		caixaCpf.setBounds(10, 167, 102, 20);
		panel_1_2.add(caixaCpf);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Idade:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1.setBounds(10, 198, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1_1_1);
		
		caixaIdade = new JTextField();
		caixaIdade.setColumns(10);
		caixaIdade.setBounds(10, 223, 102, 20);
		panel_1_2.add(caixaIdade);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Senha:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 254, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 279, 102, 20);
		panel_1_2.add(passwordField);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(151, 30, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1_1_1_1_1);
		
		caixaCargo = new JTextField();
		caixaCargo.setColumns(10);
		caixaCargo.setBounds(151, 55, 102, 20);
		panel_1_2.add(caixaCargo);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("Salário:");
		lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1_1_1_1.setBounds(151, 86, 46, 14);
		panel_1_2.add(lblNewLabel_1_2_1_1_1_1_1_1);
		
		caixaSalario = new JTextField();
		caixaSalario.setColumns(10);
		caixaSalario.setBounds(151, 111, 102, 20);
		panel_1_2.add(caixaSalario);
		
		JButton btncadastrar_2 = new JButton("Cadastrar");
		btncadastrar_2.setBounds(155, 210, 98, 23);
		panel_1_2.add(btncadastrar_2);
		btncadastrar_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String nome = caixaNomeVendedor.getText(), email = caixaEmail.getText();
				String cpf = caixaCpf.getText(), senha = new String(passwordField.getPassword());
				String cargo = caixaCargo.getText(), idade = caixaIdade.getText();
				String salario = caixaSalario.getText();
				VendedorDAO vendedorDao = new VendedorDAO();
			
				if(nome.equals("") || email.equals("") || cpf.equals("") || idade.equals("") || senha.equals("") || cargo.equals("") || salario.equals("")) {
					JOptionPane.showMessageDialog(btncadastrar_2, "Todas as caixas devem estar preenchidas");
					return;
				}
				if(!"vendedor".equals(cargo)) {
					JOptionPane.showMessageDialog(btncadastrar_2, "Cargo inválido.");
					return;
				}				
				int idadeInt = Integer.parseInt(idade);
				double salarioDouble = Double.parseDouble(salario);
				
				Vendedor vendedorDuplicado = vendedorDao.ListarPorCpf(cpf);
				if(vendedorDuplicado != null) {
					System.err.println("Cpf já cadastrado no banco de dados");
					JOptionPane.showMessageDialog(btncadastrar_2, "Cpf já cadastrado no banco de dados");
					return;
				}
				
				Vendedor vendedor = new Vendedor(nome, email, cpf, idadeInt, senha, cargo, salarioDouble);
				vendedorDao.Salvar(vendedor);
				JOptionPane.showMessageDialog(btncadastrar_2, "Cadastro realizado com sucesso!");
				
				dispose();
				telaGerente telaGerente = new telaGerente();
				telaGerente.setVisible(true);
			}
		});
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel_1_1.setBounds(279, 72, 220, 408);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblListarProdutos = new JLabel("Listar produtos");
		lblListarProdutos.setFont(new Font("Arial", Font.BOLD, 14));
		lblListarProdutos.setBounds(52, 11, 142, 17);
		panel_1_1.add(lblListarProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 36, 169, 361);
		panel_1_1.add(scrollPane);
		
		tabelaProdutos = new JTable();
		scrollPane.setViewportView(tabelaProdutos);
		
		Object[] tituloProduto = {
				"Nome", "Quantidade",
				"Valor", "Categoria",
				"Descrição"};
		modeloProduto.setColumnIdentifiers(tituloProduto);
		tabelaProdutos.setModel(modeloProduto);
		
		Object[] linhaProduto = new Object[5];
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		for(int i = 0; i < produtoDao.Listar().size(); i++) {
			linhaProduto[0] = produtoDao.Listar().get(i).getNome();
			linhaProduto[1] = produtoDao.Listar().get(i).getQuantidade();
			linhaProduto[2] = produtoDao.Listar().get(i).getValor();
			linhaProduto[3] = produtoDao.Listar().get(i).getCategoria();
			linhaProduto[4] = produtoDao.Listar().get(i).getDescricao();
			modeloProduto.addRow(linhaProduto);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel_1.setBounds(10, 72, 220, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar produto");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(41, 11, 142, 17);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrição:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 104, 59, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 178, 73, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Valor: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 245, 46, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 307, 73, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		caixaNomeProduto = new JTextField();
		caixaNomeProduto.setBounds(10, 64, 124, 20);
		panel_1.add(caixaNomeProduto);
		caixaNomeProduto.setColumns(10);
		
		caixaDescricao = new JTextField();
		caixaDescricao.setColumns(10);
		caixaDescricao.setBounds(10, 129, 124, 20);
		panel_1.add(caixaDescricao);
		
		caixaQuantidade = new JTextField();
		caixaQuantidade.setColumns(10);
		caixaQuantidade.setBounds(10, 203, 124, 20);
		panel_1.add(caixaQuantidade);
		
		caixaValor = new JTextField();
		caixaValor.setColumns(10);
		caixaValor.setBounds(10, 270, 124, 20);
		panel_1.add(caixaValor);
		
		CaixaCategoria = new JTextField();
		CaixaCategoria.setColumns(10);
		CaixaCategoria.setBounds(10, 332, 124, 20);
		panel_1.add(CaixaCategoria);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.setBounds(58, 374, 100, 23);
		panel_1.add(btncadastrar);
		
		btncadastrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String nome = caixaNomeProduto.getText(), quantidade = caixaQuantidade.getText();
				String valor = caixaValor.getText(), categoria = CaixaCategoria.getText();
				String descricao = caixaDescricao.getText();
				ProdutoDAO produtoDao = new ProdutoDAO();
				
				if(nome.equals("") || quantidade.equals("") || valor.equals("") || categoria.equals("") || descricao.equals("")) {
					JOptionPane.showMessageDialog(btncadastrar, "Todos os campos devem ser preenchidos");
					return;
				}
				Produto produtoDuplicado = produtoDao.ListarPorNome(nome);
				if(produtoDuplicado != null) {
					System.err.println("Produto já cadastrado no banco de dados");
					JOptionPane.showMessageDialog(btncadastrar, "Produto já cadastrado no banco de dados");
					return;
				}
				
				int quantidadeInt = Integer.parseInt(quantidade);
				double valorDouble = Double.parseDouble(valor);
				
				Produto produto = new Produto(nome, descricao, quantidadeInt, valorDouble, categoria);
				produtoDao.Salvar(produto);
				JOptionPane.showMessageDialog(btncadastrar, "Cadastro de produto realizado com sucesso!");
				
				dispose();
				telaGerente telaGerente = new telaGerente();
				telaGerente.setVisible(true);
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel.setBounds(0, 0, 1072, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("LOJAS EUROPEIAS");
		lblNome.setBounds(405, 15, 262, 33);
		lblNome.setForeground(Color.RED);
		lblNome.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(lblNome);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(395, 7, 281, 10);
		panel.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.RED);
		panel_2_1.setBounds(395, 44, 281, 10);
		panel.add(panel_2_1);
		
		JLabel lblImagem = new JLabel("New label");
		lblImagem.setIcon(new ImageIcon(telaGerente.class.getResource("/imagens/vermelhoebrancofundo1.jpg")));
		lblImagem.setBounds(0, 0, 1072, 491);
		contentPane.add(lblImagem);
	}
}