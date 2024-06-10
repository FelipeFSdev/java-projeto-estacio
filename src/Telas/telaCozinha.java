package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class telaCozinha extends JFrame {
	
	int contador1 = 0;
	int contador2 = 0;
	int contador3 = 0;
	int contador5 = 0;
	
	telaPrincipal carrinho = new telaPrincipal();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCozinha frame = new telaCozinha();
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
	public telaCozinha() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		panel.setBackground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 80, SpringLayout.NORTH, contentPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 20, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 40, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -20, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -40, SpringLayout.EAST, contentPane);
		
		panel_1.setPreferredSize(new Dimension(260, 300));
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblImage2 = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblImage2, 20, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblImage2, 20, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblImage2, -250, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblImage2, -600, SpringLayout.EAST, panel_1);
		lblImage2.setPreferredSize(new Dimension(10, 10));
		panel_1.add(lblImage2);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagens/pratospng.png"));
		
		lblImage2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblImage2.getWidth();
                int height = lblImage2.getHeight();
                Image img = icon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblImage2.setIcon(new ImageIcon(img));
            }
        });
		
		JPanel panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 100, SpringLayout.NORTH, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.EAST, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -30, SpringLayout.SOUTH, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 138, SpringLayout.EAST, lblImage2);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(35, 0, 53, 41);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel caixaContador1 = new JLabel("0");
		caixaContador1.setBounds(20, -3, 38, 34);
		caixaContador1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel_5.add(caixaContador1);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				
				contador1++;
				caixaContador1.setText(""+ contador1);
				carrinho.setQntItens(caixaContador1.getText());
				
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(96, 0, 46, 25);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador1--;
				caixaContador1.setText(""+contador1);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(12, 2, 29, 25);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblImage3 = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblImage3, 60, SpringLayout.SOUTH, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblImage3, 0, SpringLayout.WEST, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblImage3, -38, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblImage3, 0, SpringLayout.EAST, lblImage2);
		lblImage3.setPreferredSize(new Dimension(10, 10));
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/imagens/telheres.png"));
		lblImage2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblImage3.getWidth();
                int height = lblImage3.getHeight();
                Image img1 = icon3.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblImage3.setIcon(new ImageIcon(img1));
            }
        });
		panel_1.add(lblImage3);
		
		JLabel lblImage4 = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblImage4, 0, SpringLayout.NORTH, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblImage4, 240, SpringLayout.EAST, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblImage4, 0, SpringLayout.SOUTH, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblImage4, -180, SpringLayout.EAST, panel_1);
		lblImage4.setPreferredSize(new Dimension(10, 10));
		panel_1.add(lblImage4);
		
		JPanel panel_4_1 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1, 0, SpringLayout.NORTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1, -10, SpringLayout.EAST, panel_1);
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_4_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(35, 0, 53, 41);
		panel_4_1.add(panel_5_1);
		
		JLabel lblNewLabel_2 = new JLabel("+");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(7, 0, 46, 25);
		panel_4_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(103, 0, 29, 25);
		panel_4_1.add(lblNewLabel_1_1);
		
		JPanel panel_6 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, panel_4);
		panel_6.setBackground(Color.LIGHT_GRAY);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_6, 10, SpringLayout.EAST, lblImage4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_6, 138, SpringLayout.EAST, lblImage4);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(38, 0, 49, 31);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel caixaContador4 = new JLabel("0");
		caixaContador4.setBounds(14, -3, 39, 34);
		caixaContador4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel_7.add(caixaContador4);
		
		JLabel lblNewLabel_1_2 = new JLabel("-");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador3--;
				caixaContador4.setText(""+ contador3);
			}
		});
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_2.setBounds(13, 2, 29, 25);
		panel_6.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("+");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador3++;
				caixaContador4.setText(""+ contador3);
				
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_3.setBounds(96, 0, 46, 25);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 31,90");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, -30, SpringLayout.NORTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -10, SpringLayout.NORTH, panel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.EAST, lblImage2);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, panel_4);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Jogo de Pratos");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1, -20, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4_1, -5, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1, 10, SpringLayout.EAST, panel_4);
		lblNewLabel_4_1.setBackground(new Color(240, 240, 240));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1, 10, SpringLayout.EAST, lblImage2);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("R$ 22,99");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_2, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_2, 10, SpringLayout.EAST, lblImage4);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_2, 0, SpringLayout.EAST, panel_6);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Jogo de Copos");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1_1, 0, SpringLayout.NORTH, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1_1, 10, SpringLayout.EAST, lblImage4);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1_1, 0, SpringLayout.EAST, panel_6);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.LIGHT_GRAY);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_8, 90, SpringLayout.NORTH, lblImage3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -30, SpringLayout.SOUTH, lblImage3);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel_4);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(35, 0, 55, 32);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel caixaContador2 = new JLabel("0");
		caixaContador2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		caixaContador2.setBounds(19, -2, 38, 34);
		panel_9.add(caixaContador2);
		
		JLabel lblNewLabel_5 = new JLabel("+");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador2++;
				caixaContador2.setText(""+ contador2);
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_5.setBounds(96, 2, 46, 25);
		panel_8.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("-");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador2--;
				caixaContador2.setText(""+ contador2);
			}
		});
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_3.setBounds(12, 2, 29, 25);
		panel_8.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("R$ 27,99");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_3, 0, SpringLayout.WEST, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4_3, -6, SpringLayout.NORTH, panel_8);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_3, 0, SpringLayout.EAST, lblNewLabel_4);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Jogo de Talheres");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1_2, 0, SpringLayout.WEST, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4_1_2, -1, SpringLayout.NORTH, lblNewLabel_4_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1_2, 50, SpringLayout.EAST, lblNewLabel_4_1);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_2.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(lblNewLabel_4_1_2);
		
		JLabel lblImage5 = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblImage5, 15, SpringLayout.NORTH, lblImage3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblImage5, 15, SpringLayout.WEST, lblImage4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblImage5, 0, SpringLayout.SOUTH, lblImage3);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblImage5, 0, SpringLayout.EAST, lblImage4);
		lblImage5.setPreferredSize(new Dimension(10, 10));
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/imagens/panelas.png"));
		lblImage5.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblImage5.getWidth();
                int height = lblImage5.getHeight();
                Image img2 = icon5.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblImage5.setIcon(new ImageIcon(img2));
            }
        });
		panel_1.add(lblImage5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.LIGHT_GRAY);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel_8);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_10, 0, SpringLayout.WEST, panel_6);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_10, 0, SpringLayout.SOUTH, panel_8);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_10, 0, SpringLayout.EAST, panel_6);
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(38, 0, 49, 31);
		panel_10.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel caixaContador5 = new JLabel("0");
		caixaContador5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		caixaContador5.setBounds(14, -3, 39, 34);
		panel_11.add(caixaContador5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("-");
		lblNewLabel_1_2_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador5--;
				caixaContador5.setText("" + contador5);
			}
		});
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_2_1.setBounds(13, 2, 29, 25);
		panel_10.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("+");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contador5++;
				caixaContador5.setText(""+ contador5);
			}
		});
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_3_1.setBounds(97, 0, 46, 25);
		panel_10.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("R$ 265,90");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_3_1, 0, SpringLayout.WEST, lblNewLabel_4_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4_3_1, 0, SpringLayout.SOUTH, lblNewLabel_4_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_3_1, 0, SpringLayout.EAST, panel_6);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Conjunto de Panelas");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1_2_1, 0, SpringLayout.NORTH, lblNewLabel_4_1_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1_2_1, 0, SpringLayout.WEST, lblNewLabel_4_1_1);
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_2_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(lblNewLabel_4_1_2_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				caixaContador1.setText("0");
				caixaContador2.setText("0");
				caixaContador4.setText("0");
				caixaContador5.setText("0");
				
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_12, -35, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_12, 0, SpringLayout.WEST, panel_10);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_12, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_12, 0, SpringLayout.EAST, panel_1);
		panel_1.add(panel_12);
		SpringLayout sl_panel_12 = new SpringLayout();
		panel_12.setLayout(sl_panel_12);
		
		JLabel lblNewLabel_6 = new JLabel("Adicionar ao Carrinho");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			
			
			}
			});
		
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		sl_panel_12.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 5, SpringLayout.NORTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.WEST, lblNewLabel_6, 15, SpringLayout.WEST, panel_12);
		sl_panel_12.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -5, SpringLayout.SOUTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.EAST, lblNewLabel_6, -15, SpringLayout.EAST, panel_12);
		panel_12.add(lblNewLabel_6);
		
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/imagens/copos.png"));
		lblImage2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = lblImage4.getWidth();
                int height = lblImage4.getHeight();
                Image img2 = icon4.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblImage4.setIcon(new ImageIcon(img2));
            }
        });
		
		
		
		
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		JLabel lblNome = new JLabel("<html><span style=\"letter-spacing: 10px;\">LOJAS EUROPEIAS</span></html>");
		lblNome.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				carrinho.setVisible(true);
			}
		});
		lblNome.setFont(new Font("Arial", Font.BOLD, 28));
		lblNome.setForeground(Color.WHITE);
		panel.add(lblNome);
		
		JLabel lblSeta = new JLabel("");
		lblSeta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				carrinho.setVisible(true);
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, lblSeta, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblSeta, 11, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSeta, 30, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblSeta, 45, SpringLayout.WEST, panel);
		ImageIcon seta = new ImageIcon(getClass().getResource("/imagens/seta branca.png"));
		
		lblSeta.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                int width = lblSeta.getWidth();
	                int height = lblSeta.getHeight();
	                Image img = seta.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	                lblSeta.setIcon(new ImageIcon(img));
	            }
	        });
		panel.add(lblSeta);
			
		SpringLayout panelC = (SpringLayout) panel.getLayout();
		panelC.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblNome, 0, SpringLayout.HORIZONTAL_CENTER, panel); 
		panelC.putConstraint(SpringLayout.VERTICAL_CENTER, lblNome, 0, SpringLayout.VERTICAL_CENTER, panel);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 15, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, -15, SpringLayout.WEST, lblNome);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 15, SpringLayout.EAST, lblNome);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 55, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, -15, SpringLayout.WEST, lblNome);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 15, SpringLayout.EAST, lblNome);
		panel.add(panel_3);
		
		JLabel lblImagem = new JLabel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagem, 0, SpringLayout.SOUTH, panel);
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
