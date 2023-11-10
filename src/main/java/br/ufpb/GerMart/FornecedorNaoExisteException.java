package br.ufpb.GerMart;

public class FornecedorNaoExisteException extends Exception {
    public FornecedorNaoExisteException() {
        super();
    }

    public FornecedorNaoExisteException(String mensagem) {
        super(mensagem);
    }
}