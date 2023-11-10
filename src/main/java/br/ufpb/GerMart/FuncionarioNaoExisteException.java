package br.ufpb.GerMart;

public class FuncionarioNaoExisteException extends Exception {
    public FuncionarioNaoExisteException(){
        super();
    }
    public FuncionarioNaoExisteException(String msg){
        super(msg);
    }
}