package br.ufpb.GerMart;

import java.util.ArrayList;
import java.util.List;

public class FornecedorList implements FornecedorInterface {
    private List<Fornecedor> fornecedores;

    public FornecedorList() {
        this.fornecedores = new ArrayList<>();
    }
    public FornecedorList(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public boolean cadastrarFornecedor(Fornecedor fornecedor) {
        if (existeFornecedor(fornecedor.getCnpj())) {
            return false;
        } else {
            this.fornecedores.add(fornecedor);
            return true;
        }
    }
    public boolean apagarFornecedor(String cnpj) throws FornecedorNaoExisteException {
        if (existeFornecedor(cnpj)) {
            for (Fornecedor f : this.fornecedores) {
                if (f.getCnpj().equals(cnpj)) {
                    this.fornecedores.remove(f);
                    return true;
                }
            }
        }
        throw new FornecedorNaoExisteException("Fornecedor não existe, por isso, não foi possível apagá-lo.");
    }
    public List<Fornecedor> getFornecedores() {
        return this.fornecedores;
    }
    public Fornecedor pesquisarFornecedor(String cnpj) {
        if (existeFornecedor(cnpj)) {
            for (Fornecedor f : this.fornecedores) {
                if (f.getCnpj().equals(cnpj)) {
                    return f;
                }
            }
        }
        return null;
    }

    public boolean existeFornecedor(String cnpj) {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpj)) {
                return true;
            }
        }
        return false;
    }
}