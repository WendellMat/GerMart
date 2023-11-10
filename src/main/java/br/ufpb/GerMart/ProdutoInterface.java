package br.ufpb.GerMart;

import java.util.List;

public interface ProdutoInterface {
    boolean cadastrarProduto(Produto produto);

    boolean apagarProduto(String codigoDeBarras)throws ProdutoNaoExisteException;

    List<Produto> getProdutos();

    Produto pesquisarProduto(String CodigoDeBarras)throws ProdutoNaoExisteException;
    
    boolean existeProduto(String codigoDeBarras);

}