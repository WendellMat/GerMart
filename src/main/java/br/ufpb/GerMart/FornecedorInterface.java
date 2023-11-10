package br.ufpb.GerMart;
import java.util.List;

public interface FornecedorInterface {
    boolean cadastrarFornecedor(Fornecedor fornecedor);
    boolean apagarFornecedor(String cnpj) throws FornecedorNaoExisteException;
    List<Fornecedor> getFornecedores();
    Fornecedor pesquisarFornecedor(String cnpj);
    boolean existeFornecedor(String cnpj);
}