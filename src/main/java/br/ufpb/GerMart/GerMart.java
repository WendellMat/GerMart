package br.ufpb.GerMart;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GerMart {
    public static void main(String args[]) throws IOException, ProdutoNaoExisteException, FuncionarioJaExisteException,
            FuncionarioNaoExisteException, FornecedorNaoExisteException {
        ProdutoInterface gerenciadorDeProdutos = null;
        FuncionarioInterface gerenciadorDeFuncionarios = null;
        FornecedorInterface gerenciadorDeFornecedores = null;
        GravadorLeitorDeDados gerenciadorDeDados = new GravadorLeitorDeDados();

        try {
            List<Produto> produtosRecuperados = gerenciadorDeDados.lerProdutos();
            List<Funcionario> funcionariosRecuperados = gerenciadorDeDados.lerFuncionarios();
            List<Fornecedor> fornecedoresRecuperados = gerenciadorDeDados.lerFornecedores();
            gerenciadorDeProdutos = new ProdutoList(produtosRecuperados);
            gerenciadorDeFuncionarios = new FuncionarioList(funcionariosRecuperados);
            gerenciadorDeFornecedores = new FornecedorList(fornecedoresRecuperados);
            JOptionPane.showMessageDialog(null, "Dados recuperados");
        } catch (IOException ex) {
            gerenciadorDeProdutos = new ProdutoList();
            gerenciadorDeFuncionarios = new FuncionarioList();
            gerenciadorDeFornecedores = new FornecedorList();
            JOptionPane.showMessageDialog(null, "Não conseguimos recuperar os dados");
        }

        String sentenca1 = "Produtos", sentenca2 = "Funcionarios", sentenca3 = "Fornecedores", sentenca4 = "Salvar dados", sentenca5 = "Sair";

        Object opcoes[] = {sentenca1, sentenca2, sentenca3, sentenca4, sentenca5};

        boolean sair = false;
        while (!sair) {
            String escolha = (String) JOptionPane.showInputDialog(null,
                    "Selecione o que você deseja:\n", "GerMart",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

            int opcao = 0;
            if (escolha != null) {
                if (escolha.equals(sentenca1)) {
                    opcao = 1;
                } else if (escolha.equals(sentenca2)) {
                    opcao = 2;
                } else if (escolha.equals(sentenca3)) {
                    opcao = 3;
                } else if (escolha.equals(sentenca4)) {
                    opcao = 4;
                } else if (escolha.equals(sentenca5)) {
                    opcao = 5;
                }
            } else {
                sair = true;
            }

            switch (opcao) {
                case 1:
                    String cadastrarProduto = "Cadastrar produto", apagarProduto = "Apagar produto", listarProduto = "Listar produtos", pesquisarProduto = "Pesquisar produto", sairProduto = "Sair";

                    Object opcoesDeProdutos[] = {cadastrarProduto, apagarProduto, listarProduto, pesquisarProduto, sairProduto};

                    String escolhaOpcaoDeProduto = (String) JOptionPane.showInputDialog(null,
                            "Selecione o que você deseja:\n", "GerMart - Produtos",
                            JOptionPane.PLAIN_MESSAGE, null, opcoesDeProdutos, "");

                    int opcaoDeProduto = 0;
                    if (escolhaOpcaoDeProduto != null) {
                        if (escolhaOpcaoDeProduto.equals(cadastrarProduto)) {
                            opcaoDeProduto = 1;
                        } else if (escolhaOpcaoDeProduto.equals(apagarProduto)) {
                            opcaoDeProduto = 2;
                        } else if (escolhaOpcaoDeProduto.equals(listarProduto)) {
                            opcaoDeProduto = 3;
                        } else if (escolhaOpcaoDeProduto.equals(pesquisarProduto)) {
                            opcaoDeProduto = 4;
                        } else if (escolhaOpcaoDeProduto.equals(sairProduto)) {
                            opcaoDeProduto = 5;
                        }
                    } else {
                        sair = true;
                    }

                    switch (opcaoDeProduto) {
                        case 1:
                            String nomeDoProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
                            String codigoDoProduto = JOptionPane.showInputDialog("Digite o código de barras do produto:");
                            String fornecedorDoProduto = JOptionPane.showInputDialog("Digite o fornecedor do produto:");
                            String valorDeCompra = JOptionPane.showInputDialog("Qual o valor de compra?");
                            String valorDeVenda = JOptionPane.showInputDialog("Qual o valor de venda?");
                            Produto produto1 = new Produto(nomeDoProduto, codigoDoProduto, fornecedorDoProduto, valorDeCompra, valorDeVenda);
                            if (gerenciadorDeProdutos.cadastrarProduto(produto1)) {
                                JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Produto não cadastrado, pois já existe um produto com o mesmo código de barras");
                            }
                            break;

                        case 2:
                            String codigoDoProdutoCaso2 = JOptionPane.showInputDialog("Digite o código de barras do produto que você deseja apagar:");
                            try {
                                gerenciadorDeProdutos.apagarProduto(codigoDoProdutoCaso2);
                                JOptionPane.showMessageDialog(null, "Produto apagado com sucesso");
                            } catch (ProdutoNaoExisteException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                            break;

                        case 3:
                            List<Produto> listaDosProdutosAtualmenteCadastrados = gerenciadorDeProdutos.getProdutos();
                            JPanel panelProdutosCadastrados = new JPanel(new GridLayout(listaDosProdutosAtualmenteCadastrados.size(), 1));
                            for (Produto p : listaDosProdutosAtualmenteCadastrados) {
                                JLabel label = new JLabel(p.getNome());
                                panelProdutosCadastrados.add(label);
                            }
                            JScrollPane scrollPaneProdutosCadastrados = new JScrollPane(panelProdutosCadastrados);
                            JOptionPane.showMessageDialog(null, scrollPaneProdutosCadastrados, "Todos os produtos cadastrados", JOptionPane.PLAIN_MESSAGE);
                            break;

                        case 4:
                            String codigoDeBarrasCaso4 = JOptionPane.showInputDialog("Digite o código de barras do produto que você deseja pesquisar:");
                            if  (gerenciadorDeProdutos.pesquisarProduto(codigoDeBarrasCaso4) != null) {
                                JOptionPane.showMessageDialog(null, (gerenciadorDeProdutos.pesquisarProduto(codigoDeBarrasCaso4)).toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "Esse produto não existe");
                            }
                            break;

                        case 5:
                            gerenciadorDeDados.gravarProdutos(gerenciadorDeProdutos.getProdutos());
                            gerenciadorDeDados.gravarFuncionarios(gerenciadorDeFuncionarios.getFuncionarios());
                            gerenciadorDeDados.gravarFornecedores(gerenciadorDeFornecedores.getFornecedores());
                            JOptionPane.showMessageDialog(null, "Finalizando o programa");
                            sair = true;
                            break;
                    }
                    break;

                case 2:
                    String cadastrarFuncionario = "Cadastrar funcionário", apagarFuncionario = "Apagar funcionário", listarFuncionarios = "Listar funcionários", pesquisarFuncionario = "Pesquisar funcionário", sairFuncionario = "Sair";

                    Object opcoesDeFuncionarios[] = {cadastrarFuncionario, apagarFuncionario, listarFuncionarios, pesquisarFuncionario, sairFuncionario};

                    String escolhaOpcaoDeFuncionario = (String) JOptionPane.showInputDialog(null,
                            "Selecione o que você deseja:\n", "GerMart - Funcionários",
                            JOptionPane.PLAIN_MESSAGE, null, opcoesDeFuncionarios, "");

                    int opcaoDeFuncionario = 0;
                    if (escolhaOpcaoDeFuncionario != null) {
                        if (escolhaOpcaoDeFuncionario.equals(cadastrarFuncionario)) {
                            opcaoDeFuncionario = 1;
                        } else if (escolhaOpcaoDeFuncionario.equals(apagarFuncionario)) {
                            opcaoDeFuncionario = 2;
                        } else if (escolhaOpcaoDeFuncionario.equals(listarFuncionarios)) {
                            opcaoDeFuncionario = 3;
                        } else if (escolhaOpcaoDeFuncionario.equals(pesquisarFuncionario)) {
                            opcaoDeFuncionario = 4;
                        } else if (escolhaOpcaoDeFuncionario.equals(sairFuncionario)) {
                            opcaoDeFuncionario = 5;
                        }
                    } else {
                        sair = true;
                    }

                    switch (opcaoDeFuncionario) {
                        case 1:
                            String nomeDoFuncionario = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                            String matriculaDoFuncionarioCaso1 = JOptionPane.showInputDialog("Digite a matrícula do funcionário:");
                            String setorDoFuncionario = JOptionPane.showInputDialog("Digite o setor que o funcionário irá trabalhar:");
                            String cargoDoFuncionario = JOptionPane.showInputDialog("Qual cargo o funcionário irá ocupar?");
                            Funcionario funcionario1 = new Funcionario(nomeDoFuncionario, matriculaDoFuncionarioCaso1, setorDoFuncionario, cargoDoFuncionario);
                            gerenciadorDeFuncionarios.cadastrarFuncionario(funcionario1);
                            break;

                        case 2:
                            String matriculaDoFuncionarioCaso2 = JOptionPane.showInputDialog("Digite a matrícula do funcionário que você deseja apagar:");
                            try {
                                gerenciadorDeFuncionarios.apagarFuncionario(matriculaDoFuncionarioCaso2);
                                JOptionPane.showMessageDialog(null, "Funcionário apagado com sucesso");
                            } catch (FuncionarioNaoExisteException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                            break;

                        case 3:
                            List<Funcionario> listaDosFuncionariosAtualmenteCadastrados = gerenciadorDeFuncionarios.getFuncionarios();
                            JPanel panelFuncionariosCadastrados = new JPanel(new GridLayout(listaDosFuncionariosAtualmenteCadastrados.size(), 1));
                            for (Funcionario f : listaDosFuncionariosAtualmenteCadastrados) {
                                JLabel label = new JLabel(f.getNome());
                                panelFuncionariosCadastrados.add(label);
                            }
                            JScrollPane scrollPaneFuncionariosCadastrados = new JScrollPane(panelFuncionariosCadastrados);
                            JOptionPane.showMessageDialog(null, scrollPaneFuncionariosCadastrados, "Todos os funcionários cadastrados", JOptionPane.PLAIN_MESSAGE);
                            break;

                        case 4:
                            String matriculaDoFuncionarioCaso4 = JOptionPane.showInputDialog("Digite a matrícula do funcionário que você deseja pesquisar:");
                            try {
                                JOptionPane.showMessageDialog(null, (gerenciadorDeFuncionarios.pesquisarFuncionario(matriculaDoFuncionarioCaso4)).toString());
                            } catch (FuncionarioNaoExisteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;

                        case 5:
                            gerenciadorDeDados.gravarProdutos(gerenciadorDeProdutos.getProdutos());
                            gerenciadorDeDados.gravarFuncionarios(gerenciadorDeFuncionarios.getFuncionarios());
                            gerenciadorDeDados.gravarFornecedores(gerenciadorDeFornecedores.getFornecedores());
                            JOptionPane.showMessageDialog(null, "Finalizando o programa");
                            sair = true;
                            break;
                    }
                    break;

                case 3:
                    String cadastrarFornecedor = "Cadastrar fornecedor", apagarFornecedor = "Apagar fornecedor", listarFornecedores = "Listar fornecedores", pesquisarFornecedor = "Pesquisar Fornecedor", sairFornecedor = "Sair";

                    Object opcoesDeFornecedores[] = {cadastrarFornecedor, apagarFornecedor, listarFornecedores, pesquisarFornecedor, sairFornecedor};

                    String escolhaOpcaoDeFornecedor = (String) JOptionPane.showInputDialog(null,
                            "Selecione o que você deseja:\n", "GerMart - Fornecedores",
                            JOptionPane.PLAIN_MESSAGE, null, opcoesDeFornecedores, "");

                    int opcaoDeFornecedor = 0;
                    if (escolhaOpcaoDeFornecedor != null) {
                        if (escolhaOpcaoDeFornecedor.equals(cadastrarFornecedor)) {
                            opcaoDeFornecedor = 1;
                        } else if (escolhaOpcaoDeFornecedor.equals(apagarFornecedor)) {
                            opcaoDeFornecedor = 2;
                        } else if (escolhaOpcaoDeFornecedor.equals(listarFornecedores)) {
                            opcaoDeFornecedor = 3;
                        } else if (escolhaOpcaoDeFornecedor.equals(pesquisarFornecedor)) {
                            opcaoDeFornecedor = 4;
                        } else if (escolhaOpcaoDeFornecedor.equals(sairFornecedor)) {
                            opcaoDeFornecedor = 5;
                        }
                    } else {
                        sair = true;
                    }

                    switch (opcaoDeFornecedor) {
                        case 1:
                            String nomeDoFornecedor = JOptionPane.showInputDialog("Digite o nome fantasia do fornecedor:");
                            String cnpjDoFornecedorCaso1 = JOptionPane.showInputDialog("Digite o cnpj do fornecedor:");
                            String contatoDoFornecedor = JOptionPane.showInputDialog("Digite o contato do fornecedor:");
                            Fornecedor fornecedor1 = new Fornecedor(nomeDoFornecedor, cnpjDoFornecedorCaso1, contatoDoFornecedor);
                            if (gerenciadorDeFornecedores.cadastrarFornecedor(fornecedor1)) {
                                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possível cadastrá-lo. Esse CNPJ já está relacionado a algum fornecedor");
                            }
                            break;

                        case 2:
                            String cnpjDoFornecedorCaso2 = JOptionPane.showInputDialog("Digite o cnpj do fornecedor que você deseja apagar:");
                            try {
                                gerenciadorDeFornecedores.apagarFornecedor(cnpjDoFornecedorCaso2);
                                JOptionPane.showMessageDialog(null, "Fornecedor apagado com sucesso");
                            } catch (FornecedorNaoExisteException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                            }
                            break;

                        case 3:
                            List<Fornecedor> listaDosFornecedoresAtualmenteCadastrados = gerenciadorDeFornecedores.getFornecedores();
                            JPanel panelFornecedoresCadastrados = new JPanel(new GridLayout(listaDosFornecedoresAtualmenteCadastrados.size(), 1));
                            for (Fornecedor f : listaDosFornecedoresAtualmenteCadastrados) {
                                JLabel label = new JLabel(f.getNomeFantasia());
                                panelFornecedoresCadastrados.add(label);
                            }
                            JScrollPane scrollPaneFornecedoresCadastrados = new JScrollPane(panelFornecedoresCadastrados);
                            JOptionPane.showMessageDialog(null, scrollPaneFornecedoresCadastrados, "Todos os fornecedores cadastrados", JOptionPane.PLAIN_MESSAGE);
                            break;

                        case 4:
                            String cnpjDoFornecedorCaso4 = JOptionPane.showInputDialog("Digite o cnpj do fornecedor que você deseja pesquisar:");
                            if (gerenciadorDeFornecedores.pesquisarFornecedor(cnpjDoFornecedorCaso4) != null) {
                                JOptionPane.showMessageDialog(null, (gerenciadorDeFornecedores.pesquisarFornecedor(cnpjDoFornecedorCaso4)).toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "Fornecedor não existe");
                            }
                            break;

                        case 5:
                            gerenciadorDeDados.gravarProdutos(gerenciadorDeProdutos.getProdutos());
                            gerenciadorDeDados.gravarFuncionarios(gerenciadorDeFuncionarios.getFuncionarios());
                            gerenciadorDeDados.gravarFornecedores(gerenciadorDeFornecedores.getFornecedores());
                            JOptionPane.showMessageDialog(null, "Finalizando o programa");
                            sair = true;
                            break;
                    }
                    break;

                case 4:
                    if (gerenciadorDeDados.gravarProdutos(gerenciadorDeProdutos.getProdutos()) &&
                            gerenciadorDeDados.gravarFuncionarios(gerenciadorDeFuncionarios.getFuncionarios()) &&
                            gerenciadorDeDados.gravarFornecedores(gerenciadorDeFornecedores.getFornecedores())) {
                        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar os arquivos");
                    }
                    break;

                case 5:
                    gerenciadorDeDados.gravarProdutos(gerenciadorDeProdutos.getProdutos());
                    gerenciadorDeDados.gravarFuncionarios(gerenciadorDeFuncionarios.getFuncionarios());
                    gerenciadorDeDados.gravarFornecedores(gerenciadorDeFornecedores.getFornecedores());
                    JOptionPane.showMessageDialog(null, "Finalizando o programa");
                    sair = true;
                    break;
            }
        }
    }
}