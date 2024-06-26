package Model;

import java.util.Objects;
import java.util.UUID;

public class Produto {
	private String id;
	private String nome;
	private String descricao;
	private int quantidade;
	private double valor;
	private String categoria;
	
	public Produto(
			String nome, String descricao, 
			int quantidade, double valor, 
			String categoria
	){
		id = UUID.randomUUID().toString();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.categoria = categoria;
	};
	public Produto(
			String nome, 
			int quantidade, double valor, 
			String categoria
	){
		id = UUID.randomUUID().toString();
		this.nome = nome;
		this.descricao = null;
		this.quantidade = quantidade;
		this.valor = valor;
		this.categoria = categoria;
	};
	
	public String getId() {
		return this.id;
	}
	public void setId(String novoId) {
		this.id = novoId;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int novaQuantidade) {
		this.quantidade = novaQuantidade;
	}
	
	public double getValor() {
		return this.valor;
	}
	public void setValor(double novoValor) {
		this.valor = novoValor;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String novaCategoria) {
		this.categoria = novaCategoria;
	}
	@Override
	public String toString() {
		return "Produto:" + nome + ". Descrição:" + descricao + ". Quantidade:" + quantidade
				+ ". Valor:" + valor + ". Categoria:" + categoria;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return Objects.equals(nome, produto.nome);
        // Compare outros campos se necessário...
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
        // Combine hashcodes de outros campos se necessário...
    }
	
}