package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.border.LineBorder;

import DataAccessObject.ClienteDAO;
import Model.Cliente;

import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class telaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField caixaSenha;
	private JTextField caixaUsuario;
	private JPasswordField caixaConfirmarSenha;
	private JTextField caixaIdade;
	private JTextField caixaCPF;
	private JTextField caixaEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaRegistro frame = new telaRegistro();
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
	public telaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		JPanel panel = new JPanel();
		
		layout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
        panel.setPreferredSize(new Dimension(0, 75));
		panel.setBackground(Color.RED);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel.setLayout(new SpringLayout());
		 SpringLayout panel1 = (SpringLayout) panel.getLayout();
		 
		JLabel lblNome = new JLabel("<html><span style=\"letter-spacing: 10px;\">LOJAS EUROPEIAS</span></html>");
		lblNome.setFont(new Font("Arial", Font.BOLD, 28));
		lblNome.setForeground(Color.WHITE);
		panel.add(lblNome);
			
		SpringLayout panelC = (SpringLayout) panel.getLayout();
		panelC.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblNome, 0, SpringLayout.HORIZONTAL_CENTER, panel); 
		panelC.putConstraint(SpringLayout.VERTICAL_CENTER, lblNome, 0, SpringLayout.VERTICAL_CENTER, panel);
		
		JPanel panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(400, 6));
		panel.add(panel_1);
		
		panelC.putConstraint(SpringLayout.NORTH, panel_1, 13, SpringLayout.NORTH, panel);
		panelC.putConstraint(SpringLayout.WEST, panel_1, -15, SpringLayout.WEST, lblNome);
		panelC.putConstraint(SpringLayout.EAST, panel_1, 15, SpringLayout.EAST, lblNome);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(400, 6));
		panel.add(panel_3);
		
		panelC.putConstraint(SpringLayout.NORTH, panel_3, 55, SpringLayout.NORTH, panel);
		panelC.putConstraint(SpringLayout.WEST, panel_3, -15, SpringLayout.WEST, lblNome);
		panelC.putConstraint(SpringLayout.EAST, panel_3, 15, SpringLayout.EAST, lblNome);
		
		JPanel panel_2 = new JPanel();
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel_2, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, panel_2, 0, SpringLayout.VERTICAL_CENTER, contentPane);
        panel_2.setPreferredSize(new Dimension(370, 300));
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 45, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 59, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1, 98, SpringLayout.WEST, panel_2);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 100, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 114, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 84, SpringLayout.WEST, panel_2);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(lblNewLabel_1_1);
		
		caixaSenha = new JPasswordField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaSenha, 120, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaSenha, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaSenha, 135, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaSenha, 155, SpringLayout.WEST, panel_2);
		panel_2.add(caixaSenha);
		
		caixaUsuario = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaUsuario, 75, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaUsuario, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaUsuario, 90, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaUsuario, 155, SpringLayout.WEST, panel_2);
		panel_2.add(caixaUsuario);
		caixaUsuario.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				String email = new String(caixaEmail.getText());
				String cpf = new String(caixaCPF.getText());
				String idade = new String(caixaIdade.getText());	
				String senha = new String(caixaSenha.getPassword());
				String confirmarSenha = new String(caixaConfirmarSenha.getPassword());
				String usuario = caixaUsuario.getText();
				if(usuario.equals("") || senha.equals("") || confirmarSenha.equals("") || email.equals("") || cpf.equals("") || idade.equals("")) {
					
					JOptionPane.showMessageDialog(btnRegistrar, "Todas as caixas devem estar preenchidas");
					
				}
				else if(senha.equals(confirmarSenha)){
					Cliente cliente = new Cliente();
					ClienteDAO clienteDao = new ClienteDAO();
					int idadeInt = Integer.parseInt(idade);
					
					cliente.setNome(usuario);
					cliente.setEmail(email);
					cliente.setCpf(cpf);
					cliente.setIdade(idadeInt);
					cliente.setSenha(senha);
					clienteDao.Salvar(cliente);
					
					JOptionPane.showMessageDialog(btnRegistrar, "Cadastro realizado com sucesso!");
					dispose();
					telaPrincipal telaprincipal = new telaPrincipal();
					telaprincipal.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(btnRegistrar, "As senhas devem ser iguais");
				}
			}
		});
		btnRegistrar.setBackground(new Color(240, 255, 255));
		SpringLayout panelA = (SpringLayout) panel_2.getLayout();
		panelA.putConstraint(SpringLayout.SOUTH, btnRegistrar, -20, SpringLayout.SOUTH, panel_2);
		panelA.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnRegistrar, 0, SpringLayout.HORIZONTAL_CENTER, panel_2);
		
		btnRegistrar.setPreferredSize(new Dimension(90, 20));
		panel_2.add(btnRegistrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirmar senha:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 150, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, 156, SpringLayout.WEST, panel_2);
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		panel_2.add(lblNewLabel_1_1_1);
		
		caixaConfirmarSenha = new JPasswordField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaConfirmarSenha, 170, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaConfirmarSenha, 35, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaConfirmarSenha, 185, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaConfirmarSenha, 155, SpringLayout.WEST, panel_2);
		panel_2.add(caixaConfirmarSenha);
		
		JLabel lblNewLabel_1_2 =new JLabel("Email:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 45, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, 59, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, 269, SpringLayout.WEST, panel_2);
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CPF:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1, 100, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1, 114, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1, 269, SpringLayout.WEST, panel_2);
		lblNewLabel_1_2_1.setForeground(Color.RED);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBackground(Color.WHITE);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Idade:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_1, 150, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_1, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_1, 164, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_1, 269, SpringLayout.WEST, panel_2);
		lblNewLabel_1_2_1_1.setForeground(Color.RED);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBackground(Color.WHITE);
		panel_2.add(lblNewLabel_1_2_1_1);
		
		caixaIdade = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaIdade, 170, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaIdade, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaIdade, 185, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaIdade, 326, SpringLayout.WEST, panel_2);
		caixaIdade.setColumns(10);
		
		caixaIdade.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if (!Character.isDigit(c)) {
	                    e.consume();
	                }
	            }
	        });
		  
		panel_2.add(caixaIdade);
		
		caixaCPF = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaCPF, 120, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaCPF, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaCPF, 135, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaCPF, 326, SpringLayout.WEST, panel_2);
		caixaCPF.setColumns(10);
		panel_2.add(caixaCPF);
		
		caixaEmail = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, caixaEmail, 75, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, caixaEmail, 206, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, caixaEmail, 90, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, caixaEmail, 326, SpringLayout.WEST, panel_2);
		caixaEmail.setColumns(10);
		panel_2.add(caixaEmail);
		
		JLabel lblFundo = new JLabel("New label");
        layout.putConstraint(SpringLayout.NORTH, lblFundo, 0, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, lblFundo, 0, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, lblFundo, 0, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, lblFundo, 0, SpringLayout.EAST, contentPane);
        contentPane.add(lblFundo);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/vermelhoebrancofundo1.jpg"));
        
        lblFundo.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblFundo.getWidth();
                int height = lblFundo.getHeight();
                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFundo.setIcon(new ImageIcon(img));
            }
        });
		
	}
}
