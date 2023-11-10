package br.ufpb.GerMart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorLeitorDeDados {
    private String arquivosProdutos = "Produtos.txt";
    private String arquivosFuncionarios = "Funcionarios.txt";
    private String arquivosFornecedores = "Fornecedores.txt";

    public void GravadorLeitorDeDados() {
        this.arquivosProdutos = "Produtos.txt";
        this.arquivosFuncionarios = "Funcionarios.txt";
        this.arquivosFornecedores = "Fornecedores.txt";
    }

    public boolean gravarProdutos(List<Produto> produtos) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(this.arquivosProdutos));
            for (Produto p : produtos) {
                String linhaProduto = p.getNome()+";"+p.getCodigoDeBarras()+";"+p.getFornecedor()+";"+p.getValorDeCompra()+";"+p.getValorDeVenda();
                gravador.write(linhaProduto+"\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
                return true;
            } else {
                gravador.close();
                return false;
            }
        }
    }
    public List<Produto> lerProdutos() throws IOException {
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(this.arquivosProdutos));
            List<Produto> produtosEncontrados = new ArrayList<>();
            String linhaLidaProduto = null;

            do {
                linhaLidaProduto = leitor.readLine();
                if (linhaLidaProduto != null) {
                    String produto[] = linhaLidaProduto.split(";");
                    Produto produtoDaLinha = new Produto(produto[0], produto[1], produto[2], produto[3], produto[4]);
                    produtosEncontrados.add(produtoDaLinha);
                }
            } while (linhaLidaProduto != null);
            return produtosEncontrados;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }

    public boolean gravarFuncionarios(List<Funcionario> funcionarios) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(this.arquivosFuncionarios));
            for (Funcionario f : funcionarios) {
                String linhaFuncionario = f.getNome()+";"+f.getMatricula()+";"+f.getSetor()+";"+f.getCargo();
                gravador.write(linhaFuncionario+"\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
                return true;
            } else {
                gravador.close();
                return false;
            }
        }
    }
    public List<Funcionario> lerFuncionarios() throws IOException {
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(this.arquivosFuncionarios));
            List<Funcionario> funcionariosEncontrados = new ArrayList<>();
            String linhaLidaFuncionario = null;

            do {
                linhaLidaFuncionario = leitor.readLine();
                if (linhaLidaFuncionario != null) {
                    String funcionario[] = linhaLidaFuncionario.split(";");
                    Funcionario funcionarioDaLinha = new Funcionario(funcionario[0], funcionario[1], funcionario[2], funcionario[3]);
                    funcionariosEncontrados.add(funcionarioDaLinha);
                }
            } while (linhaLidaFuncionario != null);
            return funcionariosEncontrados;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }

    public boolean gravarFornecedores(List<Fornecedor> fornecedores) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(this.arquivosFornecedores));
            for (Fornecedor f : fornecedores) {
                String linhaFornecedor = f.getNomeFantasia()+";"+f.getCnpj()+";"+f.getContato();
                gravador.write(linhaFornecedor+"\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
                return true;
            } else {
                gravador.close();
                return false;
            }
        }
    }
    public List<Fornecedor> lerFornecedores() throws IOException {
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(this.arquivosFornecedores));
            List<Fornecedor> fornecedoresEncontrados = new ArrayList<>();
            String linhaLidaFornecedor = null;

            do {
                linhaLidaFornecedor = leitor.readLine();
                if (linhaLidaFornecedor != null) {
                    String fornecedor[] = linhaLidaFornecedor.split(";");
                    Fornecedor funcionarioDaLinha = new Fornecedor(fornecedor[0], fornecedor[1], fornecedor[2]);
                    fornecedoresEncontrados.add(funcionarioDaLinha);
                }
            } while (linhaLidaFornecedor != null);
            return fornecedoresEncontrados;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }
}