package br.ufpb.GerMart;

import java.util.ArrayList;
import java.util.List;

public class ProdutoList implements ProdutoInterface  {
    private List<Produto> produtos;

    public ProdutoList(){
        this.produtos = new ArrayList<>();

    }
    public ProdutoList(List<Produto> produtos) {
    	 this.produtos = produtos;
    	
    }

    public boolean existeProduto(String codigoDeBarras){
        for(Produto ep : produtos){
            if(ep.getCodigoDeBarras().equals(codigoDeBarras)){
               return true; 
            }
       }return false;
    }


    public boolean cadastrarProduto (Produto produto) {
        if (existeProduto(produto.getCodigoDeBarras())) {
            return false;
        } else {
            produtos.add(produto);
            return true;
        }
    }
    public boolean apagarProduto (String codigoDeBarras) throws ProdutoNaoExisteException {
        for(Produto ap : produtos) {
            if (ap.getCodigoDeBarras().equals(codigoDeBarras)) {
                produtos.remove(ap);
                return true;
            }

        }
        throw new ProdutoNaoExisteException("Produto não existe, por isso, não foi possivel apagá-lo.");
    }

    public List<Produto> getProdutos(){

        return this.produtos;
    }
    public Produto pesquisarProduto(String codigoDeBarras) throws ProdutoNaoExisteException {
        Produto produtoPesquisado = null;
        for(Produto pp : this.produtos){
            if(pp.getCodigoDeBarras().equals(codigoDeBarras)){
                produtoPesquisado = pp;
            }
        }
        return produtoPesquisado;
    }
}
