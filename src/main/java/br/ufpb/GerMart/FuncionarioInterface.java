package br.ufpb.GerMart;
import java.util.List;
public interface FuncionarioInterface {
    void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException;
    boolean apagarFuncionario(String matricula) throws FuncionarioNaoExisteException;
    List<Funcionario>getFuncionarios();
    Funcionario pesquisarFuncionario(String matricula) throws FuncionarioNaoExisteException;
    boolean existeFuncionario(String matricula);
}
