package br.ufpb.GerMart;

import java.util.Objects;

public class Fornecedor {
    private String nomeFantasia;
    private String cnpj;
    private String contato;

    public Fornecedor() {
        this.nomeFantasia = "";
        this.cnpj = "";
        this.contato = "";
    }
    public Fornecedor(String nomeFantasia, String cnpj, String contato) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fornecedor that = (Fornecedor) o;

        if (!Objects.equals(nomeFantasia, that.nomeFantasia)) return false;
        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        int result = nomeFantasia != null ? nomeFantasia.hashCode() : 0;
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "Fornecedor: "+this.nomeFantasia+"\nCNPJ: "+this.cnpj+"\nContato: "+this.contato;
    }
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getCnpj() {
        return this.cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getContato() {
        return this.contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
}