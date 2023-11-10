package br.ufpb.GerMart;

import java.util.Objects;
public class Produto  {

    private String nome;

    private String codigoDeBarras;

    private String fornecedor;

    private String valorDeCompra;

    private String valorDeVenda;

    public Produto(){
        this("","","","","");
    }
        public Produto(String nome, String codigoDeBarras, String fornecedor, String valorDeCompra, String valorDeVenda){
        this.nome = nome;
        this.codigoDeBarras = codigoDeBarras;
        this.fornecedor = fornecedor;
        this.valorDeCompra = valorDeCompra;
        this.valorDeVenda = valorDeVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (!Objects.equals(nome, produto.nome)) return false;
        return Objects.equals(codigoDeBarras, produto.codigoDeBarras);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (codigoDeBarras != null ? codigoDeBarras.hashCode() : 0);
        return result;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome ){

        this.nome = nome;
    }
    public String getCodigoDeBarras(){

        return codigoDeBarras;
    }
    public void setCodigoDeBarras (String codigoDeBarras){

        this.codigoDeBarras = codigoDeBarras;
    }
    public String getFornecedor(){

        return fornecedor;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;

    }
    public String getValorDeCompra(){
        return valorDeCompra;
    }
    public void setValorDeCompra(String valorDeCompra){

        this.valorDeCompra = valorDeCompra;
    }
    public String getValorDeVenda(){

        return valorDeVenda;
    }
    public void setValorDeVenda(String valorDeVenda){

        this.valorDeVenda = valorDeVenda;
    }
    public String toString(){
        return "Nome do Produto: " + getNome() + "\nCodigo de Barras: " + getCodigoDeBarras()
                + "\nFornecedor: " + getFornecedor();
    }

}
