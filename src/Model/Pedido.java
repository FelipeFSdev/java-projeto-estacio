package Model;

import java.util.UUID;

public class Pedido {
	private String id;
	private String pessoaId;
	private String descricao;
	private double valorTotal;

	public Pedido(){}
	public Pedido(String pessoaId, String descricao) {
		this.id = UUID.randomUUID().toString();
		this.pessoaId = pessoaId;
		this.descricao = descricao;
		this.valorTotal = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(String pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValor_total(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		return "Pedido: " + id + ". Id do cliente: " + pessoaId + ". Descrição: " + descricao + ". Valor total: " + valorTotal;
	}
	
}
