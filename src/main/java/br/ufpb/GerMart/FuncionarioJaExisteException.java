package br.ufpb.GerMart;

public class FuncionarioJaExisteException extends Exception {
    public FuncionarioJaExisteException (String msg){
        super(msg);
    }
}
