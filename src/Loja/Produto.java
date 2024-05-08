package Loja;

import java.util.UUID;

public class Produto {
	protected String id;
	protected String nome;
	protected int quantidade;
	protected double valor;
	protected String categoria;
	
	public Produto(
			String nome, int quantidade,
			double valor, String categoria
	){
		id = UUID.randomUUID().toString();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.categoria = categoria;
	};
	
	public String listarProduto(String nome){
		if(nome != this.nome) {
			return "Produto não encontrado.";
		}
		return this.nome + "\n" + this.valor;
	}
	
	public String detalharProduto(String nome) {
		if(nome != this.nome) {
			return "Produto não encontrado.";
		}
		return 
				this.id + "\n" +
				this.nome + "\n" +
				this.quantidade + "\n" +
				this.valor + "\n" + 
				this.categoria;
	}
	
}