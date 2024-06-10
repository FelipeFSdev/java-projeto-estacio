package Telas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import DataAccessObject.ClienteDAO;
import DataAccessObject.PedidoDAO;
import DataAccessObject.PedidoProdutoDAO;
import DataAccessObject.ProdutoDAO;
import Model.Cliente;
import Model.Pedido;
import Model.PedidoProduto;
import Model.Produto;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class telaCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Produto> carrinho = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCarrinho frame = new telaCarrinho();
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
	public telaCarrinho() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		sl_contentPane.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		sl_contentPane.putConstraint(SpringLayout.VERTICAL_CENTER, panel, 0, SpringLayout.VERTICAL_CENTER, contentPane);
		panel.setPreferredSize(new Dimension(400, 600));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 40, 301, 469);
		panel.add(scrollPane);
		
		JButton btnNewButton = new JButton("Finalizar compra");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProdutoDAO produtoDao = new ProdutoDAO();
				Produto produto = produtoDao.ListarPorNome("JBL boombox 3");
				Produto produto2 = produtoDao.ListarPorNome("ventilador arno - preto");
				Produto produto3 = produtoDao.ListarPorNome("helicoptero");
				
				carrinho.add(produto);
				carrinho.add(produto2);
				carrinho.add(produto3);
				finalizarCompra();
				JOptionPane.showMessageDialog(scrollPane, "Compra finalizada com sucesso");	
				carrinho.clear();
			}
		});
		btnNewButton.setBounds(212, 536, 140, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, contentPane);
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/vermelhoebrancofundo1.jpg"));
		
		lblNewLabel.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                int width = lblNewLabel.getWidth();
	                int height = lblNewLabel.getHeight();
	                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	                lblNewLabel.setIcon(new ImageIcon(img));
	            }
	        });
		contentPane.add(lblNewLabel);
		
		
	}
	
	public void finalizarCompra() {
		//TODO código pra recuperar o cpf do cliente
		ClienteDAO clienteDao = new ClienteDAO();
		PedidoDAO pedidoDao = new PedidoDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		PedidoProdutoDAO ppDao = new PedidoProdutoDAO();
		
		Cliente cliente = clienteDao.ListarPorCpf("06142024123");
		if(cliente == null){
			JOptionPane.showMessageDialog(this, "Cliente não registrado.");
			return;
		}
		
		Pedido pedido = new Pedido(cliente.getId(), "Descrição teste");
		String pedidoId = pedido.getId();
		double valorTotalProd = 0;
		pedidoDao.Salvar(pedido);
		
		for(int i = 0; i < carrinho.size(); i++) {
			String produtoId = carrinho.get(i).getId();
			double valorProd = carrinho.get(i).getValor();
			
			PedidoProduto pedidoProduto = new PedidoProduto(pedidoId, produtoId, 1, valorProd);
			
			valorTotalProd += pedidoProduto.getQuantidadeProduto() * pedidoProduto.getValorProduto();
			pedido.setValor_total(valorTotalProd);
			pedidoDao.Atualizar(pedido);
			
			ppDao.Salvar(pedidoProduto);
			System.out.println(pedidoProduto);
		}
		System.out.println(carrinho);
		System.out.println(pedido);
	}
	
}

