package br.ufpb.GerMart;

public class ProdutoNaoExisteException extends Exception{

    public ProdutoNaoExisteException(){
        super();
    }
    public ProdutoNaoExisteException(String msg){
        super(msg);
    }
}
