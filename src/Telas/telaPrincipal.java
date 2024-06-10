package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class telaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int qntItens = 0;

	public int getQntItens() {
		return qntItens;
	}

	public void setQntItens(int qntItens) {
		this.qntItens = qntItens;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
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
	public telaPrincipal() {
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 81, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		panel.setBorder(new LineBorder(new Color(255, 0, 0), 5));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel labelQuantidadeItens = new JLabel("0");
		sl_panel.putConstraint(SpringLayout.NORTH, labelQuantidadeItens, 17, SpringLayout.NORTH, panel);
		panel.add(labelQuantidadeItens);
		
		JLabel lblNome = new JLabel("LOJAS EUROPEIAS");
		lblNome.setForeground(Color.RED);
		lblNome.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(lblNome);
		

		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -50, SpringLayout.SOUTH, contentPane);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				telaCozinha telacozinha = new telaCozinha();
				telacozinha.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 60, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 320, SpringLayout.WEST, contentPane);
		lblNewLabel.addComponentListener(new ComponentAdapter() {
			ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagens/copos.png"));
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblNewLabel.getWidth();
                int height = lblNewLabel.getHeight();
                Image img = icon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblNewLabel.setIcon(new ImageIcon(img));
            }
        });
		contentPane.add(lblNewLabel);
		
		SpringLayout panelC = (SpringLayout) panel.getLayout();
		panelC.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblNome, 0, SpringLayout.HORIZONTAL_CENTER, panel); 
		panelC.putConstraint(SpringLayout.VERTICAL_CENTER, lblNome, 0, SpringLayout.VERTICAL_CENTER, panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				telaEletronicos telaelet = new telaEletronicos();
				telaelet.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 350, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -70, SpringLayout.EAST, contentPane);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagens/ventilador.png"));
		
		lblNewLabel_1.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                int width = lblNewLabel_1.getWidth();
	                int height = lblNewLabel_1.getHeight();
	                Image img = icon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	                lblNewLabel_1.setIcon(new ImageIcon(img));
	            }
	        });
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1_1, 50, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1_1, -15, SpringLayout.WEST, lblNome);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1_1, 15, SpringLayout.EAST, lblNome);
		panel.add(panel_1_1);
		panel_1_1.setBackground(Color.RED);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, -15, SpringLayout.WEST, lblNome);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 15, SpringLayout.EAST, lblNome);
		panel.add(panel_1);
		panel_1.setForeground(Color.RED);
		panel_1.setBackground(Color.RED);
		
		JLabel lblCarrinho = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, labelQuantidadeItens, 10, SpringLayout.EAST, lblCarrinho);
		sl_panel.putConstraint(SpringLayout.EAST, labelQuantidadeItens, 20, SpringLayout.EAST, lblCarrinho);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCarrinho, 23, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblCarrinho, 45, SpringLayout.EAST, lblNome);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCarrinho, 50, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCarrinho, 90, SpringLayout.EAST, lblNome);
		lblCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				telaCarrinho telaCarrinho = new telaCarrinho();
				telaCarrinho.setVisible(true);
			}
		});
		panel.add(lblCarrinho);
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/imagens/carrinho.png"));
		
		lblCarrinho.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                int width = lblCarrinho.getWidth();
	                int height = lblCarrinho.getHeight();
	                Image img = icon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	                lblCarrinho.setIcon(new ImageIcon(img));
	            }
	        });
    
        
       
		JToolBar toolBar = new JToolBar();
		sl_contentPane.putConstraint(SpringLayout.NORTH, toolBar, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, toolBar, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, toolBar, 140, SpringLayout.WEST, contentPane);
		toolBar.setFloatable(false);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("Eletrônicos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				telaEletronicos telaeletro = new telaEletronicos();
				dispose();
				telaeletro.setVisible(true);
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cozinha");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  telaCozinha telaCozinha = new telaCozinha();
				  dispose();
				  telaCozinha.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_1);
		
		JLabel lblImagem = new JLabel("");
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagem, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagem, 0, SpringLayout.WEST, panel);
		
		
		
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagem, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagem, 0, SpringLayout.EAST, contentPane);
		lblImagem.setAlignmentX(5.0f);
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

	public void setQntItens(String text) {
		// TODO Auto-generated method stub
		
	}
}
