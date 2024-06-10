package Model;

import java.util.UUID;

public class PedidoProduto {
    private String id;
    private String pedidoId;
    private String produtoId;
    private int quantidadeProduto;
    private double valorProduto;

    public PedidoProduto() {}
    public PedidoProduto(String pedidoId, String produtoId, int quantidadeProduto, double valorProduto) {
        this.id = UUID.randomUUID().toString();
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString() {
        return "Pedido: " + pedidoId + ". Id do produto: " + produtoId + ". Quantidade: " + quantidadeProduto + ". Valor unitário: " + valorProduto;
    }
}
